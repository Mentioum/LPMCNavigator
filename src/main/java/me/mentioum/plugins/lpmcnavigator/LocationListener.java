package me.mentioum.plugins.lpmcnavigator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.Location;

public class LocationListener extends PlayerListener {
    private final Lpmcnavigator plugin;
    
        
    public LocationListener (Lpmcnavigator plugin)
    {
        this.plugin = plugin;   
    }
    
    public static void Spawn(CommandSender cs, String loc) 
    {    
        Player player = (Player)cs;
        Location spawn = player.getWorld().getSpawnLocation();
        player.setCompassTarget(spawn);
        int[] coord = {(int)spawn.getX(),(int)spawn.getY() ,(int)spawn.getZ()};
        Messenger.SendCoords(cs, coord, loc);
    }
    
        public static void Bed(CommandSender cs, String loc) 
    {    
        Player player = (Player)cs;
        Location bed = player.getBedSpawnLocation();
        player.setCompassTarget(bed);
        
        if(bed == null)
        {
            Messenger.NavigateBedError(cs);
            return;
        }
        
        int[] coord = {(int)bed.getX(),(int)bed.getY() ,(int)bed.getZ()};
        Messenger.SendCoords(cs, coord, loc);
    }
        
        
    
    
}
