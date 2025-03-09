package AutoSprint;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSprintCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNur Spieler können diesen Befehl benutzen!");
            return true;
        }

        Player player = (Player) sender;
        boolean enabled = AutoSprintManager.toggleAutoSprint(player.getUniqueId());

        if (enabled) {
            player.sendMessage("§aAuto-Sprint wurde §laktiviert!");
        } else {
            player.sendMessage("§cAuto-Sprint wurde §ldeaktiviert!");
        }

        return true;
    }
}
