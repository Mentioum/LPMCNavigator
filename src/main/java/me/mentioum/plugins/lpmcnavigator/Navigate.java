package me.mentioum.plugins.lpmcnavigator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class Navigate implements CommandExecutor {
    private Lpmcnavigator plugin;
    public Navigate(Lpmcnavigator plugin) 
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender cs, Command command, String label, String[] args)
    {
        
        if (args.length == 0)
        { 
            Messenger.HelpMessage(cs);
            return true;
        }    
        
        if(!(cs instanceof Player))
            {
                Messenger.DenyConsole(cs);
                return true;
            }
        
        if (args.length == 1)
        {
            if(args[0].equalsIgnoreCase("location")||args[0].equalsIgnoreCase("loc")||args[0].equalsIgnoreCase("l"))
            {
                Messenger.NavigateLocationError(cs);
            }
        }
        
        if (args.length == 2)
        {
            if(args[0].equalsIgnoreCase("location")||args[0].equalsIgnoreCase("loc")||args[0].equalsIgnoreCase("l"))
            {    
                if(args[1].equalsIgnoreCase("spawn"))
                {
                    String loc = args[1];
                    LocationListener.Spawn(cs, loc);
                }
                
                if(args[1].equalsIgnoreCase("bed"))
                {
                    String loc = args[1];
                    LocationListener.Bed(cs, loc);
                    
                }
            }
            
        }
            
      return true;  
    }
    
}
