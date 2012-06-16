package littlegruz.cowsay;

import java.io.File;

import littlegruz.cowsay.commands.Cowsay;
import littlegruz.cowsay.listeners.DeathListener;

import org.spout.api.plugin.CommonPlugin;

public class CowsayMain extends CommonPlugin{
   
   public void onEnable(){
      // Create the directory and files if needed
      new File(this.getDataFolder().toString()).mkdir();
      
      // Set up listener
      this.getGame().getEventManager().registerEvents(new DeathListener(), this);
      
      // Set up command
      this.getGame().getRootCommand().addSubCommand(this.getGame(), "cowsay").setHelp("Displays an ASCII cow").setExecutor(new Cowsay(this));
      
      // This will print "MCCowsay v1.0 enabled"
      getLogger().info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " enabled");
   }

   public void onDisable(){
      getLogger().info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " disabled");
   }

   /*
    * Since all the characters don't take up the same amount of space in
    * Minecraft, the cows here may look weird.
    */
   
   // The default cow
   public void printCow(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("      \\");
      getGame().broadcastMessage("       \\  ^__^");
      getGame().broadcastMessage("           (oo)\\_______");
      getGame().broadcastMessage("           (__)\\           )\\/\\");
      getGame().broadcastMessage("                  ||------w|");
      getGame().broadcastMessage("                  ||          ||");
   }
   
   // The head-in cow
   public void printHeadIn(String playerName, String output){
      getGame().broadcastMessage(" < " + output + ">");
      getGame().broadcastMessage("     \\                             (" + playerName + ")");
      getGame().broadcastMessage("      \\                               |");
      getGame().broadcastMessage("       \\  ^__^             /       V");
      getGame().broadcastMessage("           (oo)\\_______/   __________");
      getGame().broadcastMessage("           (__)\\           )=(  ____|___  \\____");
      getGame().broadcastMessage("                  ||------w|   \\\\          \\____  |");
      getGame().broadcastMessage("                  ||          ||    | |                  | |");
   }
   
   // The moose cow
   public void printMoose(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("   \\");
      getGame().broadcastMessage("    \\ \\_\\_      _/_/");
      getGame().broadcastMessage("     \\      \\__/");
      getGame().broadcastMessage("             (oo)\\_______");
      getGame().broadcastMessage("             (__)\\           )\\/\\");
      getGame().broadcastMessage("                    ||------w|");
      getGame().broadcastMessage("                    ||          ||");
   }
   
   // The moofasa cow
   public void printMoofasa(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("    \\");
      getGame().broadcastMessage("     \\    ____");
      getGame().broadcastMessage("         /      \\");
      getGame().broadcastMessage("         | ^__^ |");
      getGame().broadcastMessage("         | (oo)  |_______");
      getGame().broadcastMessage("         | (__)  |           )\\/\\");
      getGame().broadcastMessage("         \\____/||------w|");
      getGame().broadcastMessage("                  ||          ||");
   }
   
   // The elephant cow
   public void printElephant(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("        \\");
      getGame().broadcastMessage("         \\    /\\  ___   /\\");
      getGame().broadcastMessage("             // \\/    \\/ \\\\");
      getGame().broadcastMessage("            ((     O  O     ))");
      getGame().broadcastMessage("             \\\\ /       \\ //");
      getGame().broadcastMessage("              \\/    | |    \\/");
      getGame().broadcastMessage("               |     | |      |");
      getGame().broadcastMessage("               |     | |      |");
      getGame().broadcastMessage("               |  |  \\/   |  |");
      getGame().broadcastMessage("               |  |        |  |");
      getGame().broadcastMessage("               |m|         |m|");
   }
   
   // The endowed cow
   public void printUdder(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("      \\");
      getGame().broadcastMessage("       \\   (__)");
      getGame().broadcastMessage("            o o\\");
      getGame().broadcastMessage("           (**) \\________");
      getGame().broadcastMessage("               \\              \\");
      getGame().broadcastMessage("                |              | \\");
      getGame().broadcastMessage("                ||----(   )_||  *");
      getGame().broadcastMessage("                ||       UU   ||");
      getGame().broadcastMessage("                w            w");
   }
   
   // The tux cow
   public void printTux(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("      \\");
      getGame().broadcastMessage("       \\   .---.");
      getGame().broadcastMessage("           |o_o |");
      getGame().broadcastMessage("           |:_/  |");
      getGame().broadcastMessage("         //    \\ \\");
      getGame().broadcastMessage("        ( |       |  )");
      getGame().broadcastMessage("       /\"\\      /\"\\");
      getGame().broadcastMessage("       \\__)==(__/");
   }
   
   // The tiny cow
   public void printTiny(String playerName, String output){
      getGame().broadcastMessage(" < " + playerName + output + ">");
      getGame().broadcastMessage("    \\");
      getGame().broadcastMessage("     \\    ,__,");
      getGame().broadcastMessage("          (oo)____");
      getGame().broadcastMessage("          (__)      )\\");
      getGame().broadcastMessage("               ||---||  *");
   }
}
