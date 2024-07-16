package com.gijinkakunitems.events;

import com.gijinkakunitems.abilities.*;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventListener implements Listener {

    private final GijinkakunItems plugin;

    public PlayerInteractEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        VerdantPurifierAbility.apply(event, plugin);
        MythrilbreakerAbility.apply(event, plugin);
        EarthshaperAbility.apply(event, plugin);
        TimbercleaverAbility.apply(event, plugin);
    }
}
