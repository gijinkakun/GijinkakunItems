package com.gijinkakunitems.events;

import com.gijinkakunitems.abilities.*;
import com.gijinkakunitems.GijinkakunItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitEventListener implements Listener {

    private final GijinkakunItems plugin;

    public ProjectileHitEventListener(GijinkakunItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        ChickenShooterAbility.apply(event, plugin);
        InfernoBowAbility.apply(event, plugin);
        TidecallerBowAbility.apply(event, plugin);
        ArcaneDetonatorAbility.apply(event, plugin);
        StormstrikerAbility.apply(event, plugin);
    }
}
