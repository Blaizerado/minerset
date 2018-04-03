package de.unknown.modul;


import de.unknown.commands.Command_City;
import de.unknown.config.Area;
import de.unknown.config.SetConfig;
import de.unknown.config.SetLaunge;
import de.unknown.listener.OnBlockBreak;
import de.unknown.listener.OnInteracct;
import de.unknown.listener.OnInventoryClick;
import de.unknown.listener.OnPlayerEnterRegion;
import de.unknown.listener.OnPlayerDamage;
import de.unknown.listener.OnPvP;
import de.unknown.statd.Stadt;

public class LoadModul {

	public LoadModul(Stadt stadt) {
		loadArea(stadt);
		loadLaunge(stadt);
		loadlistener(stadt);
		loadCommands(stadt);
	}

	private void loadCommands(Stadt stadt) {
		new Command_City("City",stadt);
	}

	private void loadArea(Stadt stadt) {
		new Area();
	}

	private void loadlistener(Stadt stadt) {
		stadt.getServer().getPluginManager().registerEvents(new OnInteracct(stadt), stadt);
		stadt.getServer().getPluginManager().registerEvents(new OnInventoryClick(stadt), stadt);
		stadt.getServer().getPluginManager().registerEvents(new OnBlockBreak(), stadt);
		stadt.getServer().getPluginManager().registerEvents(new OnPlayerEnterRegion(), stadt);
		stadt.getServer().getPluginManager().registerEvents(new OnPvP(), stadt);
		stadt.getServer().getPluginManager().registerEvents(new OnPlayerDamage(), stadt);
	}

	private void loadLaunge(Stadt stadt) {
		new SetLaunge();
		new SetConfig(stadt);
	}
}
