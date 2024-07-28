package com.gijinkakunitems.items;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class Bloodrender {
    public static ItemStack create(GijinkakunItems plugin) {
        ItemStack item = new ItemStack(Material.GOLDEN_AXE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Bloodrender");
            meta.setLore(Arrays.asList(
                ChatColor.DARK_PURPLE + "",
                ChatColor.DARK_PURPLE + "Bloodrender is a golden axe",
                ChatColor.DARK_PURPLE + "that severs heads with a",
                ChatColor.DARK_PURPLE + "single swing."));
            meta.addEnchant(Enchantment.SHARPNESS, 31, true);
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING, "bloodrender");
            item.setItemMeta(meta);
        }
        return item;
    }

    public static boolean isSpecialItem(ItemStack item, GijinkakunItems plugin) {
        return PluginUtils.isSpecialItem(item, "bloodrender", plugin);
    }
}
