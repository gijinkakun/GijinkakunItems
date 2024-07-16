package com.gijinkakunitems.events;

import com.gijinkakunitems.abilities.StormstrikerAbility;
import com.gijinkakunitems.abilities.TempestScytheAbility;
import com.gijinkakunitems.abilities.ShroomBladeAbility;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityEventListener implements Listener {

    private final GijinkakunItems plugin;

    public EntityDamageByEntityEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        ShroomBladeAbility.apply(event, plugin);
        TempestScytheAbility.apply(event, plugin);
        StormstrikerAbility.apply(event, plugin);
    }
}
 