package me.Fraithor.FraithorPots;

import me.Fraithor.FraithorPots.Command.MainCommand;
import me.Fraithor.FraithorPots.Utilities.Player.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class FraithorPots extends JavaPlugin {

    public static FraithorPots instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("your_command_in_lower_case").setExecutor(new MainCommand());
        registerEvents(this, new PlayerListener());
    }

    public static FraithorPots getInstance() {
        return instance;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
