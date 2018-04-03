package de.unknown.craftevents;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import de.unknown.region.GetRegion;
import de.unknown.uuid.uuidfetcher;

public class RegionEnterEvent extends Event implements Cancellable{

	public static HandlerList list = new HandlerList();
	public boolean cancelled = false;
	public static ArrayList<Player>playerList = new ArrayList<>();
	
	Player player;
	
	public RegionEnterEvent(Player p) {
		player = p;
	}
	
	public static HandlerList getHandlerList() {
		return list;
	}
	
	public boolean isUserContainsToRegion() {
		return playerList.contains(player);
	}
	
	public String getOwner() {
		return GetRegion.getOwner(player.getLocation());
	}
	
	public boolean isUserInregion() {
		return GetRegion.isInRegion(player.getLocation());
	}
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		cancelled = arg0;
	}
	
	public boolean isUserOwner() {
		return GetRegion.getOwner(player.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(player.getName()).toString());
	}
	
	public static ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	@Override
	public HandlerList getHandlers() {
		return list;
	}
	
}
