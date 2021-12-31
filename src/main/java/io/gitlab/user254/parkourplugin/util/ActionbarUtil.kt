package io.gitlab.user254.parkourplugin.util

import org.bukkit.Server

object ActionbarUtil {
    val actionbars = mutableMapOf("Test" to "asdfuu")
    fun render(server: Server) {
        actionbars.forEach { playerName, value ->
            server.getPlayer(playerName)
        }
    }
}