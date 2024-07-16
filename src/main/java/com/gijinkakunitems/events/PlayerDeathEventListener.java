package com.gijinkakunitems.events;

import com.gijinkakunitems.abilities.ShroomBladeAbility;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathEventListener implements Listener {

    private final GijinkakunItems plugin;

    public PlayerDeathEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        ShroomBladeAbility.dropShroomSacrifice(event, plugin);
    }
}
