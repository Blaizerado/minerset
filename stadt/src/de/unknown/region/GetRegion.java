package de.unknown.region;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class GetRegion {
	
	public static boolean isInRegion(Location loc) {
		File configs = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(configs);
		
		List<String>Shops = cfg1.getStringList("Config.Regions");
		
		for(String s : Shops) {
			File f = new File("plugins/City/Region", s+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(f.exists()) {
				Location loc1 = (Location) cfg.get("Config.Location.1");
				Location loc2 = (Location) cfg.get("Config.Location.2");
				
				String world = loc1.getWorld().getName();
				int x1 = (int) loc1.getX();
				int y1 = (int) loc1.getY();
				int z1 = (int) loc1.getZ();
				
				
				int x2 = (int) loc2.getX();
				int y2 = (int) loc2.getY();
				int z2 = (int) loc2.getZ();
				
				if(loc.getWorld().getName().equalsIgnoreCase(world)) {
					if((( x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && (( y1 <= loc.getY() && y2 >= loc.getY()) || (y1 >= loc.getY() && y2 <= loc.getY())) &&
							(( z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static ArrayList<String> getRegionFlags(Location loc) {
		File configs = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(configs);
		
		List<String>Shops = cfg1.getStringList("Config.Regions");
		
		for(String s : Shops) {
			File f = new File("plugins/City/Region", s+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(f.exists()) {
				Location loc1 = (Location) cfg.get("Config.Location.1");
				Location loc2 = (Location) cfg.get("Config.Location.2");
				
				String world = loc1.getWorld().getName();
				int x1 = (int) loc1.getX();
				int y1 = (int) loc1.getY();
				int z1 = (int) loc1.getZ();
				
				
				int x2 = (int) loc2.getX();
				int y2 = (int) loc2.getY();
				int z2 = (int) loc2.getZ();
				
				if(loc.getWorld().getName().equalsIgnoreCase(world)) {
					if((( x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && (( y1 <= loc.getY() && y2 >= loc.getY()) || (y1 >= loc.getY() && y2 <= loc.getY())) &&
							(( z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))){
						ArrayList<String>flag = (ArrayList<String>) cfg.getStringList("Config.Flags");
						return flag;
					}
				}
			}
		}
		return null;
	}
	
	public static File getRegionFile(Location loc) {
		File configs = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(configs);
		
		List<String>Shops = cfg1.getStringList("Config.Regions");
		
		for(String s : Shops) {
			File f = new File("plugins/City/Region", s+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(f.exists()) {
				Location loc1 = (Location) cfg.get("Config.Location.1");
				Location loc2 = (Location) cfg.get("Config.Location.2");
				
				String world = loc1.getWorld().getName();
				int x1 = (int) loc1.getX();
				int y1 = (int) loc1.getY();
				int z1 = (int) loc1.getZ();
				
				
				int x2 = (int) loc2.getX();
				int y2 = (int) loc2.getY();
				int z2 = (int) loc2.getZ();
				
				
				if(loc.getWorld().getName().equalsIgnoreCase(world)) {
					if((( x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && (( y1 <= loc.getY() && y2 >= loc.getY()) || (y1 >= loc.getY() && y2 <= loc.getY())) &&
							(( z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))){
						return f;
					}
				}
			}
		}
		return null;
	}
	
	public static List<String> getBuildUser(Location loc) {
		File configs = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(configs);
		
		List<String>Shops = cfg1.getStringList("Config.Regions");
		
		for(String s : Shops) {
			File f = new File("plugins/City/Region", s+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(f.exists()) {
				Location loc1 = (Location) cfg.get("Config.Location.1");
				Location loc2 = (Location) cfg.get("Config.Location.2");
				
				String world = loc1.getWorld().getName();
				int x1 = (int) loc1.getX();
				int y1 = (int) loc1.getY();
				int z1 = (int) loc1.getZ();
				
				
				int x2 = (int) loc2.getX();
				int y2 = (int) loc2.getY();
				int z2 = (int) loc2.getZ();
				
				if(loc.getWorld().getName().equalsIgnoreCase(world)) {
					if((( x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && (( y1 <= loc.getY() && y2 >= loc.getY()) || (y1 >= loc.getY() && y2 <= loc.getY())) &&
							(( z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))){
							List<String>user = cfg.getStringList("Config.User");
						return user;
					}
				}
			}
		}
		return null;
	}
	
	public static List<String> getDenyUser(Location loc) {
		File configs = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(configs);
		
		List<String>Shops = cfg1.getStringList("Config.Regions");
		
		for(String s : Shops) {
			File f = new File("plugins/City/Region", s+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(f.exists()) {
				Location loc1 = (Location) cfg.get("Config.Location.1");
				Location loc2 = (Location) cfg.get("Config.Location.2");
				
				String world = loc1.getWorld().getName();
				int x1 = (int) loc1.getX();
				int y1 = (int) loc1.getY();
				int z1 = (int) loc1.getZ();
				
				
				int x2 = (int) loc2.getX();
				int y2 = (int) loc2.getY();
				int z2 = (int) loc2.getZ();
				
				if(loc.getWorld().getName().equalsIgnoreCase(world)) {
					if((( x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && (( y1 <= loc.getY() && y2 >= loc.getY()) || (y1 >= loc.getY() && y2 <= loc.getY())) &&
							(( z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))){
							List<String>user = cfg.getStringList("Config.Deny");
						return user;
					}
				}
			}
		}
		return null;
	}
	
	public static String getOwner(Location loc) {
		File configs = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(configs);
		
		List<String>Shops = cfg1.getStringList("Config.Regions");
		
		for(String s : Shops) {
			File f = new File("plugins/City/Region", s+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(f.exists()) {
				Location loc1 = (Location) cfg.get("Config.Location.1");
				Location loc2 = (Location) cfg.get("Config.Location.2");
				
				String world = loc1.getWorld().getName();
				int x1 = (int) loc1.getX();
				int y1 = (int) loc1.getY();
				int z1 = (int) loc1.getZ();
				
				
				int x2 = (int) loc2.getX();
				int y2 = (int) loc2.getY();
				int z2 = (int) loc2.getZ();
				
				
				if(loc.getWorld().getName().equalsIgnoreCase(world)) {
					if((( x1 <= loc.getX() && x2 >= loc.getX()) || (x1 >= loc.getX() && x2 <= loc.getX())) && (( y1 <= loc.getY() && y2 >= loc.getY()) || (y1 >= loc.getY() && y2 <= loc.getY())) &&
							(( z1 <= loc.getZ() && z2 >= loc.getZ()) || (z1 >= loc.getZ() && z2 <= loc.getZ()))){
						return cfg.getString("Config.Owner");
					}
				}
			}
		}
		return null;
	}
	
}
