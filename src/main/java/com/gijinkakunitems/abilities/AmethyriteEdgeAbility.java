package com.gijinkakunitems.abilities;

import com.gijinkakunitems.CustomDeathMessageHandler;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import net.md_5.bungee.api.ChatColor;

public class AmethyriteEdgeAbility {

    public static void apply(BlockBreakEvent event, GijinkakunItems plugin) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (isSpecialItem(item, "amethyriteedge", plugin)) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "The Amethyrite Edge can only mine amethyst buds.");
        }
    }

    public static void apply(PlayerDeathEvent event, GijinkakunItems plugin) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        if (killer != null && isSpecialItem(killer.getInventory().getItemInMainHand(), "amethyriteedge", plugin)) {
            CustomDeathMessageHandler.handleDeathMessage(event, "amethyriteedge", killer);
        }
    }

    private static boolean isSpecialItem(ItemStack item, String key, GijinkakunItems plugin) {
        if (item == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta != null && meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING) &&
               key.equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
