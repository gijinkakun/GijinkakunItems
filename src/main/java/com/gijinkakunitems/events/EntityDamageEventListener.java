package com.gijinkakunitems.events;

import com.gijinkakunitems.GijinkakunItems;
import com.gijinkakunitems.abilities.TempestScytheAbility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageEventListener implements Listener {

    private final GijinkakunItems plugin;

    public EntityDamageEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        TempestScytheAbility.apply(event, plugin);
    }
}
