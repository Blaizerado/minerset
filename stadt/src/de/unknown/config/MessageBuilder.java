package de.unknown.config;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import net.md_5.bungee.api.ChatColor;

public class MessageBuilder {
	private File a;
	public MessageBuilder(String file, String cfgname) {
		this.a = new File(file, cfgname);
	}
	
	public String getMessage(String key) {
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(this.a);
		if(cfg.isSet(key)) {
			return ChatColor.translateAlternateColorCodes('&', cfg.getString(key));
		}else {return null;}
	}
}
