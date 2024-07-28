package com.gijinkakunitems.events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.abilities.SleipnirAbility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class PlayerArmorChangeEventListener implements Listener  {

    private final GijinkakunItems plugin;

    public PlayerArmorChangeEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerArmorChangeEvent(PlayerArmorChangeEvent event) {
        SleipnirAbility.apply(event.getPlayer(), plugin);
    }
}
