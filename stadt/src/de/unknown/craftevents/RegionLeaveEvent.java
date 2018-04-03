package de.unknown.craftevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import de.unknown.region.GetRegion;

public class RegionLeaveEvent extends Event implements Cancellable{

	public static HandlerList list = new HandlerList();
	public boolean canceld = false;
	
	Player player;

	public RegionLeaveEvent(Player p) {
		player = p;
	}
	
	public static HandlerList getHandlerList() {
		return list;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void removePlayerFromRegion() {
		RegionEnterEvent.playerList.remove(player);
	}
	
	public boolean isUserInPlayerList() {
		return RegionEnterEvent.playerList.contains(player);
	}
	
	public boolean isUserInRegion() {
		return GetRegion.isInRegion(player.getLocation());
	}
	
	@Override
	public boolean isCancelled() {
		return canceld;
	}

	@Override
	public void setCancelled(boolean arg0) {
		canceld = arg0;
	}

	@Override
	public HandlerList getHandlers() {
		return list;
	}
	
}
