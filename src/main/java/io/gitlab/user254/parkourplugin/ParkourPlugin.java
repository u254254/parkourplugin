package io.gitlab.user254.parkourplugin;

import io.gitlab.user254.parkourplugin.util.ParkourTimer;
import io.gitlab.user254.parkourplugin.util.Util;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public final class ParkourPlugin extends JavaPlugin {
    private final HashMap<Player, ParkourTimer> timers = new HashMap<Player, ParkourTimer>();

    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("parkour")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            } else {
                var player = (Player) sender;
                var util = Util.getInstance();

                if (args.length > 1) {
                    sender.sendMessage("Too many arguments!");
                    return false;
                }
                if (args.length < 1) {
                    sender.sendMessage("Not enough arguments!");
                    return false;
                }

                String command = args[0];

                switch (command) {
                    case "help":
                        player.sendMessage(
                                "ParkourPlugin Help:",
                                "/parkour help: Display this help message",
                                "/parkour setstart: Set current position as start position",
                                "/parkour tpstart: Teleport to start position"
                        );
                        break;
                    case "setstart":
                        // TODO
                        break;
                    case "tpstart":
                        var loc = new Location(player.getWorld(), 0, 89, 0, 0, 0);
                        player.teleport(loc);
                        player.sendMessage("Teleported to start");
                        break;
                    case "timerstart":
                        // todo
                        if (player != null) {
                            timers.put(player, new ParkourTimer(this, player));
                        } else {
                            sender.sendMessage("Invalid player!");
                        }
                        break;
                    case "timerstop":
                        // todo
                        if (timers.get(player) != null) {
                            timers.get(player).cancelTimer();
                        } else {
                            sender.sendMessage("Invalid player!");
                        }
                        break;
                    default:
                        sender.sendMessage("Invalid command!");
                        return false;
                }
            }

            return true;
        } // If this has happened the function will return true.
          // If this hasn't happened the value of false will be returned.
        return false;
    }
}
