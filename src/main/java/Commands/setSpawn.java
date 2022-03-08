package Commands;

import Config.ConfigManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class setSpawn implements CommandExecutor {
    public setSpawn(){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("setspawn.command")){
                ConfigManager manager = new ConfigManager("spawnlocation.yml");
                FileConfiguration cfg = manager.getConfig();

                Location location = player.getLocation();
                manager.getConfig().set("location", location);

                manager.save();

                player.sendMessage("Вы успешно установили точку спавна.");
            }
            player.sendMessage("У вас нет прав.");
        }
            sender.sendMessage("Вы должны быть игроком для использования этой команды.");
        return true;
    }
}
