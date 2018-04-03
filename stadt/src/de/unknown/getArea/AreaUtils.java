package de.unknown.getArea;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;


public class AreaUtils {
	public static HashMap<String, String>maps = new HashMap<>();
	
	public void addMaps() {
		File f = new File("plugins/City/Area","100x100.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		maps.put("100x100", cfg.getString("Config.size"));
		f = new File("plugins/City/Area","200x200.yml");
		cfg = YamlConfiguration.loadConfiguration(f);
		maps.put("200x200", cfg.getString("Config.size"));
		f = new File("plugins/City/Area","400x400.yml");
		cfg = YamlConfiguration.loadConfiguration(f);
		maps.put("400x400", cfg.getString("Config.size"));
		f = new File("plugins/City/Area","700x700.yml");
		cfg = YamlConfiguration.loadConfiguration(f);
		maps.put("700x700", cfg.getString("Config.size"));
		f = new File("plugins/City/Area","1000x1000.yml");
		cfg = YamlConfiguration.loadConfiguration(f);
		maps.put("1000x1000", cfg.getString("Config.size"));
	}
}
