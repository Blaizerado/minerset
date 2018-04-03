package de.unknown.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.unknown.region.GetRegion;

public class OnPvP extends GetRegion implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getDamager();
				if(isInRegion(p.getLocation())) {
					if(getRegionFlags(p.getLocation()).contains("PVP:true") || p.hasPermission("city.bypass")) {
					}else {e.setCancelled(true);}
				}
			}
		}
	}
}
