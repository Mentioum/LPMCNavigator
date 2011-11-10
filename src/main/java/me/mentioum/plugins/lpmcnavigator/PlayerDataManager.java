package me.mentioum.plugins.lpmcnavigator;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerDataManager extends Lpmcnavigator
{   
   
    
    private File PlayerDataFile = new File(getDataFolder(), "PlayerData.yml");
    private FileConfiguration playerData = YamlConfiguration.loadConfiguration(configFile);


    
    playerData.setProperty("test", "Test");
    playerData.save;
    

    
    public void reloadPlayerData()
    {
        
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
        playerdata.set("Players." + player + ".Option.Hidden from Compass", true);
        
    }
    
    public static void PlayerOptionReveal(Player player)
    {
        if(CheckPlayer(player) == false) {NewPlayer (player);}
        playerdata.set("Players." + player + ".Option.Hidden from Compass", false);
        SavePlayerDataFile();
    }
}
