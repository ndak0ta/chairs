package ndak0ta.chairs;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class SitManager {
    private static HashMap<UUID, SitData> sitting = new HashMap<>();

    public static void sit(Player player, Block block) {
        if (sitting.containsKey(player.getUniqueId())) {
            if (sitting.get(player.getUniqueId()).chair.equals(block)) {
                return;
            }

            unsit(player);
        }

        sitting.put(player.getUniqueId(), new SitData(player, block));
    }

    public static void unsit(Player player) {
        sitting.get(player.getUniqueId()).unsit();
        sitting.remove(player.getUniqueId());
    }

    public static boolean isOccupied(Block block) {
        return true;
    }
}
