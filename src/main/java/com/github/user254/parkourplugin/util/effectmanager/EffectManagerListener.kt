package com.github.user254.parkourplugin.util.effectmanager

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class EffectManagerListener : Listener {
    @EventHandler
    fun onSpawn(event: PlayerRespawnEvent) {
        val player = event.player
        player.addPotionEffect(PotionEffect(
            PotionEffectType.DAMAGE_RESISTANCE,
            Int.MAX_VALUE,
            4,
            true,
            false,
            false
        ))
    }
}