package littlegruz.cowsay;

import java.io.File;

import littlegruz.cowsay.commands.Cowsay;
import littlegruz.cowsay.listeners.DeathListener;

import org.spout.api.chat.ChatArguments;
import org.spout.api.command.CommandSource;
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
      getLogger().info("Enabled " + this.getDescription().getName() + " v" + this.getDescription().getVersion());
   }

   public void onDisable(){
      getLogger().info("Disabled " + this.getDescription().getName() + " v" + this.getDescription().getVersion());
   }

   /*
    * Since all the characters don't take up the same amount of space in
    * Minecraft, the cows here may look weird.
    */
   
   // The default cow
   public void printCow(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("      \\"));
      source.processCommand("say", new ChatArguments("       \\  ^__^"));
      source.processCommand("say", new ChatArguments("           (oo)\\_______"));
      source.processCommand("say", new ChatArguments("           (__)\\           )\\/\\"));
      source.processCommand("say", new ChatArguments("                  ||------w|"));
      source.processCommand("say", new ChatArguments("                  ||          ||"));
   }
   
   // The head-in cow
   public void printHeadIn(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + output + ">"));
      source.processCommand("say", new ChatArguments("     \\                             (" + playerName + ")"));
      source.processCommand("say", new ChatArguments("      \\                               |"));
      source.processCommand("say", new ChatArguments("       \\  ^__^             /       V"));
      source.processCommand("say", new ChatArguments("           (oo)\\_______/   __________"));
      source.processCommand("say", new ChatArguments("           (__)\\           )=(  ____|___  \\____"));
      source.processCommand("say", new ChatArguments("                  ||------w|   \\\\          \\____  |"));
      source.processCommand("say", new ChatArguments("                  ||          ||    | |                  | |"));
   }
   
   // The moose cow
   public void printMoose(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("   \\"));
      source.processCommand("say", new ChatArguments("    \\ \\_\\_      _/_/"));
      source.processCommand("say", new ChatArguments("     \\      \\__/"));
      source.processCommand("say", new ChatArguments("             (oo)\\_______"));
      source.processCommand("say", new ChatArguments("             (__)\\           )\\/\\"));
      source.processCommand("say", new ChatArguments("                    ||------w|"));
      source.processCommand("say", new ChatArguments("                    ||          ||"));
   }
   
   // The moofasa cow
   public void printMoofasa(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("    \\"));
      source.processCommand("say", new ChatArguments("     \\    ____"));
      source.processCommand("say", new ChatArguments("         /      \\"));
      source.processCommand("say", new ChatArguments("         | ^__^ |"));
      source.processCommand("say", new ChatArguments("         | (oo)  |_______"));
      source.processCommand("say", new ChatArguments("         | (__)  |           )\\/\\"));
      source.processCommand("say", new ChatArguments("         \\____/||------w|"));
      source.processCommand("say", new ChatArguments("                  ||          ||"));
   }
   
   // The elephant cow
   public void printElephant(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("        \\"));
      source.processCommand("say", new ChatArguments("         \\    /\\  ___   /\\"));
      source.processCommand("say", new ChatArguments("             // \\/    \\/ \\\\"));
      source.processCommand("say", new ChatArguments("            ((     O  O     ))"));
      source.processCommand("say", new ChatArguments("             \\\\ /       \\ //"));
      source.processCommand("say", new ChatArguments("              \\/    | |    \\/"));
      source.processCommand("say", new ChatArguments("               |     | |      |"));
      source.processCommand("say", new ChatArguments("               |     | |      |"));
      source.processCommand("say", new ChatArguments("               |  |  \\/   |  |"));
      source.processCommand("say", new ChatArguments("               |  |        |  |"));
      source.processCommand("say", new ChatArguments("               |m|         |m|"));
   }
   
   // The endowed cow
   public void printUdder(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("      \\"));
      source.processCommand("say", new ChatArguments("       \\   (__)"));
      source.processCommand("say", new ChatArguments("            o o\\"));
      source.processCommand("say", new ChatArguments("           (**) \\________"));
      source.processCommand("say", new ChatArguments("               \\              \\"));
      source.processCommand("say", new ChatArguments("                |              | \\"));
      source.processCommand("say", new ChatArguments("                ||----(   )_||  *"));
      source.processCommand("say", new ChatArguments("                ||       UU   ||"));
      source.processCommand("say", new ChatArguments("                w            w"));
   }
   
   // The tux cow
   public void printTux(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("      \\"));
      source.processCommand("say", new ChatArguments("       \\   .---."));
      source.processCommand("say", new ChatArguments("           |o_o |"));
      source.processCommand("say", new ChatArguments("           |:_/  |"));
      source.processCommand("say", new ChatArguments("         //    \\ \\"));
      source.processCommand("say", new ChatArguments("        ( |       |  )"));
      source.processCommand("say", new ChatArguments("       /\"\\      /\"\\"));
      source.processCommand("say", new ChatArguments("       \\__)==(__/"));
   }
   
   // The tiny cow
   public void printTiny(CommandSource source, String playerName, String output){
      source.processCommand("say", new ChatArguments(" < " + playerName + output + ">"));
      source.processCommand("say", new ChatArguments("    \\"));
      source.processCommand("say", new ChatArguments("     \\    ,__,"));
      source.processCommand("say", new ChatArguments("          (oo)____"));
      source.processCommand("say", new ChatArguments("          (__)      )\\"));
      source.processCommand("say", new ChatArguments("               ||---||  *"));
   }
}
