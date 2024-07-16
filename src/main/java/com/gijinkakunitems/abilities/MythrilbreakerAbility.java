package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.Utils;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.ChatMessageType;

public class MythrilbreakerAbility {

    public static void apply(PlayerInteractEvent event, GijinkakunItems plugin) {
        Block block = event.getClickedBlock();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (block != null && item != null && isSpecialItem(item, "mythrilbreaker", plugin)) {
            superMine(event, plugin);
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, "mythrilbreaker", plugin) || isSpecialItem(cursorItem, "mythrilbreaker", plugin)) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player) {
                ((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You cannot modify the special items!");
            }
        }
    }

    private static void superMine(PlayerInteractEvent event, GijinkakunItems plugin) {
        Block block = event.getClickedBlock();
        if (block != null && Utils.allowedBlocks.contains(block.getType())) {
            int playerLevel = event.getPlayer().getLevel();
            if (playerLevel >= 100) {
                event.getPlayer().setLevel(playerLevel - 100);
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            Block targetBlock = block.getRelative(x, y, z);
                            if (Utils.allowedBlocks.contains(targetBlock.getType())) {
                                targetBlock.breakNaturally();
                            }
                        }
                    }
                }
            } else {
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new ComponentBuilder(ChatColor.RED + "Not enough levels").create());
            }
        }
    }

    private static boolean isSpecialItem(ItemStack item, String key, GijinkakunItems plugin) {
        if (item == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta != null && meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING) && key.equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
