package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.items.AmethyriteEdge;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import net.md_5.bungee.api.ChatColor;

public class AmethyriteEdgeAbility {

    public static void apply(BlockBreakEvent event, GijinkakunItems plugin) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (AmethyriteEdge.isSpecialItem(item, plugin)) {
            if (block.getType() == Material.AMETHYST_CLUSTER || block.getType() == Material.LARGE_AMETHYST_BUD || block.getType() == Material.MEDIUM_AMETHYST_BUD || block.getType() == Material.SMALL_AMETHYST_BUD) {
                event.setDropItems(false);
                ItemStack drop = new ItemStack(block.getType(), 1);
                block.getWorld().dropItemNaturally(block.getLocation(), drop);
                player.getInventory().addItem(drop);
                player.sendMessage(ChatColor.LIGHT_PURPLE + "You have mined an amethyst bud with the Amethyrite Edge!");
            } else {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "The Amethyrite Edge can only mine amethyst buds.");
            }
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, "amethyriteedge", plugin) || isSpecialItem(cursorItem, "amethyriteedge", plugin)) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player) {
                ((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You cannot modify the special items!");
            }
        }
    }

    private static boolean isSpecialItem(ItemStack item, String key, GijinkakunItems plugin) {
        if (item == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return false;
        }
        return meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING) &&
               key.equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
