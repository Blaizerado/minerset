package de.unknown.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.unknown.region.GetRegion;
import de.unknown.uuid.uuidfetcher;

public class OnBlockBreak extends GetRegion implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(isInRegion(e.getPlayer().getLocation())) {
			if(getBuildUser(e.getPlayer().getLocation()).contains(uuidfetcher.getUUID(e.getPlayer().getName()).toString()) 
					||getOwner(e.getPlayer().getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(e.getPlayer().getName()).toString())
					|| e.getPlayer().hasPermission("city.Bypass")) {
			}else {e.setCancelled(true);}
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(isInRegion(e.getPlayer().getLocation())) {
			if(getBuildUser(e.getPlayer().getLocation()).contains(uuidfetcher.getUUID(e.getPlayer().getName()).toString()) 
					||getOwner(e.getPlayer().getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(e.getPlayer().getName()).toString())
					|| e.getPlayer().hasPermission("city.Bypass")) {
			}else {e.setCancelled(true);}
		}
	}
}
