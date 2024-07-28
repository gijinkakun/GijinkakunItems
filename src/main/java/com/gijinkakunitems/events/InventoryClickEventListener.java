package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.PluginUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryClickEventListener implements Listener {

    private final GijinkakunItems plugin;

    public InventoryClickEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        InventoryType type = inventory.getType();

        if (type == InventoryType.ANVIL ||
            type == InventoryType.ENCHANTING ||
            type == InventoryType.GRINDSTONE ||
            type == InventoryType.SMITHING ||
            type == InventoryType.STONECUTTER ) {

            PluginUtils.preventModification(event, "mythrilbreaker", plugin);
            PluginUtils.preventModification(event, "earthshaper", plugin);
            PluginUtils.preventModification(event, "timbercleaver", plugin);
            PluginUtils.preventModification(event, "shroomblade", plugin);
            PluginUtils.preventModification(event, "chickenshooter", plugin);
            PluginUtils.preventModification(event, "infernobow", plugin);
            PluginUtils.preventModification(event, "tidecallerbow", plugin);
            PluginUtils.preventModification(event, "arcanedetonator", plugin);
            PluginUtils.preventModification(event, "stormstriker", plugin);
            PluginUtils.preventModification(event, "stringofsacrifice", plugin);
            PluginUtils.preventModification(event, "tempestscythe", plugin);
            PluginUtils.preventModification(event, "verdantpurifier", plugin);
            PluginUtils.preventModification(event, "bloodrender", plugin);
            PluginUtils.preventModification(event, "amethyriteedge", plugin);
            PluginUtils.preventModification(event, "luminadust", plugin);
        }
    }
}
