package de.aljoshavieth.headsaddon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Aljosha on 16.12.2018
 */
public class AddonCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender.hasPermission("headsaddon.admin")){
            if(args.length == 2){
                if(args[0].equalsIgnoreCase("add")){
                    if (!Main.instance.headIsDisabled(args[1])){
                        Main.instance.addEntry(args[1]);
                        commandSender.sendMessage("§3Der Kopf von §a" + args[1] + " §3ist nun deaktiviert!");
                    } else {
                        commandSender.sendMessage("§3Dieser kopf ist bereits deaktiviert!");
                    }
                } else if(args[0].equalsIgnoreCase("remove")){
                    if (Main.instance.headIsDisabled(args[1])){
                        Main.instance.removeEntry(args[1]);
                        commandSender.sendMessage("§3Der Kopf von §a" + args[1] + " §3ist nun nicht mehr deaktiviert!");
                    } else {
                        commandSender.sendMessage("§3Dieser kopf ist nicht deaktiviert!");
                    }
                }
            }
        }
        return true;
    }
}
