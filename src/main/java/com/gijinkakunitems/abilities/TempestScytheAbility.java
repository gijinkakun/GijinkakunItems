package com.gijinkakunitems.abilities;

import com.gijinkakunitems.CustomDeathMessageHandler;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public class TempestScytheAbility {

    public static void apply(EntityDamageByEntityEvent event, GijinkakunItems plugin) {
        if (event.getEntity() instanceof LivingEntity) {
            if (event.getDamager() instanceof Player) {
                Player attacker = (Player) event.getDamager();
                ItemStack weapon = attacker.getInventory().getItemInMainHand();
                if (weapon.getType() == Material.DIAMOND_HOE && isSpecialItem(weapon, "tempestscythe", plugin)) {
                    Location location = event.getEntity().getLocation();
                    Collection<Entity> entities = location.getWorld().getNearbyEntities(location, 4, 4, 4);
                    for (Entity entity : entities) {
                        if (entity instanceof LivingEntity && !entity.equals(event.getEntity()) && !entity.equals(attacker)) {
                            ((LivingEntity) entity).damage(10);
                        }
                    }
                }
            }
        }
    }

    public static void apply(PlayerDeathEvent event, GijinkakunItems plugin) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        if (killer != null && isSpecialItem(killer.getInventory().getItemInMainHand(), "tempestscythe", plugin)) {
            CustomDeathMessageHandler.handleDeathMessage(event, "tempestscythe", killer);
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
