package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener {
    private final GijinkakunItems plugin;

    public PlayerQuitEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

    }
}
