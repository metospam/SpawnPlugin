package Commands;

import Config.ConfigManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {
    public spawn(){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            ConfigManager manager = new ConfigManager("spawnlocation.yml");
            FileConfiguration cfg = manager.getConfig();

            Location location = (Location) cfg.get("location");

            player.teleport(location);
                player.sendMessage("Вы были телепортированы на спавн.");
        }
            sender.sendMessage("Вы должны быть игроком для использования этой команды.");
        return true;
    }
}
