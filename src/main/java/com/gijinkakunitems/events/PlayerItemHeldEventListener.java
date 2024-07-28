package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class PlayerItemHeldEventListener implements Listener {
    private final GijinkakunItems plugin;

    public PlayerItemHeldEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {

    }
}
