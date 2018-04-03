package de.unknown.commands.modul;

import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.unknown.config.MessageBuilder;
import de.unknown.region.GetRegion;
import de.unknown.statd.Stadt;
import de.unknown.uuid.uuidfetcher;

public class User extends GetRegion{

	public User(String[] args, Player p) {
		MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(args[1].equalsIgnoreCase("add")) {
			if(isInRegion(p.getLocation())) {
				if(getOwner(p.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString()) || p.hasPermission("city.user.'")) {
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(getRegionFile(p.getLocation()));
					List<String>User = cfg.getStringList("Config.User");
					if(!User.contains(uuidfetcher.getUUID(args[2]).toString())) {
						User.add(uuidfetcher.getUUID(args[2]).toString());
						cfg.set("Config.User", User);
						try {cfg.save(getRegionFile(p.getLocation()));} catch (Exception e) {}
						p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.useradd"));
					}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.userexist"));}
				}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.notowner"));}
			}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noinRegion"));}
		}else if(args[1].equalsIgnoreCase("remove")) {
			if(isInRegion(p.getLocation())) {
				if(getOwner(p.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString()) || p.hasPermission("city.user.'")) {
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(getRegionFile(p.getLocation()));
					List<String>User = cfg.getStringList("Config.User");
					if(User.contains(uuidfetcher.getUUID(args[2]).toString())) {
						User.remove(uuidfetcher.getUUID(args[2]).toString());
						cfg.set("Config.User", User);
						try {cfg.save(getRegionFile(p.getLocation()));} catch (Exception e) {}
						p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.userremove"));
					}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.usernotexist"));}
				}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.notowner"));}
			}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noinRegion"));}
		}
	}

}
