package me.Fraithor.FraithorPots;

import me.Fraithor.FraithorPots.Command.MainCommand;
import me.Fraithor.FraithorPots.Utilities.File.FileBasics;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FraithorPots extends JavaPlugin {

    public static FraithorPots instance;
    private final FileBasics files = new FileBasics();
    private final Potions potions = new Potions();
    private final MainCommand cmd = new MainCommand();

    @Override
    public void onEnable() {
        instance = this;
        getCommand("fraithorpots").setExecutor(cmd);
        getCommand("fraithorpots").setTabCompleter(cmd);
        load();
    }

    public static FraithorPots getInstance() {
        return instance;
    }

    public Potions getPotions() {
        return potions;
    }

    public void load() {
        potions.load();
        files.load();
    }
}
