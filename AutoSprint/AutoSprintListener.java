package AutoSprint;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;

public class AutoSprintListener implements Listener {
    
    // Schwellenwert für vertikale Bewegungsänderung; wenn überschritten, wird es als Sprung interpretiert
    private static final double Y_THRESHOLD = 0.01;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // Auto-Sprint nur verarbeiten, wenn aktiviert
        if (!AutoSprintManager.isAutoSprintEnabled(player.getUniqueId())) {
            return;
        }

        // Prüfen, ob sich der Spieler horizontal bewegt (Änderung in X oder Z)
        boolean horizontalMovement = event.getFrom().getX() != event.getTo().getX() ||
                                     event.getFrom().getZ() != event.getTo().getZ();
        // Vertikale Bewegung ermitteln
        double yDiff = event.getTo().getY() - event.getFrom().getY();
        boolean significantVertical = Math.abs(yDiff) > Y_THRESHOLD;

        // Nur auf dem Boden aktivieren: Das verhindert, dass in der Luft ständig setSprinting(true) aufgerufen wird.
        if (horizontalMovement && !significantVertical && player.isOnGround() &&
            !player.isSprinting() && player.getFoodLevel() > 6) {
            player.setSprinting(true);
            System.out.println("[AutoSprint] Sprint für " + player.getName() + " aktiviert (auf dem Boden).");
        }
    }
}
