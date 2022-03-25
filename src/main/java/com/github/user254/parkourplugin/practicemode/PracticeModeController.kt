package com.github.user254.parkourplugin.practicemode

import org.bukkit.entity.Player

object PracticeModeController {
    private val prac = hashMapOf<Player, PracticeMode>()

    fun startPractice(player: Player) {
        prac[player] = PracticeMode(player)
        player.sendMessage("Practice started.")
    }
    fun returnToOldLocation(player: Player) {
        prac[player]?.returnToOldLoc()
        player.sendMessage("Returned to old location.")
    }
    fun stopPractice(player: Player) {
        prac[player]?.returnToOldLoc()
        prac.remove(player)
        player.sendMessage("Practice stopped.")
    }
}