package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Bukkit;

public class StringOfSacrificeAbility {

    public static void saveFromVoid(PlayerMoveEvent event, GijinkakunItems plugin) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if (location.getY() < -64) {
            Inventory inventory = player.getInventory();
            for (ItemStack item : inventory.getContents()) {
                if (PluginUtils.isSpecialItem(item, "stringofsacrifice", plugin)) {
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
                    if (PluginUtils.isSpecialItem(item, "stringofsacrifice", plugin)) {
                        event.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        PluginUtils.preventModification(event, "stringofsacrifice", plugin);
    }
}
