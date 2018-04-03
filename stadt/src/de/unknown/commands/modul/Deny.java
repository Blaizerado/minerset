package de.unknown.commands.modul;

import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.unknown.config.MessageBuilder;
import de.unknown.region.GetRegion;
import de.unknown.statd.Stadt;
import de.unknown.uuid.uuidfetcher;

public class Deny extends GetRegion {

	public Deny(String[] args, Player p) {
		MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(isInRegion(p.getLocation())) {
			if(getOwner(p.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString()) || p.hasPermission("city.deny.*")) {
				if(!uuidfetcher.getUUID(args[1]).toString().equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString())) {
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(getRegionFile(p.getLocation()));
					List<String>denyUser = cfg.getStringList("Config.Deny");
					if(!denyUser.contains(uuidfetcher.getUUID(args[1]).toString())) {
						denyUser.add(uuidfetcher.getUUID(args[1]).toString());
						cfg.set("Config.Deny", denyUser);
						try {cfg.save(getRegionFile(p.getLocation()));}catch(Exception e) {}
						p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.denycreate"));
					}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.denyexist"));}
				}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.ownerdenyselft"));}
			}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.notowner"));}
		}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noinRegion"));}
	}

}
