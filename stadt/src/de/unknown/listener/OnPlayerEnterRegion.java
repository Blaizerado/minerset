package de.unknown.listener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.unknown.achtionbar.Actionbar;
import de.unknown.config.MessageBuilder;
import de.unknown.craftevents.RegionEnterEvent;
import de.unknown.craftevents.RegionLeaveEvent;
import de.unknown.region.GetRegion;
import de.unknown.skullchat.Skull;
import de.unknown.uuid.uuidfetcher;

public class OnPlayerEnterRegion implements Listener {
		
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Bukkit.getPluginManager().callEvent(new RegionEnterEvent(e.getPlayer()));
		Bukkit.getPluginManager().callEvent(new RegionLeaveEvent(e.getPlayer()));
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onEnter(RegionEnterEvent e) {
		Player p = e.getPlayer();
		if(e.isUserInregion()) {
			if(!e.isUserContainsToRegion()) {
				
				if(GetRegion.getDenyUser(p.getLocation()).contains(uuidfetcher.getUUID(p.getName()).toString())) {
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(GetRegion.getRegionFile(e.getPlayer().getLocation()));
					Location loc = (Location) cfg.get("Config.Location.1");
					p.teleport(new Location(loc.getWorld(), loc.getX(), p.getLocation().getY(), loc.getZ()));
					return;
				}
				
				if(GetRegion.getRegionFlags(e.getPlayer().getLocation()).contains("TIME:day")) {
					e.getPlayer().setPlayerTime(10000, true);
				}else if(GetRegion.getRegionFlags(e.getPlayer().getLocation()).contains("TIME:nigth")) {
					e.getPlayer().setPlayerTime(7000, true);
				}
				
				if(GetRegion.getRegionFlags(e.getPlayer().getLocation()).contains("WEATHER:lock")) {
					e.getPlayer().setPlayerWeather(WeatherType.CLEAR);
				}
				
				if(!e.isUserOwner()) {
					e.playerList.add(p);
					MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
					if(GetRegion.getRegionFlags(e.getPlayer().getLocation()).contains("ENTER:1")) {
						String message = b.getMessage("Config.Inventory.Message.cityenter");
						message = message.replace("[PLAYER]", uuidfetcher.getName(UUID.fromString(e.getOwner())));
						Actionbar.sendActionBarTime(e.getPlayer(), message, 40);
					}else if(GetRegion.getRegionFlags(e.getPlayer().getLocation()).contains("ENTER:2")) {
						String[] msg = {b.getMessage("Config.Inventory.Message.skull.1"),
									    b.getMessage("Config.Inventory.Message.skull.2"),
									    b.getMessage("Config.Inventory.Message.skull.3").replace("[PLAYER]", uuidfetcher.getName(UUID.fromString(e.getOwner()))),
									    b.getMessage("Config.Inventory.Message.skull.4"),
									    b.getMessage("Config.Inventory.Message.skull.5").replace("[NAME]", "test"),
									    b.getMessage("Config.Inventory.Message.skull.6"),
									    b.getMessage("Config.Inventory.Message.skull.7")};
						System.out.println(msg[0]);
						Skull s = new Skull(uuidfetcher.getName(UUID.fromString(e.getOwner())), msg);
						s.sendByName(e.getPlayer());
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onLeave(RegionLeaveEvent e) {
		if(!e.isUserInRegion()) {
			if(e.isUserInPlayerList()) {
				e.getPlayer().resetPlayerTime();
				e.getPlayer().resetPlayerWeather();
				e.removePlayerFromRegion();
			}
		}
	}
	
}
