package com.gijinkakunitems.events;

import com.gijinkakunitems.abilities.*;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EntityDamageEventListener implements Listener {

    private final GijinkakunItems plugin;

    public EntityDamageEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        ShroomBladeAbility.apply(event, plugin);
        TempestScytheAbility.apply(event, plugin);
        StormstrikerAbility.apply(event, plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        ShroomBladeAbility.dropShroomSacrifice(event, plugin);
        BloodrenderAbility.apply(event, plugin);
        ShroomBladeAbility.apply(event, plugin);
        MythrilbreakerAbility.apply(event, plugin);
        EarthshaperAbility.apply(event, plugin);
        TimbercleaverAbility.apply(event, plugin);
        ChickenShooterAbility.apply(event, plugin);
        InfernoBowAbility.apply(event, plugin);
        TidecallerBowAbility.apply(event, plugin);
        ArcaneDetonatorAbility.apply(event, plugin);
        StormstrikerAbility.apply(event, plugin);
        TempestScytheAbility.apply(event, plugin);
        VerdantPurifierAbility.apply(event, plugin);
        AmethyriteEdgeAbility.apply(event, plugin);
    }
}
