package io.gitlab.user254.parkourplugin.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 등 긁어주는 간단한 유틸리티.
 * 
 * @author user254
 *
 */
public class Util {

    // private construct
    private Util() {}

    private static class InnerInstanceClazz {
        private static final Util instance = new Util();
    }

    public static Util getInstance() {
        return InnerInstanceClazz.instance;
    }

    /**
     * 플레이어에 아이템 추가하기
     * 
     * @param player   아이템이 추가될 플레이어
     * @param material 추가될 아이템. {@code org.bukkit.Material}에서 가져온다.
     * @param count    추가될 아이템의 개수
     */
    @Nullable
    public Player addItem(Player player, Material material, int count) {
        try {
            player.getInventory().addItem(new ItemStack(material, count));
            return player;
        } catch (NullPointerException e) {
            return null;
        }
    }
}