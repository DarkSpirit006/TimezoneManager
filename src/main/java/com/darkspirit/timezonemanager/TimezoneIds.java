package com.darkspirit.timezonemanager;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class TimezoneIds {
    private static final Map<String, String> CANONICAL_BY_LOWER;
    private static final List<String> SORTED_IDS;
    private static final Map<String, String> CITY_ALIASES;

    static {
        Map<String, String> ids = new HashMap<String, String>();
        for (String id : ZoneId.getAvailableZoneIds()) {
            ids.put(id.toLowerCase(Locale.ROOT), id);
        }
        ids.put("utc", "UTC");
        ids.put("gmt", "GMT");
        CANONICAL_BY_LOWER = Collections.unmodifiableMap(ids);

        List<String> sorted = new ArrayList<String>(ids.values());
        Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
        SORTED_IDS = Collections.unmodifiableList(sorted);

        Map<String, String> aliases = new HashMap<String, String>();
        alias(aliases, "kolkata", "Asia/Kolkata");
        alias(aliases, "calcutta", "Asia/Kolkata");
        alias(aliases, "mumbai", "Asia/Kolkata");
        alias(aliases, "bombay", "Asia/Kolkata");
        alias(aliases, "delhi", "Asia/Kolkata");
        alias(aliases, "new_delhi", "Asia/Kolkata");
        alias(aliases, "india", "Asia/Kolkata");
        alias(aliases, "bangalore", "Asia/Kolkata");
        alias(aliases, "bengaluru", "Asia/Kolkata");
        alias(aliases, "hyderabad", "Asia/Kolkata");
        alias(aliases, "chennai", "Asia/Kolkata");
        alias(aliases, "madras", "Asia/Kolkata");
        alias(aliases, "pune", "Asia/Kolkata");
        alias(aliases, "ahmedabad", "Asia/Kolkata");
        alias(aliases, "jaipur", "Asia/Kolkata");
        alias(aliases, "lucknow", "Asia/Kolkata");
        alias(aliases, "dhaka", "Asia/Dhaka");
        alias(aliases, "yangon", "Asia/Yangon");
        alias(aliases, "rangoon", "Asia/Yangon");
        alias(aliases, "bangkok", "Asia/Bangkok");
        alias(aliases, "jakarta", "Asia/Jakarta");
        alias(aliases, "singapore", "Asia/Singapore");
        alias(aliases, "kuala_lumpur", "Asia/Kuala_Lumpur");
        alias(aliases, "kl", "Asia/Kuala_Lumpur");
        alias(aliases, "manila", "Asia/Manila");
        alias(aliases, "hong_kong", "Asia/Hong_Kong");
        alias(aliases, "hk", "Asia/Hong_Kong");
        alias(aliases, "taipei", "Asia/Taipei");
        alias(aliases, "tokyo", "Asia/Tokyo");
        alias(aliases, "osaka", "Asia/Tokyo");
        alias(aliases, "seoul", "Asia/Seoul");
        alias(aliases, "pyongyang", "Asia/Pyongyang");
        alias(aliases, "beijing", "Asia/Shanghai");
        alias(aliases, "shanghai", "Asia/Shanghai");
        alias(aliases, "chongqing", "Asia/Chongqing");
        alias(aliases, "urumqi", "Asia/Urumqi");
        alias(aliases, "ulaanbaatar", "Asia/Ulaanbaatar");
        alias(aliases, "vladivostok", "Asia/Vladivostok");
        alias(aliases, "yakutsk", "Asia/Yakutsk");
        alias(aliases, "novosibirsk", "Asia/Novosibirsk");
        alias(aliases, "almaty", "Asia/Almaty");
        alias(aliases, "tashkent", "Asia/Tashkent");
        alias(aliases, "bishkek", "Asia/Bishkek");
        alias(aliases, "dushanbe", "Asia/Dushanbe");
        alias(aliases, "ashgabat", "Asia/Ashgabat");
        alias(aliases, "kabul", "Asia/Kabul");
        alias(aliases, "karachi", "Asia/Karachi");
        alias(aliases, "islamabad", "Asia/Karachi");
        alias(aliases, "tehran", "Asia/Tehran");
        alias(aliases, "baghdad", "Asia/Baghdad");
        alias(aliases, "riyadh", "Asia/Riyadh");
        alias(aliases, "jeddah", "Asia/Riyadh");
        alias(aliases, "dubai", "Asia/Dubai");
        alias(aliases, "abu_dhabi", "Asia/Dubai");
        alias(aliases, "abudhabi", "Asia/Dubai");
        alias(aliases, "doha", "Asia/Qatar");
        alias(aliases, "kuwait", "Asia/Kuwait");
        alias(aliases, "jerusalem", "Asia/Jerusalem");
        alias(aliases, "amman", "Asia/Amman");
        alias(aliases, "beirut", "Asia/Beirut");
        alias(aliases, "damascus", "Asia/Damascus");
        alias(aliases, "baku", "Asia/Baku");
        alias(aliases, "tbilisi", "Asia/Tbilisi");
        alias(aliases, "yerevan", "Asia/Yerevan");
        alias(aliases, "nicosia", "Asia/Nicosia");
        alias(aliases, "london", "Europe/London");
        alias(aliases, "dublin", "Europe/Dublin");
        alias(aliases, "lisbon", "Europe/Lisbon");
        alias(aliases, "paris", "Europe/Paris");
        alias(aliases, "berlin", "Europe/Berlin");
        alias(aliases, "frankfurt", "Europe/Berlin");
        alias(aliases, "amsterdam", "Europe/Amsterdam");
        alias(aliases, "brussels", "Europe/Brussels");
        alias(aliases, "zurich", "Europe/Zurich");
        alias(aliases, "geneva", "Europe/Zurich");
        alias(aliases, "rome", "Europe/Rome");
        alias(aliases, "milan", "Europe/Rome");
        alias(aliases, "madrid", "Europe/Madrid");
        alias(aliases, "barcelona", "Europe/Madrid");
        alias(aliases, "vienna", "Europe/Vienna");
        alias(aliases, "prague", "Europe/Prague");
        alias(aliases, "warsaw", "Europe/Warsaw");
        alias(aliases, "budapest", "Europe/Budapest");
        alias(aliases, "athens", "Europe/Athens");
        alias(aliases, "bucharest", "Europe/Bucharest");
        alias(aliases, "sofia", "Europe/Sofia");
        alias(aliases, "helsinki", "Europe/Helsinki");
        alias(aliases, "stockholm", "Europe/Stockholm");
        alias(aliases, "oslo", "Europe/Oslo");
        alias(aliases, "copenhagen", "Europe/Copenhagen");
        alias(aliases, "reykjavik", "Atlantic/Reykjavik");
        alias(aliases, "moscow", "Europe/Moscow");
        alias(aliases, "kyiv", "Europe/Kiev");
        alias(aliases, "kiev", "Europe/Kiev");
        alias(aliases, "minsk", "Europe/Minsk");
        alias(aliases, "istanbul", "Europe/Istanbul");
        alias(aliases, "ankara", "Europe/Istanbul");
        alias(aliases, "cairo", "Africa/Cairo");
        alias(aliases, "johannesburg", "Africa/Johannesburg");
        alias(aliases, "cape_town", "Africa/Johannesburg");
        alias(aliases, "capetown", "Africa/Johannesburg");
        alias(aliases, "nairobi", "Africa/Nairobi");
        alias(aliases, "lagos", "Africa/Lagos");
        alias(aliases, "casablanca", "Africa/Casablanca");
        alias(aliases, "accra", "Africa/Accra");
        alias(aliases, "addis_ababa", "Africa/Addis_Ababa");
        alias(aliases, "addisababa", "Africa/Addis_Ababa");
        alias(aliases, "tunis", "Africa/Tunis");
        alias(aliases, "algiers", "Africa/Algiers");
        alias(aliases, "new_york", "America/New_York");
        alias(aliases, "newyork", "America/New_York");
        alias(aliases, "washington", "America/New_York");
        alias(aliases, "boston", "America/New_York");
        alias(aliases, "atlanta", "America/New_York");
        alias(aliases, "miami", "America/New_York");
        alias(aliases, "detroit", "America/Detroit");
        alias(aliases, "chicago", "America/Chicago");
        alias(aliases, "dallas", "America/Chicago");
        alias(aliases, "houston", "America/Chicago");
        alias(aliases, "denver", "America/Denver");
        alias(aliases, "phoenix", "America/Phoenix");
        alias(aliases, "salt_lake_city", "America/Denver");
        alias(aliases, "saltlakecity", "America/Denver");
        alias(aliases, "los_angeles", "America/Los_Angeles");
        alias(aliases, "losangeles", "America/Los_Angeles");
        alias(aliases, "san_francisco", "America/Los_Angeles");
        alias(aliases, "sanfrancisco", "America/Los_Angeles");
        alias(aliases, "seattle", "America/Los_Angeles");
        alias(aliases, "vancouver", "America/Vancouver");
        alias(aliases, "toronto", "America/Toronto");
        alias(aliases, "montreal", "America/Toronto");
        alias(aliases, "winnipeg", "America/Winnipeg");
        alias(aliases, "halifax", "America/Halifax");
        alias(aliases, "anchorage", "America/Anchorage");
        alias(aliases, "honolulu", "Pacific/Honolulu");
        alias(aliases, "mexico_city", "America/Mexico_City");
        alias(aliases, "guatemala", "America/Guatemala");
        alias(aliases, "panama", "America/Panama");
        alias(aliases, "san_jose", "America/Costa_Rica");
        alias(aliases, "caracas", "America/Caracas");
        alias(aliases, "bogota", "America/Bogota");
        alias(aliases, "lima", "America/Lima");
        alias(aliases, "quito", "America/Guayaquil");
        alias(aliases, "santiago", "America/Santiago");
        alias(aliases, "buenos_aires", "America/Argentina/Buenos_Aires");
        alias(aliases, "buenosaires", "America/Argentina/Buenos_Aires");
        alias(aliases, "sao_paulo", "America/Sao_Paulo");
        alias(aliases, "saopaulo", "America/Sao_Paulo");
        alias(aliases, "brasilia", "America/Sao_Paulo");
        alias(aliases, "montevideo", "America/Montevideo");
        alias(aliases, "georgetown", "America/Guyana");
        alias(aliases, "paramaribo", "America/Paramaribo");
        alias(aliases, "cayenne", "America/Cayenne");
        alias(aliases, "suva", "Pacific/Fiji");
        alias(aliases, "apia", "Pacific/Apia");
        alias(aliases, "noumea", "Pacific/Noumea");
        alias(aliases, "port_vila", "Pacific/Efate");
        alias(aliases, "portvila", "Pacific/Efate");
        alias(aliases, "guam", "Pacific/Guam");
        alias(aliases, "sydney", "Australia/Sydney");
        alias(aliases, "melbourne", "Australia/Melbourne");
        alias(aliases, "brisbane", "Australia/Brisbane");
        alias(aliases, "perth", "Australia/Perth");
        alias(aliases, "adelaide", "Australia/Adelaide");
        alias(aliases, "darwin", "Australia/Darwin");
        alias(aliases, "hobart", "Australia/Hobart");
        alias(aliases, "canberra", "Australia/Sydney");
        alias(aliases, "auckland", "Pacific/Auckland");
        alias(aliases, "wellington", "Pacific/Auckland");
        alias(aliases, "new_zealand", "Pacific/Auckland");
        alias(aliases, "christchurch", "Pacific/Auckland");
        alias(aliases, "utc", "UTC");
        alias(aliases, "gmt", "GMT");
        CITY_ALIASES = Collections.unmodifiableMap(aliases);
    }

    private TimezoneIds() {
    }

    private static void alias(Map<String, String> aliases, String name, String zone) {
        if (ZoneId.getAvailableZoneIds().contains(zone) || "UTC".equals(zone) || "GMT".equals(zone)) {
            aliases.put(name, zone);
        }
    }

    public static String findCanonical(String value) {
        if (value == null) {
            return null;
        }
        return CANONICAL_BY_LOWER.get(value.toLowerCase(Locale.ROOT));
    }

    public static List<String> search(String prefix, int limit) {
        if (limit <= 0) {
            return Collections.emptyList();
        }

        String normalized = prefix == null ? "" : prefix.toLowerCase(Locale.ROOT);
        List<String> result = new ArrayList<String>();
        for (String id : SORTED_IDS) {
            if (normalized.isEmpty() || id.toLowerCase(Locale.ROOT).startsWith(normalized)) {
                result.add(id);
                if (result.size() == limit) {
                    break;
                }
            }
        }
        return result;
    }

    public static List<String> aliasSuggestions(String input) {
        String normalized = input == null ? "" : input.toLowerCase(Locale.ROOT);
        List<String> result = new ArrayList<String>();
        for (String alias : CITY_ALIASES.keySet()) {
            if (alias.startsWith(normalized)) {
                result.add(alias);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static String alias(String input) {
        if (input == null) {
            return null;
        }
        return CITY_ALIASES.get(input.toLowerCase(Locale.ROOT));
    }

    public static List<String> common() {
        String[] values = {
                "UTC", "Asia/Kolkata", "Asia/Dhaka", "Asia/Singapore", "Asia/Tokyo",
                "Asia/Shanghai", "Asia/Dubai", "Europe/London", "Europe/Paris", "Europe/Berlin",
                "Europe/Moscow", "America/New_York", "America/Chicago", "America/Los_Angeles",
                "America/Toronto", "Australia/Sydney", "Pacific/Auckland"
        };

        List<String> result = new ArrayList<String>();
        for (String value : values) {
            String canonical = findCanonical(value);
            if (canonical != null) {
                result.add(canonical);
            }
        }
        return result;
    }
}
