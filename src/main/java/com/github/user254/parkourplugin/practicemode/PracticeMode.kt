package com.github.user254.parkourplugin.practicemode

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class PracticeMode(private val plugin: JavaPlugin, private val player: Player) {
    private val loc = player.location
    fun returnToOldLoc() {
        player.teleport(loc)
    }
}