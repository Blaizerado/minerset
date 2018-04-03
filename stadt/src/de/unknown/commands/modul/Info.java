package de.unknown.commands.modul;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.unknown.config.MessageBuilder;
import de.unknown.region.GetRegion;
import de.unknown.statd.Stadt;
import de.unknown.uuid.uuidfetcher;

public class Info extends GetRegion{

	public Info(String[] args, Player p) {
		MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(p.hasPermission("city.info") || getOwner(p.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString())) {
			if(isInRegion(p.getLocation())) {
				File f = getRegionFile(p.getLocation());
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
				
				p.sendMessage(b.getMessage("Config.Inventory.Message.skull.1"));
				p.sendMessage("§6Owner: §c" + uuidfetcher.getName(UUID.fromString(cfg.getString("Config.Owner"))));
				p.sendMessage("§6UUID: §c" + cfg.getString("Config.Owner"));
				p.sendMessage("§6ID: §c" + f.getName().replace(".yml", " "));
				p.sendMessage("§6Regionen: §c 0");
				p.sendMessage("§6User: §c"+getBuildUser(p.getLocation()));
				p.sendMessage("§6Flags: §c" + getRegionFlags(p.getLocation()));
				p.sendMessage(b.getMessage("Config.Inventory.Message.skull.7"));
			}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noinRegion"));}
		}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noPermission"));}
	}

}
