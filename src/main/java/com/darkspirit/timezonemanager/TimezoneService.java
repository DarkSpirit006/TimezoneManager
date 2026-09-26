package com.darkspirit.timezonemanager;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class TimezoneService {
    private static final DateTimeFormatter DISPLAY_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z",
            Locale.ROOT);

    private final TimezoneManagerPlugin plugin;
    private final TimezoneRuntime runtime;
    private volatile ZoneId currentZone;

    public TimezoneService(TimezoneManagerPlugin plugin) {
        this.plugin = plugin;
        this.runtime = new TimezoneRuntime(plugin.getLogger());
    }

    public void loadAndApplyConfiguredTimezone() {
        String configured = plugin.getConfig().getString("timezone", "system");
        if (configured == null || configured.trim().isEmpty() || "system".equalsIgnoreCase(configured.trim())) {
            resetToSystem();
            return;
        }

        try {
            ZoneId zone = resolve(configured);
            apply(zone);
        } catch (IllegalArgumentException ex) {
            plugin.getLogger().severe("Invalid timezone '" + configured + "': " + ex.getMessage());
            plugin.getLogger().warning("Using the original JVM timezone: " + runtime.getOriginalZoneId());
            resetToSystem();
        }
    }

    public synchronized ZoneId setConfiguredTimezone(String input) {
        ZoneId zone = resolve(input);
        apply(zone);
        return zone;
    }

    public synchronized void resetToSystem() {
        runtime.restore();
        currentZone = ZoneId.systemDefault();
        saveConfiguredValue("system");
    }

    public ZoneId resolve(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Timezone cannot be empty.");
        }

        String value = input.trim();
        String alias = TimezoneIds.alias(value);
        if (alias != null) {
            value = alias;
        }

        String canonical = TimezoneIds.findCanonical(value);
        if (canonical != null) {
            return ZoneId.of(canonical);
        }

        try {
            return ZoneId.of(value);
        } catch (DateTimeException ex) {
            throw new IllegalArgumentException("Unknown timezone. Use an IANA ID such as Asia/Kolkata.");
        }
    }

    public ZoneId getZoneId() {
        ZoneId zone = currentZone;
        return zone == null ? ZoneId.systemDefault() : zone;
    }

    public String getFormattedNow() {
        return ZonedDateTime.now(getZoneId()).format(DISPLAY_TIME);
    }

    public String getOffsetText() {
        int totalSeconds = ZonedDateTime.now(getZoneId()).getOffset().getTotalSeconds();
        int absolute = Math.abs(totalSeconds);
        int hours = absolute / 3600;
        int minutes = (absolute % 3600) / 60;
        return String.format(Locale.ROOT, "UTC%s%02d:%02d", totalSeconds >= 0 ? "+" : "-", hours, minutes);
    }

    public String getOriginalZoneId() {
        return runtime.getOriginalZoneId();
    }

    public void restoreOriginalDefaults() {
        runtime.restore();
        currentZone = ZoneId.systemDefault();
    }

    private void apply(ZoneId zone) {
        runtime.set(zone);
        currentZone = zone;
        saveConfiguredValue(zone.getId());
    }

    private void saveConfiguredValue(String value) {
        plugin.getConfig().set("timezone", value);
        plugin.saveConfig();
    }
}
