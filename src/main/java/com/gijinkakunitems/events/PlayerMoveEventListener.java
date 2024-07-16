package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.abilities.StringOfSacrificeAbility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveEventListener implements Listener {

    private final GijinkakunItems plugin;

    public PlayerMoveEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        StringOfSacrificeAbility.saveFromVoid(event, plugin);
    }
}
