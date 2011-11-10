package me.mentioum.plugins.lpmcnavigator;

import java.io.File;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.config.Configuration;

public class PlayerDataManager
{
    private static Plugin plugin;
    private static FileConfiguration playerdata;
    
    public PlayerDataManager(Lpmcnavigator plugin) 
    {
        this.plugin = plugin;
    }       

    public static void Startup(Plugin p)
    {
        plugin = p;  
        File playerDataFile = new File(plugin.getDataFolder(), "PlayerData.yml");
        FileConfiguration playerdata = YamlConfiguration.loadConfiguration(playerDataFile);
    }
    
    public static boolean CheckPlayer(Player player)
    {
        return playerdata.contains("Players." + player);
    }
    
        public static void NewPlayer(Player player)
    {
        playerdata.contains("Players." + player);
    }
    
    public static void PlayerOptionHide(Player player)
    {
        if(CheckPlayer(player) == false) {NewPlayer (player);}
        playerdata.set("Players." + player + ".Option.Hidden from Compass", false);   
    }
    
    
   
}
