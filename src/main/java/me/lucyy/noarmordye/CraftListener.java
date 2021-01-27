package me.lucyy.noarmordye;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {
    private final NoArmorDye plugin;

    public CraftListener(NoArmorDye plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(CraftItemEvent e) {
        if (e.getCurrentItem() == null) return;
        switch (e.getCurrentItem().getType()) {
            case LEATHER_BOOTS:
            case LEATHER_LEGGINGS:
            case LEATHER_CHESTPLATE:
            case LEATHER_HELMET:
                for (ItemStack item : e.getInventory().getMatrix()) {
                    if (item != null && item.getType() == Material.LEATHER) return;
                }
                e.setCancelled(true);
                if (e.getInventory().getHolder() instanceof Player) {
                    ((Player) e.getInventory().getHolder()).sendMessage(
                            ChatColor.translateAlternateColorCodes('&',
                                    plugin.getConfig().getString("message")));
                }
        }
    }
}
