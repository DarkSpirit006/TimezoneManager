package com.darkspirit.timezonemanager;

import java.time.ZoneId;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

final class TimezoneRuntime {
    private final TimeZone originalTimeZone;
    private final boolean hadOriginalUserTimezone;
    private final String originalUserTimezone;
    private final String originalZoneId;
    private final Logger logger;

    TimezoneRuntime(Logger logger) {
        this.logger = logger;
        hadOriginalUserTimezone = System.getProperties().containsKey("user.timezone");
        originalUserTimezone = System.getProperty("user.timezone");
        originalTimeZone = TimeZone.getDefault();
        originalZoneId = originalTimeZone.getID();
    }

    synchronized void set(ZoneId zone) {
        TimeZone.setDefault(TimeZone.getTimeZone(zone));
        try {
            System.setProperty("user.timezone", zone.getId());
        } catch (SecurityException ex) {
            logger.log(Level.FINE, "Unable to update the user.timezone system property.", ex);
        }
    }

    synchronized void restore() {
        TimeZone.setDefault((TimeZone) originalTimeZone.clone());
        try {
            if (hadOriginalUserTimezone) {
                System.setProperty("user.timezone", originalUserTimezone);
            } else {
                System.clearProperty("user.timezone");
            }
        } catch (SecurityException ex) {
            logger.log(Level.FINE, "Unable to restore the user.timezone system property.", ex);
        }
    }

    String getOriginalZoneId() {
        return originalZoneId;
    }
}
