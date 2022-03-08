package mc.spawnplugin;

import Commands.setSpawn;
import Commands.spawn;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("MEM");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("spawn").setExecutor(new spawn());
        getCommand("setspawn").setExecutor(new setSpawn());
    }

    public static Main getInstance() {
        return instance;
    }
}
