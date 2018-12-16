package de.aljoshavieth.headsaddon;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Created by Aljosha on 16.12.2018
 */
public class CommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        System.out.println("command detected");
        Player player = event.getPlayer();
        String command = event.getMessage();
        System.out.println("command = " + command);
        if(command.startsWith("/head")){
            if(!player.hasPermission("headsaddon.bypass")){
                String[] s = command.split(" ");
                System.out.println("s " + s);
                String playername = s[1];
                System.out.println("playername " + playername);
                if(Main.instance.headIsDisabled(playername)){
                    System.out.println("cancel this...");
                    event.setCancelled(true);
                    player.sendMessage("§3Du kannst dir diesen Kopf nicht geben!");
                }
            }
        }
    }
}
