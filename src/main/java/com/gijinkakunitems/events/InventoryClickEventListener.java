package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.abilities.*;
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
            type == InventoryType.STONECUTTER ||
            type == InventoryType.WORKBENCH) {

            MythrilbreakerAbility.preventModification(event, plugin);
            EarthshaperAbility.preventModification(event, plugin);
            TimbercleaverAbility.preventModification(event, plugin);
            ShroomBladeAbility.preventModification(event, plugin);
            ChickenShooterAbility.preventModification(event, plugin);
            InfernoBowAbility.preventModification(event, plugin);
            TidecallerBowAbility.preventModification(event, plugin);
            ArcaneDetonatorAbility.preventModification(event, plugin);
            StormstrikerAbility.preventModification(event, plugin);
            StringOfSacrificeAbility.preventModification(event, plugin);
            TempestScytheAbility.preventModification(event, plugin);
            VerdantPurifierAbility.preventModification(event, plugin);
            BloodrenderAbility.preventModification(event, plugin);
            AmethyriteEdgeAbility.preventModification(event, plugin);
        }
    }
}
