package de.aljoshavieth.headsaddon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

/**
 * Created by Aljosha on 16.12.2018
 */
public class Main extends JavaPlugin {
    static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        PluginManager pluginManager = Bukkit.getPluginManager();
        saveDefaultConfig();
        pluginManager.registerEvents(new CommandListener(), this);
        getCommand("headsaddon").setExecutor(new AddonCommand());
    }

    boolean headIsDisabled(String name){
        return getConfig().getList("disabledHeads").contains(name);
    }

    void addEntry(String name){
        List<String>  list = getConfig().getStringList("disabledHeads");
        list.add(name);
        getConfig().set("disabledHeads", list);
        saveConfig();
    }

    void removeEntry(String name){
        List list = getConfig().getStringList("disabledHeads");
        list.remove(name);
        getConfig().set("disabledHeads", list);
        saveConfig();
    }
}
