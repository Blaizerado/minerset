package de.unknown.config;

import de.unknown.statd.Stadt;

public class SetConfig {

	private Stadt main;

	public SetConfig(Stadt stadt) {
		this.main = stadt;
		initConfig("Config.Prefix", "&6[Unknown]&8:&3");
		initConfig("Config.100x100",true);
		initConfig("Config.200x200",true);
		initConfig("Config.400x400",true);
		initConfig("Config.700x700",true);
		initConfig("Config.1000x1000",true);
		initConfig("Config.Valute",true);
		initConfig("Config.Actionbar",true);
	}
	
	private void initConfig(String Key, Object value) {
		if(!this.main.getConfig().isSet(Key)) {
			this.main.getConfig().set(Key, value);
		}
		this.main.saveConfig();
	}
	
}
