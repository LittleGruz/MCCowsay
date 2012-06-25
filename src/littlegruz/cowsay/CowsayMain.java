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
      this.getEngine().getEventManager().registerEvents(new DeathListener(), this);
      
      // Set up command
      this.getEngine().getRootCommand().addSubCommand(this.getEngine(), "cowsay").setHelp("Displays an ASCII cow").setExecutor(new Cowsay(this));
      
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
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("      \\");
      getEngine().broadcastMessage("       \\  ^__^");
      getEngine().broadcastMessage("           (oo)\\_______");
      getEngine().broadcastMessage("           (__)\\           )\\/\\");
      getEngine().broadcastMessage("                  ||------w|");
      getEngine().broadcastMessage("                  ||          ||");
   }
   
   // The head-in cow
   public void printHeadIn(String playerName, String output){
      getEngine().broadcastMessage(" < " + output + ">");
      getEngine().broadcastMessage("     \\                             (" + playerName + ")");
      getEngine().broadcastMessage("      \\                               |");
      getEngine().broadcastMessage("       \\  ^__^             /       V");
      getEngine().broadcastMessage("           (oo)\\_______/   __________");
      getEngine().broadcastMessage("           (__)\\           )=(  ____|___  \\____");
      getEngine().broadcastMessage("                  ||------w|   \\\\          \\____  |");
      getEngine().broadcastMessage("                  ||          ||    | |                  | |");
   }
   
   // The moose cow
   public void printMoose(String playerName, String output){
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("   \\");
      getEngine().broadcastMessage("    \\ \\_\\_      _/_/");
      getEngine().broadcastMessage("     \\      \\__/");
      getEngine().broadcastMessage("             (oo)\\_______");
      getEngine().broadcastMessage("             (__)\\           )\\/\\");
      getEngine().broadcastMessage("                    ||------w|");
      getEngine().broadcastMessage("                    ||          ||");
   }
   
   // The moofasa cow
   public void printMoofasa(String playerName, String output){
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("    \\");
      getEngine().broadcastMessage("     \\    ____");
      getEngine().broadcastMessage("         /      \\");
      getEngine().broadcastMessage("         | ^__^ |");
      getEngine().broadcastMessage("         | (oo)  |_______");
      getEngine().broadcastMessage("         | (__)  |           )\\/\\");
      getEngine().broadcastMessage("         \\____/||------w|");
      getEngine().broadcastMessage("                  ||          ||");
   }
   
   // The elephant cow
   public void printElephant(String playerName, String output){
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("        \\");
      getEngine().broadcastMessage("         \\    /\\  ___   /\\");
      getEngine().broadcastMessage("             // \\/    \\/ \\\\");
      getEngine().broadcastMessage("            ((     O  O     ))");
      getEngine().broadcastMessage("             \\\\ /       \\ //");
      getEngine().broadcastMessage("              \\/    | |    \\/");
      getEngine().broadcastMessage("               |     | |      |");
      getEngine().broadcastMessage("               |     | |      |");
      getEngine().broadcastMessage("               |  |  \\/   |  |");
      getEngine().broadcastMessage("               |  |        |  |");
      getEngine().broadcastMessage("               |m|         |m|");
   }
   
   // The endowed cow
   public void printUdder(String playerName, String output){
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("      \\");
      getEngine().broadcastMessage("       \\   (__)");
      getEngine().broadcastMessage("            o o\\");
      getEngine().broadcastMessage("           (**) \\________");
      getEngine().broadcastMessage("               \\              \\");
      getEngine().broadcastMessage("                |              | \\");
      getEngine().broadcastMessage("                ||----(   )_||  *");
      getEngine().broadcastMessage("                ||       UU   ||");
      getEngine().broadcastMessage("                w            w");
   }
   
   // The tux cow
   public void printTux(String playerName, String output){
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("      \\");
      getEngine().broadcastMessage("       \\   .---.");
      getEngine().broadcastMessage("           |o_o |");
      getEngine().broadcastMessage("           |:_/  |");
      getEngine().broadcastMessage("         //    \\ \\");
      getEngine().broadcastMessage("        ( |       |  )");
      getEngine().broadcastMessage("       /\"\\      /\"\\");
      getEngine().broadcastMessage("       \\__)==(__/");
   }
   
   // The tiny cow
   public void printTiny(String playerName, String output){
      getEngine().broadcastMessage(" < " + playerName + output + ">");
      getEngine().broadcastMessage("    \\");
      getEngine().broadcastMessage("     \\    ,__,");
      getEngine().broadcastMessage("          (oo)____");
      getEngine().broadcastMessage("          (__)      )\\");
      getEngine().broadcastMessage("               ||---||  *");
   }
}
