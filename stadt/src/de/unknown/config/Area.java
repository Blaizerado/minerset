package de.unknown.config;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Area {
	public Area() {
		File f = new File("plugins/City/Area","100x100.yml");
		initConfig(f, "Config.size", "100x100");
		
		f = new File("plugins/City/Area","200x200.yml");
		initConfig(f, "Config.size", "200x200");
		
		f = new File("plugins/City/Area","400x400.yml");
		initConfig(f, "Config.size", "400x400");
		
		f = new File("plugins/City/Area","700x700.yml");
		initConfig(f, "Config.size", "700x700");
		
		f = new File("plugins/City/Area","1000x1000.yml");
		initConfig(f, "Config.size", "1000x1000");
	}
	
	private void initConfig(File f, String key, Object value) {
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		if(!cfg.isSet(key)) {
			cfg.set(key, value);
		}
		try {cfg.save(f);}catch(Exception e) {}
	}
}
