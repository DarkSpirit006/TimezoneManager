package com.darkspirit.timezonemanager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class TimezoneCommand implements TabExecutor {
    private static final String PREFIX = ChatColor.DARK_AQUA + "[Timezone] " + ChatColor.RESET;
    private static final String PERMISSION = "timezone.admin";
    private static final String[] SUBCOMMANDS = { "info", "reload", "reset", "system" };

    private final TimezoneService service;
    private final TimezoneManagerPlugin plugin;

    public TimezoneCommand(TimezoneManagerPlugin plugin, TimezoneService service) {
        this.plugin = plugin;
        this.service = service;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(PERMISSION)) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to manage the server timezone.");
            return true;
        }

        if (args.length == 0 || "info".equalsIgnoreCase(args[0])) {
            sendStatus(sender);
            return true;
        }

        if (args.length != 1) {
            sendUsage(sender);
            return true;
        }

        String argument = args[0];
        if ("reload".equalsIgnoreCase(argument)) {
            reload(sender);
            return true;
        }

        if ("reset".equalsIgnoreCase(argument) || "system".equalsIgnoreCase(argument)) {
            service.resetToSystem();
            sender.sendMessage(PREFIX + ChatColor.GREEN + "Server timezone reset to the original JVM/host default: "
                    + ChatColor.WHITE + service.getZoneId().getId());
            return true;
        }

        try {
            ZoneId zone = service.setConfiguredTimezone(argument);
            sender.sendMessage(PREFIX + ChatColor.GREEN + "Server timezone changed to "
                    + ChatColor.WHITE + zone.getId() + ChatColor.GREEN + " (" + service.getOffsetText() + ").");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            sender.sendMessage(PREFIX + ChatColor.RED + ex.getMessage());
        }
        return true;
    }

    private void reload(CommandSender sender) {
        try {
            plugin.reloadConfig();
            service.loadAndApplyConfiguredTimezone();
            sender.sendMessage(PREFIX + ChatColor.GREEN + "Configuration reloaded. Current timezone: "
                    + ChatColor.WHITE + service.getZoneId().getId());
        } catch (IllegalArgumentException | IllegalStateException ex) {
            sender.sendMessage(PREFIX + ChatColor.RED + "Reload failed: " + ex.getMessage());
        }
    }

    private void sendStatus(CommandSender sender) {
        sender.sendMessage(PREFIX + ChatColor.GRAY + "Timezone: " + ChatColor.WHITE + service.getZoneId().getId());
        sender.sendMessage(PREFIX + ChatColor.GRAY + "Offset: " + ChatColor.WHITE + service.getOffsetText());
        sender.sendMessage(PREFIX + ChatColor.GRAY + "Server time: " + ChatColor.WHITE + service.getFormattedNow());
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(PREFIX + ChatColor.YELLOW + "Usage: /timezone [<timezone>|info|reload|reset|system]");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!sender.hasPermission(PERMISSION) || args.length != 1) {
            return new ArrayList<String>();
        }

        String input = args[0].toLowerCase(Locale.ROOT);
        Set<String> suggestions = new LinkedHashSet<String>();

        if (input.isEmpty()) {
            Collections.addAll(suggestions, SUBCOMMANDS);
            return new ArrayList<String>(suggestions);
        }

        for (String subcommand : SUBCOMMANDS) {
            if (subcommand.startsWith(input)) {
                suggestions.add(subcommand);
            }
        }

        suggestions.addAll(TimezoneIds.search(input, 80));
        suggestions.addAll(TimezoneIds.aliasSuggestions(input));
        return new ArrayList<String>(suggestions);
    }
}
