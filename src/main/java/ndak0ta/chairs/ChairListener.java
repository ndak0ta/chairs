package ndak0ta.chairs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.spigotmc.event.entity.EntityDismountEvent;

public class ChairListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand().equals(EquipmentSlot.HAND) && (e.getClickedBlock().getType().name().contains("STAIRS") || e.getClickedBlock().getType().name().contains("SLAB"))) {
            if (!SitManager.isOccupied(e.getClickedBlock())) {
                SitManager.sit(e.getPlayer(), e.getClickedBlock());
            }
        }
    }

    @EventHandler
    public void onEntityDismount(EntityDismountEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            if (SitManager.isSitting(player)) {
                SitManager.unsit(player);
            }
        }
    }

    @EventHandler
    public void onPLayerTeleport(PlayerTeleportEvent e) {
        Player player = (Player) e.getPlayer();

        if (SitManager.isSitting(player)) {
            SitManager.unsit(player);
        }
    }

    @EventHandler
    public void onPLayerDeath(PlayerDeathEvent e) {
        Player player = (Player) e.getEntity();

        if (SitManager.isSitting(player)) {
            SitManager.unsit(player);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (SitManager.isOccupied(e.getBlock())) {
            SitManager.unsit(e.getBlock());
        }
    }
}
