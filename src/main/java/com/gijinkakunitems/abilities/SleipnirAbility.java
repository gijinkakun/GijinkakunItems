package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SleipnirAbility {
    private static final String SLEIPNIR_KEY = "sleipnir";
    private static final String HAS_SLEIPNIR_EFFECT_KEY = "HAS_SLEIPNIR_EFFECT";

    public static void apply(final Player player, final GijinkakunItems plugin) {
        ItemStack boots = player.getInventory().getBoots();

        if (isSpecialItem(boots, SLEIPNIR_KEY, plugin)) {
            player.setMetadata(HAS_SLEIPNIR_EFFECT_KEY, new FixedMetadataValue(plugin, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        } else {
            SleipnirAbility.remove(player, plugin);
        }
    }

    public static void remove(final Player player, final GijinkakunItems plugin) {
        if (player.hasMetadata(HAS_SLEIPNIR_EFFECT_KEY)) {
            player.removeMetadata(HAS_SLEIPNIR_EFFECT_KEY, plugin);
            player.removePotionEffect(PotionEffectType.SPEED);
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, SLEIPNIR_KEY, plugin) || isSpecialItem(cursorItem, SLEIPNIR_KEY, plugin)) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player) {
                event.getWhoClicked().sendMessage(ChatColor.RED + "You cannot modify the special items!");
            }
        }
    }

    private static boolean isSpecialItem(ItemStack item, String key, GijinkakunItems plugin) {
        if (item == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();

        return meta != null && meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"),
                PersistentDataType.STRING) && key.equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"),
                PersistentDataType.STRING));
    }
}
