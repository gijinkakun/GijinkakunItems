package com.gijinkakunitems.abilities;

import com.gijinkakunitems.GijinkakunItems;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import net.md_5.bungee.api.ChatColor;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.lang.reflect.Field;
import java.util.UUID;

public class BloodrenderAbility {

    public static void apply(PlayerDeathEvent event, GijinkakunItems plugin) {
        Player player = event.getEntity();
        if (player.getKiller() != null) {
            Player killer = player.getKiller();
            ItemStack itemStack = killer.getInventory().getItemInMainHand();
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                if (isSpecialItem(itemStack, plugin)) {
                    ItemStack playerHead = createPlayerHead(player.getName(), player.getUniqueId());
                    player.getLocation().getWorld().dropItemNaturally(player.getLocation(), playerHead);
                }
            }
        }
    }

    public static void preventModification(InventoryClickEvent event, GijinkakunItems plugin) {
        ItemStack currentItem = event.getCurrentItem();
        ItemStack cursorItem = event.getCursor();
        if (isSpecialItem(currentItem, plugin) || isSpecialItem(cursorItem, plugin)) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player) {
                ((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You cannot modify the special items!");
            }
        }
    }

    private static boolean isSpecialItem(ItemStack item, GijinkakunItems plugin) {
        if (item == null) {
            return false;
        }
        if (!item.hasItemMeta()) {
            return false;
        }
        return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING) &&
               "bloodrender".equals(item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "special_item"), PersistentDataType.STRING));
    }

    private static ItemStack createPlayerHead(String playerName, UUID playerUUID) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        if (headMeta != null) {
            GameProfile profile = new GameProfile(playerUUID, playerName);
            String texture = getTextureFromUUID(playerUUID);
            if (texture != null) {
                profile.getProperties().put("textures", new Property("textures", texture));
            }
            try {
                Field profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            headMeta.setDisplayName(ChatColor.YELLOW + playerName + "'s Head");
            head.setItemMeta(headMeta);
        }
        return head;
    }

    private static String getTextureFromUUID(UUID playerUUID) {
        try {
            URI uri = new URI("https://sessionserver.mojang.com/session/minecraft/profile/" + playerUUID.toString().replace("-", ""));
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject response = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject properties = response.getAsJsonArray("properties").get(0).getAsJsonObject();
            return properties.get("value").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
