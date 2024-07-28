package com.gijinkakunitems;

import com.gijinkakunitems.events.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;

public class GijinkakunItems extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EntityDamageEventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickEventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractEventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveEventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ProjectileHitEventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(this), this);
        getCommand("gijinkakunitems").setTabCompleter(new ItemTabCompleter());
        CustomRecipes.registerRecipes(this);
        logToConsole("Gijinkakun Items has been enabled!", ChatColor.GREEN);
    }

    @Override
    public void onDisable() {
        logToConsole("Gijinkakun Items has been disabled!", ChatColor.RED);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return CommandHandler.handleCommand(this, sender, cmd, label, args);
    }

    private void logToConsole(String message, ChatColor color) {
        Bukkit.getConsoleSender().sendMessage(color + message);
    }
}
