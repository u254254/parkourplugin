package io.gitlab.user254.parkourplugin.util

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

/**
 * Creates a Parkour Timer
 * @param plugin Your plugin main class
 * @param player Who started the timer
 */
class ParkourTimer(private val plugin: JavaPlugin, private val player: Player) {
    var ticks: Int = 0
    var sec: Int = 0
    var attempts: Int = 0

    private fun doTaskTick(player: Player, ticks: Int, sec: Int) {
        player.sendActionBar(Component.text("<Elapsed Time: $sec.${ticks * 0.05}, Attempts: $attempts>"))
    }
    private val taskTick = object: BukkitRunnable() {
        override fun run() {
            ticks++
            if (ticks >= 20) {
                ticks = 0
                sec++
            }
            doTaskTick(player, ticks, sec)
        }
    }.runTaskTimer(plugin, 0L, 1L)

    /**
     * Cancels the timer
     */
    fun cancelTimer() {
        taskTick.cancel()
    }
}