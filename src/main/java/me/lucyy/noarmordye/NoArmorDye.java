package me.lucyy.noarmordye;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoArmorDye extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getConfig().addDefault("message", "&cDyeing leather armor is disabled on this server");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        getServer().getPluginManager().registerEvents(new CraftListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
