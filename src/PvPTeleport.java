package net.simpvp.PvPTeleport;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class PvPTeleport extends JavaPlugin {

	public static JavaPlugin instance;

	public void onEnable() {
		instance = this;

		/* Check if this plugin's directory exists, if not create it */
		File dir = new File("plugins/PvPTeleport");
		if ( !dir.exists() ) {
			dir.mkdir();
		}

		getCommand("world").setExecutor(new WorldCommand());
		getCommand("pvplist").setExecutor(new PvPListCommand());

		SQLite.connect();
	}

	public void onDisable() {
		SQLite.close();
	}

}