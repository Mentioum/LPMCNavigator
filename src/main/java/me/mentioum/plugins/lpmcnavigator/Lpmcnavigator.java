package me.mentioum.plugins.lpmcnavigator;

import org.bukkit.plugin.java.JavaPlugin;

public class Lpmcnavigator extends JavaPlugin {
    public void onDisable() {
        Messenger.Shutdown(this);
    }

    public void onEnable() {
        Messenger.Startup(this);
    }
}
