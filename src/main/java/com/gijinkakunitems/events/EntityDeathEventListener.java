package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.abilities.BloodrenderAbility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EntityDeathEventListener implements Listener {

    private final GijinkakunItems plugin;

    public EntityDeathEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        BloodrenderAbility.apply(event, plugin);
    }
}
