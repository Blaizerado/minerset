package de.unknown.console;

import org.bukkit.Bukkit;

public class Console {
	public Console(String messege) {
		Bukkit.getConsoleSender().sendMessage(messege);
	}
}
