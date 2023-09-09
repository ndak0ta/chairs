package ndak0ta.chairs;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class SitManager {
    private static HashMap<UUID, SitData> sitting = new HashMap<>();
    private Main main;

    public SitManager(Main main) {
        this.main = main;
    }

    public void sit(Player player, Block block) {
        if (sitting.containsKey(player.getUniqueId())) {
            if (sitting.get(player.getUniqueId()).chair.equals(block)) {
                return;
            }

            unsit(player);
        }

        sitting.put(player.getUniqueId(), new SitData(main, player, block));
    }

    public void unsit(Player player) {
        sitting.get(player.getUniqueId()).unsit();
        sitting.remove(player.getUniqueId());
    }

    public void unsit(Block chair) {
        UUID remove = null;

        for (UUID uuid : sitting.keySet()) {
            SitData data = sitting.get(uuid);

            if (data.chair.equals(chair)) {
                data.unsit();
            }

            remove = uuid;
        }

        if (remove != null) {
            sitting.remove(remove);
        }
    }

    public boolean isOccupied(Block block) {
        for (SitData data : sitting.values()) {
            if (data.chair.equals(block)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSitting(Player player) {
        return sitting.containsKey(player.getUniqueId());
    }
}
