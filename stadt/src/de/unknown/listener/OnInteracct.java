package de.unknown.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.unknown.config.MessageBuilder;
import de.unknown.statd.Stadt;

public class OnInteracct implements Listener {
	
	private Stadt main;

	public OnInteracct(Stadt stadt) {
		this.main = stadt;
	}

	@EventHandler
	public void onInterAcct(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		try {
			if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if(p.getItemInHand().getType().equals(Material.GOLD_BLOCK)) {
					e.setCancelled(true);
					MessageBuilder m = new MessageBuilder("plugins/City/Message", "Message.yml");
					Inventory inv = Bukkit.createInventory(null, 9,m.getMessage("Config.Inventory.SelectSize"));
					
					ArrayList<String>aktiv = new ArrayList<>();
					ArrayList<String>deaktiv = new ArrayList<>();
					
					aktiv.add(m.getMessage("Config.Inventory.Select.aktiv"));
					deaktiv.add(m.getMessage("Config.Inventory.Select.deaktiv"));
					
					ItemStack i = new ItemStack(Material.IRON_BLOCK);
					ItemMeta im = i.getItemMeta();
					im.setDisplayName(m.getMessage("Config.Inventory.Select.100x100"));
					if(main.getConfig().getBoolean("Config.100x100")){im.setLore(aktiv);}else {im.setLore(deaktiv);}
					i.setItemMeta(im);
					inv.addItem(i);
					
					
					
					i = new ItemStack(Material.IRON_BLOCK);
					im = i.getItemMeta();
					im.setDisplayName(m.getMessage("Config.Inventory.Select.200x200"));
					if(main.getConfig().getBoolean("Config.200x200")){im.setLore(aktiv);}else {im.setLore(deaktiv);}
					i.setItemMeta(im);
					inv.addItem(i);
					
					i = new ItemStack(Material.LAPIS_BLOCK);
					im = i.getItemMeta();
					im.setDisplayName(m.getMessage("Config.Inventory.Select.400x400"));
					if(main.getConfig().getBoolean("Config.400x400")){im.setLore(aktiv);}else {im.setLore(deaktiv);}
					i.setItemMeta(im);
					inv.addItem(i);
					
					i = new ItemStack(Material.DIAMOND_BLOCK);
					im = i.getItemMeta();
					im.setDisplayName(m.getMessage("Config.Inventory.Select.700x700"));
					if(main.getConfig().getBoolean("Config.700x700")){im.setLore(aktiv);}else {im.setLore(deaktiv);}
					i.setItemMeta(im);
					inv.addItem(i);
					
					i = new ItemStack(Material.EMERALD_BLOCK);
					im = i.getItemMeta();
					im.setDisplayName(m.getMessage("Config.Inventory.Select.1000x1000"));
					if(main.getConfig().getBoolean("Config.1000x1000")){im.setLore(aktiv);}else {im.setLore(deaktiv);}
					i.setItemMeta(im);
					inv.addItem(i);
					
					p.openInventory(inv);
				}
			}
		}catch(Exception e2) {}
	}
	
}
