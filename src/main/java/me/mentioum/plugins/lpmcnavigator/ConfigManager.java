package me.mentioum.plugins.lpmcnavigator;

import org.bukkit.plugin.Plugin;
import org.bukkit.util.config.Configuration;

public class ConfigManager {
    
    private static Configuration config;
    
    public static void Startup(Plugin plugin)
    {
        config = plugin.getConfiguration();
        config.load();
        PluginEnabled();
        PointAtPlayers();
        CompassInInventory();
        CompassInHand();
        PlayersCanHide();
        HasCooldown();
        config.save();
    }
   
    
//    Adding an easy way for Admins to disable the plugin without having to move files around on the server.
    public static Boolean PluginEnabled()
    {
        return config.getBoolean("Plugin Enabled", true);
    }
    
    
        public static Boolean PointAtPlayers()
    {
        return config.getBoolean("Compasses can point at players", true);
    }
    
        
        public static Boolean CompassInInventory()
    {
        return config.getBoolean("Players need to have a compass in their inventory", true);
    }
        
        
        public static Boolean CompassInHand()
    {
        return config.getBoolean("Players need to have a compass in their hand", true);
    }
        
        
        public static Boolean PlayersCanHide()
    {
        return config.getBoolean("Players can hide from compass pointing", true);
    }
      
        public static Boolean HasCooldown()
    {
        return config.getBoolean("Navigation Commands will obey cooldowns.", true);
    }



}
