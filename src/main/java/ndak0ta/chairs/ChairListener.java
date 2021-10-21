package ndak0ta.chairs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ChairListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand().equals(EquipmentSlot.HAND) && (e.getClickedBlock().getType().name().contains("STAIRS") || e.getClickedBlock().getType().name().contains("SLAB"))) {
            if (!SitManager.isOccupied(e.getClickedBlock())) {
                SitManager.sit(e.getPlayer(), e.getClickedBlock());
            }
        }
    }
}
