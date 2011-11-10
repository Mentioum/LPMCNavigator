package me.mentioum.plugins.lpmcnavigator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



class Helpers {

    public static Player matchUniquePlayer(CommandSender cs, String targetPlayer)
    {
        List<Player> matchedPlayers = Bukkit.getServer().matchPlayer(targetPlayer);
        if(matchedPlayers.size() == 1)
        { 
            return matchedPlayers.get(0);
        }
        
        return null;
    }
    
    public static String matchUniquePlayers(CommandSender cs, String targetPlayer)
    {     
        List<Player> matchedPlayers = Bukkit.getServer().matchPlayer(targetPlayer);
        
        if(matchedPlayers.size() == 0)
        { 
            return null;
        }
        
        ArrayList matchedPlayersArrayList = new ArrayList();
        matchedPlayersArrayList.addAll(matchedPlayers);
        String matchedPlayersStringList = matchedPlayersArrayList.toString();
        return matchedPlayersStringList;
    }
    
}
