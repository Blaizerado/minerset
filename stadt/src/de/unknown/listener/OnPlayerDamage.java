package de.unknown.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.unknown.region.GetRegion;

public class OnPlayerDamage extends GetRegion implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(isInRegion(e.getEntity().getLocation())) {
				Player p = (Player) e.getEntity();
				if(getRegionFlags(e.getEntity().getLocation()).contains("DAMAGE:true") || p.hasPermission("city.bypass")) {
					
				}else {e.setCancelled(true);}
			}
		}
	}
	
}
