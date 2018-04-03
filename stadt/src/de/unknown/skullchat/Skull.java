package de.unknown.skullchat;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Skull {
	Player p;
	String[] text;
	String name;
	public Skull(Player kopf, String[] line) {
		this.p = kopf;
		this.text = line;
	}
	
	public Skull(String n, String[] line) {
		this.name = n;
		this.text = line;
	}
	
	public void sendAll() {
		for(Player e : Bukkit.getOnlinePlayers()) {
			sendPlayer(e);
		}
	}
	
	public void sendPlayer(Player c) {
		char character = getChar();
		
		String headname = this.p.getName();
		BufferedImage image = null;
		try {
			image = ImageIO.read(newURL(headname));
		}catch(Exception e) {e.printStackTrace();}
		new Chat(image, 8, character).appendText(this.text).sendToPlayer(c);
	}
	
	public void sendByName(Player c) {
		char character = getChar();
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(newURL(name));
		}catch(Exception e) {e.printStackTrace();}
		new Chat(image, 8, character).appendText(this.text).sendToPlayer(c);
	}
	
	public static URL newURL(String name) throws Exception {
		String url = "https://minotar.net/avatar/%pname%/8.png";
		url = url.replace("%pname%", name);
		return new URL(url);
	}
	
	public static char getChar() {
		return Char.BLOCK.getChar();
	}
}
