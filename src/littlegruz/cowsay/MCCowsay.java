package littlegruz.cowsay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

import littlegruz.cowsay.listeners.CowPlayerListener;
import littlegruz.cowsay.listeners.DeathListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MCCowsay extends JavaPlugin implements CommandExecutor{
   Logger log = Logger.getLogger("THIS...IS...COWSAY! *push*");
   File file = new File("cows.txt");
   private final DeathListener deathListener = new DeathListener(this);
   private final CowPlayerListener playerListener = new CowPlayerListener(this);
   private HashMap<String, String> cowMap;
   private int cooldownTime;
   private boolean killsay;

   public void onEnable(){
      PluginManager pm = this.getServer().getPluginManager();
      pm.registerEvent(Event.Type.ENTITY_DEATH, deathListener, Event.Priority.Normal, this);
      pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, playerListener, Event.Priority.Normal, this);
      pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
      pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
      cowMap = new HashMap<String, String>();
      killsay = true;
      cooldownTime = 300;
      log.info("MCCowsay v1.6 enabled");
   }

   public void onDisable(){
      log.info("MCCowsay v1.6 disabled");
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
      Player player;
      if(cmd.getName().equalsIgnoreCase("cowsay")){
         if(sender.hasPermission("mccowsay.cowsay")){
            int i, found;
            Random rand;
            String output, fileLine;
            
            output = "";
            found = 0;
   
            if(sender instanceof Player){
               String playerName, playerNamePlain;
               int cowPos, iStart, randInt;
               
               rand = new Random();
               cowPos = 0;
               iStart = 1;
               
               player = (Player) sender;
               playerName = player.getName() + ": ";
               playerNamePlain = player.getName();
   
               if(args.length == 0){
                  player.sendMessage("Incorrect formatting. Correct format \"/cowsay [h] [cow_type] <message>\"");
                  return true;
               }
               /*
                * Replaces displayed head-in name if players name is chosen to be
                * hidden
                */
               if(args[0].compareToIgnoreCase("h") == 0){
                  playerName = "";
                  randInt = rand.nextInt() % 8;
                  randInt *= randInt;
                  randInt = (int) Math.sqrt(randInt);
                  switch(randInt){
                     case 0: playerNamePlain = "Steve from accounting"; break;
                     case 1: playerNamePlain = "Anonymous"; break;
                     case 2: playerNamePlain = "Future veterinarian"; break;
                     case 3: playerNamePlain = "Some idiot"; break;
                     case 4: playerNamePlain = "Not a platypus"; break;
                     case 5: playerNamePlain = "Bad ostrich impersonation"; break;
                     case 6: playerNamePlain = "Very clumsy"; break;
                     case 7: playerNamePlain = "Gag Halfrunt"; break;
                  }
                  cowPos = 1;
                  iStart = 2;
               }
               
               for(i = iStart; i < args.length; i++){
                  output = output + args[i] + " ";
               }
               
               /* Displays the matching cow from the external file */
               if(file.exists()){
                  try{
                     BufferedReader br = new BufferedReader(new InputStreamReader(
                           new FileInputStream(file)));
                     while((fileLine = br.readLine()) != null){
                        if(args.length <= cowPos){
                           player.sendMessage("Incorrect formatting. Correct format \"/cowsay [h] [cow_type] <message>\"");
                           return true;
                        }
                        if(args[cowPos].compareToIgnoreCase(fileLine) == 0){
                           found = 1;
                           getServer().broadcastMessage(" < " + playerName + output + ">");
                           while((fileLine = br.readLine()).compareToIgnoreCase("end") != 0){
                              getServer().broadcastMessage(fileLine);
                           }
                        }
                     }
                     br.close();
                  }catch(IOException e){
                  }
                  if(found == 1)
                  {
                     return true;
                  }
               }
               
               if(args[cowPos].compareToIgnoreCase("head-in") == 0)
                  printHeadIn(playerNamePlain, output);
               else if(args[cowPos].compareToIgnoreCase("moose") == 0)
                  printMoose(playerName, output);
               else if(args[cowPos].compareToIgnoreCase("moofasa") == 0)
                  printMoofasa(playerName, output);
               else if(args[cowPos].compareToIgnoreCase("elephant") == 0)
                  printElephant(playerName, output);
               else if(args[cowPos].compareToIgnoreCase("udder") == 0)
                  printUdder(playerName, output);
               else if(args[cowPos].compareToIgnoreCase("tux") == 0)
                  printTux(playerName, output);
               else if(args[cowPos].compareToIgnoreCase("tiny") == 0)
                  printTiny(playerName, output);
               else{
                  /* Since the message starts at the second argument, reload the
                   * output String assuming there is no cow name given */
                  output = "";
                  for(i = (iStart - 1); i < args.length; i++){
                     output = output + args[i] + " ";
                  }
   
                  printCow(playerName, output);
               }
   
            }
            else
               sender.sendMessage("Please do not use the console to use /cowsay");
         }
      }
      else if(cmd.getName().equalsIgnoreCase("cowkillsay")){
         if(sender.hasPermission("mccowsay.cowkillsay")){
            if(killsay){
               killsay = false;
               getServer().broadcastMessage("Cowkillsay is now disabled");
            }else{
               killsay = true;
               getServer().broadcastMessage("Cowkillsay is now enabled");
            }
         }else
            sender.sendMessage("No! Bad " + sender.getName() + "! You can't do that!");
      }
      else if(cmd.getName().equalsIgnoreCase("cowsaycooldown")){
         if(sender.hasPermission("mccowsay.cooldown")){
            if(args.length == 1){
               try{
               cooldownTime = Integer.parseInt(args[0]) * 20;
               sender.sendMessage("Cooldown time set to " + cooldownTime / 20 + " seconds");
               }catch(Exception e){
                  sender.sendMessage("Please use an integer as time input");
               }
            }
            else
               sender.sendMessage("The correct format is /cooldowntime <time_in_sec>");
         }
      }
      
      return true;
   }

   /*
    * Since all the characters don't take up the same amount of space in
    * Minecraft, the cows here may look weird.
    */
   
   // The default cow
   public void printCow(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("      \\");
      getServer().broadcastMessage("       \\  ^__^");
      getServer().broadcastMessage("           (oo)\\_______");
      getServer().broadcastMessage("           (__)\\           )\\/\\");
      getServer().broadcastMessage("                  ||------w|");
      getServer().broadcastMessage("                  ||          ||");
   }
   
   // The head-in cow
   public void printHeadIn(String playerName, String output){
      getServer().broadcastMessage(" < " + output + ">");
      getServer().broadcastMessage("     \\                             (" + playerName + ")");
      getServer().broadcastMessage("      \\                               |");
      getServer().broadcastMessage("       \\  ^__^             /       V");
      getServer().broadcastMessage("           (oo)\\_______/   __________");
      getServer().broadcastMessage("           (__)\\           )=(  ____|___  \\____");
      getServer().broadcastMessage("                  ||------w|   \\\\          \\____  |");
      getServer().broadcastMessage("                  ||          ||    | |                  | |");
   }
   
   // The moose cow
   public void printMoose(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("   \\");
      getServer().broadcastMessage("    \\ \\_\\_      _/_/");
      getServer().broadcastMessage("     \\      \\__/");
      getServer().broadcastMessage("             (oo)\\_______");
      getServer().broadcastMessage("             (__)\\           )\\/\\");
      getServer().broadcastMessage("                    ||------w|");
      getServer().broadcastMessage("                    ||          ||");
   }
   
   // The moofasa cow
   public void printMoofasa(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("    \\");
      getServer().broadcastMessage("     \\    ____");
      getServer().broadcastMessage("         /      \\");
      getServer().broadcastMessage("         | ^__^ |");
      getServer().broadcastMessage("         | (oo)  |_______");
      getServer().broadcastMessage("         | (__)  |           )\\/\\");
      getServer().broadcastMessage("         \\____/||------w|");
      getServer().broadcastMessage("                  ||          ||");
   }
   
   // The elephant cow
   public void printElephant(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("        \\");
      getServer().broadcastMessage("         \\    /\\  ___   /\\");
      getServer().broadcastMessage("             // \\/    \\/ \\\\");
      getServer().broadcastMessage("            ((     O  O     ))");
      getServer().broadcastMessage("             \\\\ /       \\ //");
      getServer().broadcastMessage("              \\/    | |    \\/");
      getServer().broadcastMessage("               |     | |      |");
      getServer().broadcastMessage("               |     | |      |");
      getServer().broadcastMessage("               |  |  \\/   |  |");
      getServer().broadcastMessage("               |  |        |  |");
      getServer().broadcastMessage("               |m|         |m|");
   }
   
   // The endowed cow
   public void printUdder(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("      \\");
      getServer().broadcastMessage("       \\   (__)");
      getServer().broadcastMessage("            o o\\");
      getServer().broadcastMessage("           (**) \\________");
      getServer().broadcastMessage("               \\              \\");
      getServer().broadcastMessage("                |              | \\");
      getServer().broadcastMessage("                ||----(   )_||  *");
      getServer().broadcastMessage("                ||       UU   ||");
      getServer().broadcastMessage("                w            w");
   }
   
   // The tux cow
   public void printTux(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("      \\");
      getServer().broadcastMessage("       \\   .---.");
      getServer().broadcastMessage("           |o_o |");
      getServer().broadcastMessage("           |:_/  |");
      getServer().broadcastMessage("         //    \\ \\");
      getServer().broadcastMessage("        ( |       |  )");
      getServer().broadcastMessage("       /\"\\      /\"\\");
      getServer().broadcastMessage("       \\__)==(__/");
   }
   
   // The tiny cow
   public void printTiny(String playerName, String output){
      getServer().broadcastMessage(" < " + playerName + output + ">");
      getServer().broadcastMessage("    \\");
      getServer().broadcastMessage("     \\    ,__,");
      getServer().broadcastMessage("          (oo)____");
      getServer().broadcastMessage("          (__)      )\\");
      getServer().broadcastMessage("               ||---||  *");
   }

   public boolean isKillsay(){
      return killsay;
   }

   public void setKillsay(boolean killsay){
      this.killsay = killsay;
   }

   public HashMap<String, String> getCowMap() {
      return cowMap;
   }

   public int getCooldownTime() {
      return cooldownTime;
   }

   public void setCooldownTime(int cooldownTime) {
      this.cooldownTime = cooldownTime;
   }
}
