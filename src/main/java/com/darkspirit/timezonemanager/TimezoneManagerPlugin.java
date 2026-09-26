package com.darkspirit.timezonemanager;

import org.bstats.bukkit.Metrics;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TimezoneManagerPlugin extends JavaPlugin {
    private static final int BSTATS_PLUGIN_ID = 34335;

    private TimezoneService timezoneService;

    @Override
    public void onLoad() {
        saveDefaultConfig();
        timezoneService = new TimezoneService(this);
        timezoneService.loadAndApplyConfiguredTimezone();
    }

    @Override
    public void onEnable() {
        if (timezoneService == null) {
            timezoneService = new TimezoneService(this);
            timezoneService.loadAndApplyConfiguredTimezone();
        }

        PluginCommand command = getCommand("timezone");
        if (command == null) {
            getLogger().severe("Unable to register /timezone. Check plugin.yml.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        TimezoneCommand executor = new TimezoneCommand(this, timezoneService);
        command.setExecutor(executor);
        command.setTabCompleter(executor);

        startMetrics();
        getLogger().info("Global timezone: " + timezoneService.getZoneId().getId());
    }

    @Override
    public void onDisable() {
        if (timezoneService != null) {
            timezoneService.restoreOriginalDefaults();
        }
    }

    private void startMetrics() {
        try {
            new Metrics(this, BSTATS_PLUGIN_ID);
        } catch (RuntimeException ex) {
            getLogger().warning("bStats could not be initialized: " + ex.getMessage());
        }
    }
}
