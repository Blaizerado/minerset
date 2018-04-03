package de.unknown.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import de.unknown.commands.modul.Deny;
import de.unknown.commands.modul.Info;
import de.unknown.commands.modul.User;
import de.unknown.config.MessageBuilder;
import de.unknown.region.GetRegion;
import de.unknown.statd.Stadt;
import de.unknown.uuid.uuidfetcher;


public class Command_City extends AbstractCommand{

	public Command_City(String commandName, Plugin pl) {
		super(commandName, pl);
	}

	@Override
	public boolean command(CommandSender sender, String[] args) {
		Player p = (Player) sender;
		MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(args.length == 0) {
			p.sendMessage("§6<============>§a1-4§6<============>");
			p.sendMessage("§3/City Info §6:§c Zeigt Infos über die Region auf der du grade stehst!");
			p.sendMessage("§3/City Flags §6:§c Zeigt dir Flags zum Setzten!");
			p.sendMessage("§3/City User add [Player] §6:§c Fügt einen Spieler auf deiner Stadt hinzu!(Bewohner)");
			p.sendMessage("§3/City User remove [Player] §6:§c Löscht ein Spieler von deiner Stadt!");
			p.sendMessage("§3/City deny [Player] §6:§c Löscht ein Spieler von deiner Stadt!");
			p.sendMessage("§3/City 2 --->");
			p.sendMessage("§6<=============================>");
		}else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("info")) {
				new Info(args,p);
			}else if(args[0].equalsIgnoreCase("2")) {
				
			}else if(args[0].equalsIgnoreCase("3")) {
				
			}else if(args[0].equalsIgnoreCase("4")) {
				
			}else if(args[0].equalsIgnoreCase("flag")) {
				p.sendMessage("§6<============>§aHPL§6<============>");
				p.sendMessage("§3/city flag set [Flag]");
				p.sendMessage("§3Flags: enter:1|2|off, pvp:true|false");
				p.sendMessage("§3Flags: time:day|nigth|off, weather:lock|unlock");
				p.sendMessage("§3Flags: damage:true|false");
				p.sendMessage("§6<=============================>");
			}else if(args[0].equalsIgnoreCase("user")) {
				p.sendMessage("§6<============>§aHPL§6<============>");
				p.sendMessage("§3/City User add|remove [Player]");
				p.sendMessage("§6<=============================>");
			}else if(args[0].equalsIgnoreCase("deny")) {
				p.sendMessage("§6<============>§aHPL§6<============>");
				p.sendMessage("§3/City deny [Player");
				p.sendMessage("§6<=============================>");
			}
		}else if(args.length == 2) {
			if(args[0].equalsIgnoreCase("Flag")) {
				p.sendMessage("§6<============>§aHPL§6<============>");
				p.sendMessage("§3/city flag set [Flag]");
				p.sendMessage("§6<=============================>");
			}else if(args[0].equalsIgnoreCase("user")) {
				p.sendMessage("§6<============>§aHPL§6<============>");
				p.sendMessage("§3/City User add|remove [Player]");
				p.sendMessage("§6<=============================>");
			}else if(args[0].equalsIgnoreCase("deny")) {
				new Deny(args,p);
			}
		}else if(args.length == 3) {
			if(args[0].equalsIgnoreCase("flag")) {
				if(args[1].equalsIgnoreCase("set")) {
					if(args[2].equalsIgnoreCase("enter:1")) {
						setFlag(p, "ENTER:1");
						removeFlag(p, "ENTER:2");
						System.out.println("test");
					}else if(args[2].equalsIgnoreCase("enter:2")) {
						setFlag(p, "ENTER:2");
						removeFlag(p, "ENTER:1");
					}else if(args[2].equalsIgnoreCase("enter:off")) {
						setFlag(p, "ENTER:off");
						removeFlag(p, "ENTER:2");
						removeFlag(p, "ENTER:1");
						System.out.println("Test");
					}else if(args[2].equalsIgnoreCase("pvp:true")) {
						setFlag(p, "PVP:true");
						removeFlag(p, "PVP:false");
					}else if(args[2].equalsIgnoreCase("pvp:false")) {
						setFlag(p, "PVP:false");
						removeFlag(p, "PVP:true");
					}else if(args[2].equalsIgnoreCase("damage:true")) {
						setFlag(p, "DAMAGE:true");
						removeFlag(p, "DAMAGE:false");
					}else if(args[2].equalsIgnoreCase("damage:false")) {
						setFlag(p, "DAMAGE:flase");
						removeFlag(p, "DAMAGE:true");
					}else if(args[2].equalsIgnoreCase("time:day")) {
						setFlag(p, "TIME:day");
						removeFlag(p, "TIME:nigth");
					}else if(args[2].equalsIgnoreCase("time:nigth")) {
						setFlag(p, "TIME:nigth");
						removeFlag(p, "TIME:day");
					}else if(args[2].equalsIgnoreCase("time:off")) {
						removeFlag(p, "TIME:day");
						removeFlag(p, "TIME:nigth");
					}else if(args[2].equalsIgnoreCase("weather:lock")) {
						setFlag(p, "WEATHER:lock");
						removeFlag(p, "WEATHER:unlock");
					}else if(args[2].equalsIgnoreCase("weather:unlock")) {
						setFlag(p, "WEATHER:unlock");
						removeFlag(p, "WEATHER:lock");
					}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.flagnotfound"));}
				}
			}else if(args[0].equalsIgnoreCase("user")) {
				new User(args,p);
			}
		}else if(args.length == 4) {
			System.out.println("test 4");
		}
		return true;
	}
	public void setFlag(Player p, String flag) {
		MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(GetRegion.isInRegion(p.getLocation())) {
			if(GetRegion.getOwner(p.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString()) 
					|| p.hasPermission("city.flags.*")) {
				
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(GetRegion.getRegionFile(p.getLocation()));
				List<String>f = cfg.getStringList("Config.Flags");
				System.out.println(f);
				if(!f.contains(flag)) {
					f.add(flag);
					cfg.set("Config.Flags", f);
					try {cfg.save(GetRegion.getRegionFile(p.getLocation()));}catch (Exception e) {}
					p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.flagcreate"));
				}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.flagset"));}
			}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.notowner"));}
		}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noinRegion"));}
	}
	
	public void removeFlag(Player p,String flag) {
		MessageBuilder b = new MessageBuilder("plugins/City/Message", "Message.yml");
		if(GetRegion.isInRegion(p.getLocation())) {
			if(GetRegion.getOwner(p.getLocation()).equalsIgnoreCase(uuidfetcher.getUUID(p.getName()).toString()) 
					|| p.hasPermission("city.flags.*")) {
				
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(GetRegion.getRegionFile(p.getLocation()));
				List<String>f = cfg.getStringList("Config.Flags");
				if(f.contains(flag)) {
					f.remove(flag);
					cfg.set("Config.Flags", f);
					try {cfg.save(GetRegion.getRegionFile(p.getLocation()));}catch (Exception e) {}
					p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.flagremove"));
				}else {}
			}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.notowner"));}
		}else {p.sendMessage(Stadt.getPrefix() + b.getMessage("Config.Inventory.Message.noinRegion"));}
	}
}
