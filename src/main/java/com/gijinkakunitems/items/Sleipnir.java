package com.gijinkakunitems.items;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class Sleipnir {
    public static ItemStack create(GijinkakunItems plugin) {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Sleipnir");
            meta.setLore(Arrays.asList(
                    ChatColor.DARK_PURPLE + "",
                    ChatColor.DARK_PURPLE + "Named after Odin's trusty steed.",
                    ChatColor.GREEN + "- Increases Movement Speed by 40%"));
            meta.addEnchant(Enchantment.UNBREAKING, 9, true);
            meta.addEnchant(Enchantment.PROTECTION, 10, true);
            meta.addEnchant(Enchantment.FEATHER_FALLING, 8, true);
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING, "sleipnir");
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
                "sleipnir".equals(meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }
}
