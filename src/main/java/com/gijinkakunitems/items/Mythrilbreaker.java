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

public class Mythrilbreaker {
    public static ItemStack create(GijinkakunItems plugin) {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Mythrilbreaker");
            meta.setLore(Arrays.asList(
                    ChatColor.DARK_PURPLE + "",
                    ChatColor.DARK_PURPLE + "Forged in the heart of",
                    ChatColor.DARK_PURPLE + "a dying star, Mythrilbreaker",
                    ChatColor.DARK_PURPLE + "shatters the toughest of ores",
                    ChatColor.DARK_PURPLE + "with ease."));
            meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING, "mythrilbreaker");
            item.setItemMeta(meta);
        }

        return item;
    }

    public static boolean isSpecialItem(ItemStack item, GijinkakunItems plugin) {
        return PluginUtils.isSpecialItem(item, "mythrilbreaker", plugin);
    }
}
