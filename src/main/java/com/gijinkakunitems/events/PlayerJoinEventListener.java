package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.items.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinEventListener implements Listener {

    private final GijinkakunItems plugin;

    public PlayerJoinEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        updateSpecialItems(event);
    }

    private void updateSpecialItems(PlayerJoinEvent event) {
        Inventory inventory = event.getPlayer().getInventory();
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = inventory.getItem(i);
            if (item != null) {
                if (Mythrilbreaker.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, Mythrilbreaker.create(plugin));
                } else if (Earthshaper.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, Earthshaper.create(plugin));
                } else if (Timbercleaver.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, Timbercleaver.create(plugin));
                } else if (ShroomBlade.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, ShroomBlade.create(plugin));
                } else if (ChickenShooter.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, ChickenShooter.create(plugin));
                } else if (InfernoBow.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, InfernoBow.create(plugin));
                } else if (TidecallerBow.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, TidecallerBow.create(plugin));
                } else if (ArcaneDetonator.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, ArcaneDetonator.create(plugin));
                } else if (Stormstriker.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, Stormstriker.create(plugin));
                } else if (StringOfSacrifice.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, StringOfSacrifice.create(plugin));
                } else if (TempestScythe.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, TempestScythe.create(plugin));
                } else if (VerdantPurifier.isSpecialItem(item, plugin)) {
                    inventory.setItem(i, VerdantPurifier.create(plugin));
                }
            }
        }
    }
}
