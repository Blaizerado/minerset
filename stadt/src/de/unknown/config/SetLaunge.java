package de.unknown.config;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class SetLaunge {
	public SetLaunge() {
		File f = new File("plugins/City/Message","Message.yml");
		
		initLaunge(f,"Config.Debug.Message", "&cCity wurde geladen!");
		initLaunge(f,"Config.Debug.Valute", "&cDas Money System wurde erkannt!");
		initLaunge(f,"Config.Debug.ValuteNot", "&cEin Money System wurde nicht gefunden!");
		initLaunge(f,"Config.Inventory.SelectSize", "&3CitySize!");
		initLaunge(f,"Config.Inventory.Select.100x100", "&5100x100");
		initLaunge(f,"Config.Inventory.Select.200x200", "&b200x200");
		initLaunge(f,"Config.Inventory.Select.400x400", "&c400x400");
		initLaunge(f,"Config.Inventory.Select.700x700", "&a700x700");
		initLaunge(f,"Config.Inventory.Select.1000x1000", "&61000x1000");
		initLaunge(f,"Config.Inventory.Select.aktiv", "&aaktiviert");
		initLaunge(f,"Config.Inventory.Select.deaktiv", "&cdeaktivirt");
		initLaunge(f,"Config.Inventory.Select.message.noaktiv", "&cAchtung diese Stadt größe steht nicht zu verfügung!");
		initLaunge(f,"Config.Inventory.Select.message.stadtcreate", "&cDu hast deine Stadt erstellt!");
		initLaunge(f,"Config.Inventory.Message.cityenter", "&3&lDiese Stadt gehört &6&l[PLAYER]");
		initLaunge(f,"Config.Inventory.Message.skull.1","&3<==============>&6Stadt&3<==============>");
		initLaunge(f,"Config.Inventory.Message.skull.2","&6Diese Stadt gehoert");
		initLaunge(f,"Config.Inventory.Message.skull.3","&6dem Spieler &e[PLAYER]");
		initLaunge(f,"Config.Inventory.Message.skull.4"," ");
		initLaunge(f,"Config.Inventory.Message.skull.5","&6Name der Stadt &c[NAME]");
		initLaunge(f,"Config.Inventory.Message.skull.6"," ");
		initLaunge(f,"Config.Inventory.Message.skull.7","&3<===================================>");
		initLaunge(f,"Config.Inventory.Message.noinRegion","&3Du bist in keiner Region");
		initLaunge(f,"Config.Inventory.Message.noPermission","&3Du hast keinen Zugriff auf diesen Command");
		initLaunge(f,"Config.Inventory.Message.flagset","&3Die Flag wurde bereits gesetzt!!");
		initLaunge(f,"Config.Inventory.Message.flagcreate","&3Die Flag wurde gesetzt!");
		initLaunge(f,"Config.Inventory.Message.notowner","&3Diese Stadt gehört dir nicht!");
		initLaunge(f,"Config.Inventory.Message.flagremove","&3Die alte Flag wurde gelöscht!");
		initLaunge(f,"Config.Inventory.Message.flagwasremove","&3Da keine alte Flag gesetzt wurde, wurde die neue gesetzt!");
		initLaunge(f,"Config.Inventory.Message.flagnotfound","&cDie Flag wurde nicht gefunden!!");
		initLaunge(f,"Config.Inventory.Message.userexist","&cDer User ist bereits in dieser Stadt!");
		initLaunge(f,"Config.Inventory.Message.useradd","&3Der Spieler wurde zu dieser Stadt gefühgt!!");
		initLaunge(f,"Config.Inventory.Message.userremove","&3Der Spieler wurde von deiner Stadt entfernt!");
		initLaunge(f,"Config.Inventory.Message.usernotexist","&cDer Spieler ist nicht in deiner Stadt!");
		initLaunge(f,"Config.Inventory.Message.ownerdenyselft","&cDu kannst dich nicht selbst von deiner Stadt bannen!");
		initLaunge(f,"Config.Inventory.Message.denyexist","&cDer Spieler ist bereits von deiner Stadt gebannt!");
		initLaunge(f,"Config.Inventory.Message.denycreate","&cDer Spieler wurde von deiner Stadt gebannt!");
	}
	
	private void initLaunge(File f, String key, Object value) {
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		if(!cfg.isSet(key)) {
			cfg.set(key, value);
		}
		try {cfg.save(f);}catch(Exception e) {}
	}
}
