package de.unknown.statd;

import org.bukkit.plugin.java.JavaPlugin;

import de.unknown.config.MessageBuilder;
import de.unknown.console.Console;
import de.unknown.modul.LoadModul;
import net.md_5.bungee.api.ChatColor;

public class Stadt extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new LoadModul(this);
		MessageBuilder m = new MessageBuilder("plugins/city/Message", "Message.yml");
		new Console(m.getMessage("Config.Debug.Message"));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static String getPrefix() {
		return ChatColor.translateAlternateColorCodes('&', getPlugin(Stadt.class).getConfig().getString("Config.Prefix"));
	}
	
	public static Stadt getInstance() {
		return getPlugin(Stadt.class);
	}
}
