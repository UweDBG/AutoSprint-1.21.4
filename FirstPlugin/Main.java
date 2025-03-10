package FirstPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements org.bukkit.event.Listener{

	public void onEnable() {
		System.out.println("Plugin enabled!!!1-----------------------------------------------------------------");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		System.out.println("Plugin disabled!!!1----------------------------------------------------------------");
	}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Willkommen auf dem Server!");
    }
}
