package AutoSprint;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ErstesPlugin extends JavaPlugin{

	public void onEnable() {
		System.out.println("Plugin enabled!!!1-----------------------------------------------------------------");
		
		// Befehl registrieren
        if (getCommand("autosprint") != null) {
            getCommand("autosprint").setExecutor(new AutoSprintCommand());
        } else {
            getLogger().warning("Fehler: Befehl 'autosprint' konnte nicht registriert werden!");
        }
		
		//Eventlistener registrieren
		Bukkit.getPluginManager().registerEvents(new AutoSprintListener(), this);
	}
	
	public void onDisable() {
		System.out.println("Plugin disabled!!!1----------------------------------------------------------------");
	}

}
