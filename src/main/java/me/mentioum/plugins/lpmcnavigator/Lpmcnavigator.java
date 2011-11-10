package me.mentioum.plugins.lpmcnavigator;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Lpmcnavigator extends JavaPlugin {
    
    private Navigate navigateExecutor;
    
    public void onDisable() 
    {
        Messenger.Shutdown(this);
    }

    public void onEnable() 
    {    
        ConfigManager.Startup(this);
        
       
        if (ConfigManager.PluginEnabled() != true)
        {
            Messenger.StartupDisabled(this);
            this.getPluginLoader().disablePlugin(this);
            return;
        }
        PlayerDataManager.Startup(this);
        Messenger.Startup(this);
        RegisterEvents();
        CommandExecutors();    
    }

    
    private void RegisterEvents() 
    {
        PluginManager pm = this.getServer().getPluginManager();      
    }

    private void CommandExecutors() 
    {
        navigateExecutor = new Navigate (this);
        getCommand("navigate").setExecutor(navigateExecutor);
    }
    
    
    
}
