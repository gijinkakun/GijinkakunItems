package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import net.md_5.bungee.api.ChatColor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShroomBladeAbility {

    public static void apply(EntityDamageByEntityEvent event, GijinkakunItems plugin) {
        if (event.getEntity() instanceof Player || event.getEntity() instanceof LivingEntity) {
            if (event.getDamager() instanceof Player) {
                Player attacker = (Player) event.getDamager();
                ItemStack weapon = attacker.getInventory().getItemInMainHand();
                if (weapon.getType() == Material.SHEARS && isSpecialItem(weapon, "shroomblade", plugin)) {
                    Player victim = (Player) event.getEntity();
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "last_attacker"), PersistentDataType.STRING, attacker.getName());
                }
            }
        }
    }

    public static void dropShroomSacrifice(PlayerDeathEvent event, GijinkakunItems plugin) {
        Player player = event.getEntity();
        String attackerName = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "last_attacker"), PersistentDataType.STRING);

        if (attackerName != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());

            ItemStack leather = new ItemStack(Material.LEATHER);
            ItemMeta meta = leather.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.RED + "Shroom Sacrifice");
                meta.setLore(Arrays.asList(ChatColor.DARK_PURPLE + player.getName(), ChatColor.DARK_PURPLE + date));
                leather.setItemMeta(meta);
            }
            player.getWorld().dropItemNaturally(player.getLocation(), leather);
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, "shroomblade", plugin) || isSpecialItem(cursorItem, "shroomblade", plugin)) {
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
