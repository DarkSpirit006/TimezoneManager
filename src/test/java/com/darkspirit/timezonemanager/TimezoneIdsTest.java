package com.darkspirit.timezonemanager;

import org.junit.Test;

import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimezoneIdsTest {
    @Test
    public void findsCanonicalIdsCaseInsensitively() {
        assertEquals("Asia/Kolkata", TimezoneIds.findCanonical("asia/kolkata"));
        assertEquals("UTC", TimezoneIds.findCanonical("utc"));
    }

    @Test
    public void cityAliasesResolveToCanonicalZones() {
        assertEquals("Asia/Kolkata", TimezoneIds.alias("Kolkata"));
        assertEquals("America/New_York", TimezoneIds.alias("new_york"));
    }

    @Test
    public void prefixSearchReturnsMatchingTimezoneIds() {
        List<String> results = TimezoneIds.search("Asia/Kolk", 10);
        assertTrue(results.contains("Asia/Kolkata"));
    }

    @Test
    public void commonListContainsExpectedZonesWhenAvailable() {
        assertEquals("Asia/Kolkata", ZoneId.of("Asia/Kolkata").getId());
        assertTrue(TimezoneIds.common().contains("Asia/Kolkata"));
    }
}
