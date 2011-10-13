package littlegruz.cowsay;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

public class DeathListener extends EntityListener{

   public static MCCowsay plugin;
   
   public DeathListener(MCCowsay instance) {
           plugin = instance;
   }
   
   public void onEntityDeath(EntityDeathEvent event){
      String entityName;
      int randInt;
      Random rand;
      
      if(!plugin.isKillsay())
         return;

      rand = new Random();
      entityName = event.getEntity().toString().substring(5);
      
      // Determine if the cow kill was by a player
      if(entityName.compareToIgnoreCase("cow") == 0){
         if(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent entityDamageEvent = (EntityDamageByEntityEvent) event.getEntity().getLastDamageCause();
            if(entityDamageEvent.getDamager() instanceof Player){
               Player player = (Player) entityDamageEvent.getDamager();
               randInt = rand.nextInt() % 6;
               randInt *= randInt;
               randInt = (int) Math.sqrt(randInt);
               
               // Print out a random message with the ASCII cow
               switch(randInt){
                  case 0: player.sendMessage(" < Who will look after my children? >"); break;
                  case 1: player.sendMessage(" < Urk... >"); break;
                  case 2: player.sendMessage(" < Use the Force. No! Too much... >"); break;
                  case 3: player.sendMessage(" < My final incarnation >"); break;
                  case 4: player.sendMessage(" < I put on my robe and wizard hat >"); break;
                  case 5: player.sendMessage(" < Enjoy my skin, I sure did >"); break;
               }
               player.sendMessage("      \\");
               player.sendMessage("       \\  ^__^");
               player.sendMessage("           (oo)\\_______");
               player.sendMessage("           (__)\\           )\\/\\");
               player.sendMessage("                  ||------w|");
               player.sendMessage("                  ||          ||");
            }
         }
      }
      
   }
}
