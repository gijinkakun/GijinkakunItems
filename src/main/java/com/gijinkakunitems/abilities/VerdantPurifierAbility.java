package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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

public class VerdantPurifierAbility {

    public static void apply(PlayerInteractEvent event, GijinkakunItems plugin) {
        Block block = event.getClickedBlock();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Player player = event.getPlayer();

        if (block != null && item != null && isSpecialItem(item, "verdantpurifier", plugin)) {
            int playerLevel = player.getLevel();
            if (playerLevel >= 100) {
                player.setLevel(playerLevel - 100);

                if (block.getType() == Material.NETHERRACK) {
                    block.setType(Material.GRASS_BLOCK);
                    player.sendMessage(ChatColor.GREEN + "The Verdant Purifier has transformed Netherrack into Grass Block!");
                } else if (block.getType() == Material.GRASS_BLOCK || block.getType() == Material.SAND) {
                    applyBonemealEffect(block, player);
                }
            } else {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                    new ComponentBuilder(ChatColor.RED + "Not enough levels").create());
            }
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, "verdantpurifier", plugin) || isSpecialItem(cursorItem, "verdantpurifier", plugin)) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player) {
                ((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You cannot modify the special items!");
            }
        }
    }

    private static void applyBonemealEffect(Block block, Player player) {
        if (block.getType() == Material.GRASS_BLOCK) {
            block.applyBoneMeal(BlockFace.UP);
            player.sendMessage(ChatColor.GREEN + "The Verdant Purifier has applied a bonemeal effect!");
        } else if (block.getType() == Material.SAND) {
            Block above = block.getRelative(BlockFace.UP);
            if (above.getType() == Material.AIR) {
                above.setType(Material.GRASS_BLOCK);
                player.sendMessage(ChatColor.GREEN + "The Verdant Purifier has turned sand into grass!");
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
