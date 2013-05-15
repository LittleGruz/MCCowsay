package littlegruz.cowsay.listeners;

import java.util.Random;

import org.spout.api.entity.Entity;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.entity.EntityDeathEvent;
import org.spout.api.entity.Player;
import org.spout.vanilla.component.entity.living.passive.Cow;

public class DeathListener implements Listener{
   
   // If a cow was killed in the same chunk, then send every player a kill message
   @EventHandler
   public void onEntityDeath(EntityDeathEvent event){
      int randInt;
      Random rand;

      rand = new Random();
      
      if(event.getEntity() instanceof Cow){
         // Search for every entity in the chunk
         for(Entity e : event.getEntity().getChunk().getLiveEntities()){
            // Check if the entity is a player
            if(e instanceof Player){
               Player player = (Player) e;
               randInt = rand.nextInt() % 6;
               randInt *= randInt;
               randInt = (int) Math.sqrt(randInt);
               
               // Print out a random message with the ASCII cow
               switch(randInt){
                  case 0: player.sendMessage(" < Who will look after my children? >"); break;
                  case 1: player.sendMessage(" < Urk... >"); break;
                  case 2: player.sendMessage(" < Use the Force. No! Too much... >"); break;
                  case 3: player.sendMessage(" < I used to be a bowl of petunias >"); break;
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
