package me.mentioum.plugins.lpmcnavigator;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Messenger {
    
    private static Plugin plugin;
    private static Logger logger;
    private static String prefix;
    
        public static void Startup(Plugin p)
        {
            logger = Logger.getLogger("minecraft");
            plugin = p;
            prefix = ChatColor.GREEN + "[LPMCNavigator] " + ChatColor.WHITE;
            LogInfo(prefix + plugin.getDescription().getName() + " V." + plugin.getDescription().getVersion() + " by " + plugin.getDescription().getAuthors() + " is enabled");
        }
        public static void StartupDisabled(Plugin p)
        {
            logger = Logger.getLogger("minecraft");
            plugin = p;
            prefix = (ChatColor.BLUE + "[LPMCNavigator] " + ChatColor.WHITE);
            LogInfo(prefix + plugin.getDescription().getName() + " is disabled in config.yml Plugin will now disable itself!");
        }        
        
        public static void Shutdown(Plugin p)
        {
            logger = Logger.getLogger("minecraft");
            plugin = p;
            prefix = "[LPMCNavigator] ";
            LogInfo(prefix + plugin.getDescription().getName() + " V." + plugin.getDescription().getVersion() + " by " + plugin.getDescription().getAuthors() + " is disabled.");
        }
        
        public static void LogInfo(String message)
	{
		logger.info(message);
	}
    
        public static void Reloaded(CommandSender cs)
        {
            cs.sendMessage(ChatColor.BLUE + "LPMCNavigator configuration file" + ChatColor.GREEN + " reloaded" + ChatColor.BLUE +".");
            logger.info(prefix+ " " + cs + "has reloaded the configuration file");   
        }
    
        public static void Hidden(CommandSender cs)
        {
            cs.sendMessage(ChatColor.BLUE + "You are "+ ChatColor.RED + "already hidden!");
        }
        
        public static void NowHidden(CommandSender cs)
        {
        cs.sendMessage(ChatColor.BLUE + "You are" + ChatColor.GREEN + " now hidden!"); 
        }
        
        public static void IsDisabled(CommandSender cs)
        {
            cs.sendMessage(ChatColor.BLUE + "This feature is" + ChatColor.RED + " disabled" + ChatColor.BLUE + " on this server.");
        }
        
        public static void Visible(CommandSender cs)
        {
            cs.sendMessage(ChatColor.BLUE + "You are "+ ChatColor.RED + "already visible!");
        }
        
        public static void IsVisible(CommandSender cs)
        {
            cs.sendMessage(ChatColor.BLUE + "You are" + ChatColor.GREEN + " now visible!");
        }

        public static void DenyConsole(CommandSender cs) 
        {
            cs.sendMessage(prefix + ChatColor.RED + "This command may only be sent as a player!");
        }
        
        public static void PlayerMessage(CommandSender cs, String message)
        {
            cs.sendMessage(prefix + message);
        }
        
        public static void HelpMessage(CommandSender cs)
        {
            cs.sendMessage(prefix + ChatColor.GREEN + "- [Help File]");
            cs.sendMessage("/navigate " + ChatColor.BLUE + "- Shows this help message.");
            cs.sendMessage("/navigate reload " + ChatColor.BLUE + "- Reloads database.");
            cs.sendMessage("/navigate player <name> " + ChatColor.BLUE + "- Points compass at <playername>");
            cs.sendMessage("/navigate location <name> " + ChatColor.BLUE + "- Points compass at <location>");   
        }
        
        public static void SendCoords (CommandSender cs, int[] coord, String loc)
        {
            cs.sendMessage(prefix + ChatColor.GREEN + "- [Compass pointed at "+ ChatColor.WHITE + loc + ChatColor.GREEN + ".]");
            cs.sendMessage(ChatColor.BLUE + "X :  " + ChatColor.WHITE + coord[0]);
            cs.sendMessage(ChatColor.BLUE + "Y :  " + ChatColor.WHITE + coord[1]);
            cs.sendMessage(ChatColor.BLUE + "Z :  " + ChatColor.WHITE + coord[2]);
        }
        
        public static void NavigateLocationError (CommandSender cs)
        {   
            cs.sendMessage(prefix);
            cs.sendMessage(ChatColor.RED + "Incorrect Syntax - Please write as below:");
            cs.sendMessage(ChatColor.BLUE + "/navigate location <locationname>");
        }
        
        public static void NavigatePlayerError (CommandSender cs)
        {   
            cs.sendMessage(prefix);
            cs.sendMessage(ChatColor.RED + "Incorrect Syntax - Please write as below:");
            cs.sendMessage(ChatColor.BLUE + "/navigate player <playername - supports unique identifiers.>");
        }
        
        public static void NavigatePlayerOffline (CommandSender cs, String targetPlayer)
        {   
            cs.sendMessage(prefix);
            cs.sendMessage(ChatColor.RED + "There is no-one online with the name "+ ChatColor.WHITE + targetPlayer + ChatColor.RED +" or with a name which starts with "+ ChatColor.WHITE + targetPlayer + ChatColor.RED + ".");
            cs.sendMessage(ChatColor.BLUE + "/navigate player <playername - supports unique identifiers and not case sensitive.>");
        }
        
        public static void NavigateBedError (CommandSender cs)
        {   
            cs.sendMessage(prefix);
            cs.sendMessage(ChatColor.RED + "You do not have a bed spawn point yet!");
            cs.sendMessage(ChatColor.BLUE + "Try sleeping in a bed to set your bed spawn point.");
        }
}

