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

public class TempestScythe {
    public static ItemStack create(GijinkakunItems plugin) {
        ItemStack item = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Tempest Scythe");
            meta.setLore(Arrays.asList(
                    ChatColor.DARK_PURPLE + "",
                    ChatColor.DARK_PURPLE + "Forged in an eternal storm,",
                    ChatColor.DARK_PURPLE + "the Tempest Scythe unleashes",
                    ChatColor.DARK_PURPLE + "whirlwinds with each swing,",
                    ChatColor.DARK_PURPLE + "striking down all within its reach."));
            meta.addEnchant(Enchantment.SHARPNESS, 15, true);
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING, "tempestscythe");
            item.setItemMeta(meta);
        }

        return item;
    }

    public static boolean isSpecialItem(ItemStack item, GijinkakunItems plugin) {
        return PluginUtils.isSpecialItem(item, "tempestscythe", plugin);
    }
}
