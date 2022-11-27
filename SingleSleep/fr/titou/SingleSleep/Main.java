package fr.titou.SingleSleep;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	
	@Override
	public void onEnable() {
		System.out.println("[SingleSleep] Enabling...");
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
	
	}
	
	@Override
	public void onDisable() {
		System.out.println("[SingleSleep] Disabling...");
	}
	
	
	
	@EventHandler
	public void onSleep(PlayerBedEnterEvent event) {
		
		
		Player player = event.getPlayer();
		World world = player.getWorld();
		Boolean msg = getConfig().getBoolean("msg");
		
		if(player instanceof Player) {
			if(world.getTime() >= 12500) {
				world.setTime(1000);
				if(msg == true) {
					player.sendMessage("§e[SingleSleep] Good morning !");
				}
			}
		}	
	}
}
