package com.gijinkakunitems.abilities;

import com.gijinkakunitems.CustomDeathMessageHandler;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;

public class ChickenShooterAbility {

    public static void apply(ProjectileHitEvent event, GijinkakunItems plugin) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                Player player = (Player) arrow.getShooter();
                ItemStack bow = player.getInventory().getItemInMainHand();
                if (bow.getType() == Material.BOW && isSpecialItem(bow, "chickenshooter", plugin)) {
                    arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.CHICKEN);
                }
            }
        }
    }

    public static void apply(PlayerDeathEvent event, GijinkakunItems plugin) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        if (killer != null && isSpecialItem(killer.getInventory().getItemInMainHand(), "chickenshooter", plugin)) {
            CustomDeathMessageHandler.handleDeathMessage(event, "chickenshooter", killer);
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
