package com.github.user254.parkourplugin.util

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * Utility functions for player tasks.
 */
object PlayerUtil {

    fun addItem(player: Player, material: Material, count: Int): Player? {
        try {
            player.inventory.addItem(ItemStack(material, count))
            return player
        } catch (e: NullPointerException) {
            return null
        }
    }
}