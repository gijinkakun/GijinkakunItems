package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.ChatMessageType;

public class StormstrikerAbility {

    public static void apply(EntityDamageByEntityEvent event, GijinkakunItems plugin) {
        if (event.getEntity() instanceof Player || event.getEntity() instanceof LivingEntity) {
            if (event.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) event.getDamager();
                if (arrow.getShooter() instanceof Player) {
                    Player shooter = (Player) arrow.getShooter();
                    ItemStack bow = shooter.getInventory().getItemInMainHand();
                    if (bow.getType() == Material.BOW && isSpecialItem(bow, "stormstriker", plugin) && shooter.getWorld().hasStorm()) {
                        event.setDamage(event.getDamage() + 16);
                    }
                }
            }
        }
    }

    public static void apply(ProjectileHitEvent event, GijinkakunItems plugin) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                Player player = (Player) arrow.getShooter();
                ItemStack bow = player.getInventory().getItemInMainHand();
                if (bow.getType() == Material.BOW && isSpecialItem(bow, "stormstriker", plugin)) {
                    if (arrow.getWorld().hasStorm()) {
                        arrow.getWorld().strikeLightning(arrow.getLocation());
                    } else {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(ChatColor.RED + "Stormstriker only works in the rain!").create());
                    }
                }
            }
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, "stormstriker", plugin) || isSpecialItem(cursorItem, "stormstriker", plugin)) {
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
