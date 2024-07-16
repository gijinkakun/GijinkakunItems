package com.gijinkakunitems.items;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.util.Arrays;

public class TidecallerBow {
    public static ItemStack create(GijinkakunItems plugin) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Tidecaller Bow");
            meta.setLore(Arrays.asList(
                    ChatColor.DARK_PURPLE + "",
                    ChatColor.DARK_PURPLE + "Crafted by ancient water",
                    ChatColor.DARK_PURPLE + "mages, this bow channels",
                    ChatColor.DARK_PURPLE + "the essence of the ocean."));
            meta.addEnchant(Enchantment.POWER, 10, true);
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING, "tidecallerbow");
            item.setItemMeta(meta);
        }

        return item;
    }

    public static boolean isSpecialItem(ItemStack item, GijinkakunItems plugin) {
        if (item == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return false;
        }
        return meta.getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING) &&
               "tidecallerbow".equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
