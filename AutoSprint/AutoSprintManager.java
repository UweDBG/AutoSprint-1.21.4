package AutoSprint;

import java.util.HashSet;
import java.util.UUID;

public class AutoSprintManager {
	private static HashSet<UUID> autoSprintPlayers = new HashSet<>();

    // Aktiviert oder deaktiviert Auto-Sprint für einen Spieler
    public static boolean toggleAutoSprint(UUID playerUUID) {
        if (autoSprintPlayers.contains(playerUUID)) {
            autoSprintPlayers.remove(playerUUID);
            return false; // Auto-Sprint wurde deaktiviert
        } else {
            autoSprintPlayers.add(playerUUID);
            return true; // Auto-Sprint wurde aktiviert
        }
    }

    // Prüfen, ob Auto-Sprint für den Spieler aktiv ist
    public static boolean isAutoSprintEnabled(UUID playerUUID) {
        return autoSprintPlayers.contains(playerUUID);
    }
}
