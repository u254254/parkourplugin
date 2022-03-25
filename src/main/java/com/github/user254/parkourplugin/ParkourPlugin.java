package com.github.user254.parkourplugin;

import com.github.user254.parkourplugin.practicemode.PracticeModeController;
import com.github.user254.parkourplugin.util.ParkourTimer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public final class ParkourPlugin extends JavaPlugin {
    private final HashMap<Player, ParkourTimer> timers = new HashMap<>();
    private final HashMap<Player, Integer> attempts = new HashMap<>();

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

            if (!(sender instanceof Player player)) {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            } else {

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
                        var loc = new Location(player.getWorld(), 0.5, 89, 0.5, 0, 0);
                        player.teleport(loc);
                        player.sendMessage("Teleported to start");
                        break;
                    case "timerstart":
                        // todo
                        timers.put(player, new ParkourTimer(this, player));
                        break;
                    case "timerstop":
                        // todo
                        if (timers.get(player) != null) {
                            timers.get(player).cancelTimer();
                            timers.remove(player);
                        } else {
                            sender.sendMessage("Invalid player!");
                        }
                        break;
                    case "prac":
                        PracticeModeController.INSTANCE.startPractice(player);
                        break;
                    case "return":
                        PracticeModeController.INSTANCE.returnToOldLocation(player);
                        break;
                    case "unprac":
                        PracticeModeController.INSTANCE.stopPractice(player);
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
