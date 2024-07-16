package com.gijinkakunitems.items;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class AmethyriteEdge {
    public static ItemStack create(GijinkakunItems plugin) {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Amethyrite Edge");
            meta.setLore(Arrays.asList(
                    ChatColor.DARK_PURPLE + "Forged by master blacksmiths,",
                    ChatColor.DARK_PURPLE + "this enchanted tool was imbued",
                    ChatColor.DARK_PURPLE + "with the essence of the crystals it seeks."));
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
            meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING, "amethyriteedge");
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
               "amethyriteedge".equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
