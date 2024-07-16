package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public class StringOfSacrificeAbility {

    public static void saveFromVoid(PlayerMoveEvent event, GijinkakunItems plugin) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if (location.getY() < -64) {
            Inventory inventory = player.getInventory();
            for (ItemStack item : inventory.getContents()) {
                if (isSpecialItem(item, "stringofsacrifice", plugin)) {
                    World overworld = Bukkit.getWorlds().get(0);
                    Location spawnLocation = overworld.getSpawnLocation();
                    player.teleport(spawnLocation);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 100, 5, false, false, true));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1, false, false, true));
                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                    } else {
                        inventory.remove(item);
                    }
                    player.sendMessage(ChatColor.GREEN + "The String of Sacrifice saved you from the void!");
                    break;
                }
            }
        }
    }

    public static void apply(EntityDamageEvent event, GijinkakunItems plugin) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                Inventory inventory = player.getInventory();
                for (ItemStack item : inventory.getContents()) {
                    if (isSpecialItem(item, "stringofsacrifice", plugin)) {
                        event.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, "stringofsacrifice", plugin) || isSpecialItem(cursorItem, "stringofsacrifice", plugin)) {
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
        return meta != null && meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING) && key.equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
