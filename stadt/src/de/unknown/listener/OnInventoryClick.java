package de.unknown.listener;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.unknown.config.MessageBuilder;
import de.unknown.statd.Stadt;
import de.unknown.uuid.uuidfetcher;

public class OnInventoryClick implements Listener {

	private Stadt main;

	public OnInventoryClick(Stadt stadt) {
		this.main = stadt;
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onInventory(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		final MessageBuilder m = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(e.getInventory().getName().equalsIgnoreCase(m.getMessage("Config.Inventory.SelectSize"))) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(m.getMessage("Config.Inventory.Select.100x100"))) {
				if(main.getConfig().getBoolean("Config.100x100")) {
					File f = new File("plugins/City/Area","100x100.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					String[] loc = cfg.getString("Config.size").split("x");
					createArea(Integer.valueOf(loc[0]), Integer.valueOf(loc[1]), p);
				}else {
					p.sendMessage(main.getPrefix() + m.getMessage("Config.Inventory.Select.message.noaktiv"));
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					p.closeInventory();
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(m.getMessage("Config.Inventory.Select.200x200"))) {
				if(main.getConfig().getBoolean("Config.200x200")) {
					File f = new File("plugins/City/Area","200x200.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					String[] loc = cfg.getString("Config.size").split("x");
					createArea(Integer.valueOf(loc[0]), Integer.valueOf(loc[1]), p);
				}else {
					p.sendMessage(main.getPrefix() + m.getMessage("Config.Inventory.Select.message.noaktiv"));
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					p.closeInventory();
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(m.getMessage("Config.Inventory.Select.400x400"))) {
				if(main.getConfig().getBoolean("Config.400x400")) {
					File f = new File("plugins/City/Area","400x400.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					String[] loc = cfg.getString("Config.size").split("x");
					createArea(Integer.valueOf(loc[0]), Integer.valueOf(loc[1]), p);
				}else {
					p.sendMessage(main.getPrefix() + m.getMessage("Config.Inventory.Select.message.noaktiv"));
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					p.closeInventory();
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(m.getMessage("Config.Inventory.Select.700x700"))) {
				if(main.getConfig().getBoolean("Config.700x700")) {
					File f = new File("plugins/City/Area","700x700.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					String[] loc = cfg.getString("Config.size").split("x");
					createArea(Integer.valueOf(loc[0]), Integer.valueOf(loc[1]), p);
				}else {
					p.sendMessage(main.getPrefix() + m.getMessage("Config.Inventory.Select.message.noaktiv"));
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					p.closeInventory();
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(m.getMessage("Config.Inventory.Select.1000x1000"))) {
				if(main.getConfig().getBoolean("Config.1000x1000")) {
					File f = new File("plugins/City/Area","1000x1000.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
					String[] loc = cfg.getString("Config.size").split("x");
					createArea(Integer.valueOf(loc[0]), Integer.valueOf(loc[1]), p);
				}else {
					p.sendMessage(main.getPrefix() + m.getMessage("Config.Inventory.Select.message.noaktiv"));
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					p.closeInventory();
				}
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void createArea(Integer x, Integer y, Player Owner) {
		File f = new File("plugins/City/Region", "Regions.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
			if(!f.exists()) {
				cfg.set("Config.Regions", Arrays.asList("Region-1"));
				try {cfg.save(f);}catch(Exception e) {}
			}
			List<String>region = cfg.getStringList("Config.Regions");	
			Integer i = region.size() +1;
			region.add("Region-"+i);
			cfg.set("Config.Regions", region);
			try {cfg.save(f);} catch (Exception e) {}
			
			
			f = new File("plugins/City/Region","Region-"+i+".yml");
			cfg = YamlConfiguration.loadConfiguration(f);
			final MessageBuilder m = new MessageBuilder("plugins/City/Message", "Message.yml");
			if(!f.exists()) {
				Owner.closeInventory();
				cfg.set("Config.Name", "Region-"+i);
				cfg.set("Config.Location.1", new Location(Owner.getWorld(), Owner.getLocation().getX()+x, 265, Owner.getLocation().getZ()+y));
				cfg.set("Config.Location.2", new Location(Owner.getWorld(), Owner.getLocation().getX()-x, 0, Owner.getLocation().getZ()-y));
				cfg.set("Config.Spawn",Owner.getLocation());
				cfg.set("Config.Owner", uuidfetcher.getUUID(Owner.getName()).toString());
				cfg.set("Config.CityName", "City von " + Owner.getName());
				cfg.set("Config.User", null);
				cfg.set("Config.Deny", null);
				cfg.set("Config.Range", null);
				cfg.set("Config.Flags", Arrays.asList("ENTER:1","PVP:true"));
				cfg.set("Config.Deny", null);
				try {cfg.save(f);}catch(Exception e) {}
				Owner.sendMessage(main.getPrefix() + m.getMessage("Config.Inventory.Select.message.stadtcreate"));
			}else {
				Owner.sendMessage(main.getPrefix() + "Achtung es gibt einen Fehler bitte einen Developer benachrichtigen");
		}
	}
}
