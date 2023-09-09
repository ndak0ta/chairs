package ndak0ta.chairs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        SitManager sitManager = new SitManager(this);

        Bukkit.getPluginManager().registerEvents(new ChairListener(sitManager), this);
    }
}
