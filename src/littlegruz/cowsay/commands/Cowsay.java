package littlegruz.cowsay.commands;

import littlegruz.cowsay.CowsayMain;

import org.spout.api.command.Command;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandExecutor;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.CommandPermissions;
import org.spout.api.exception.CommandException;

public class Cowsay implements CommandExecutor{
   private CowsayMain plugin;
   
   public Cowsay(CowsayMain instance){
      plugin = instance;
   }

   // Long form because there is already a command type
   @org.spout.api.command.annotated.Command(aliases = {"cow"}, desc = "Displays an ASCII cow with the users message", usage = "/cowsay [type] <message>")
   @CommandPermissions("mccowsay.cowsay")
   public void processCommand(CommandSource source, Command cmd,
         CommandContext args) throws CommandException{
      if(cmd.getPreferredName().compareToIgnoreCase("cowsay") == 0){
         String output, name;
         
         output = "";
         name = source.getName() + ": ";
         
         // Check the number of arguments used
         if(args.length() > 0){
            output = makeMessage(1, output, args);
            
            // Checks if user specified a cow type
            if(args.getString(0).compareToIgnoreCase("head-in") == 0)
               plugin.printHeadIn(name.replace(": ", ""), output);
            else if(args.getString(0).compareToIgnoreCase("moose") == 0)
               plugin.printMoose(name, output);
            else if(args.getString(0).compareToIgnoreCase("moofasa") == 0)
               plugin.printMoofasa(name, output);
            else if(args.getString(0).compareToIgnoreCase("elephant") == 0)
               plugin.printElephant(name, output);
            else if(args.getString(0).compareToIgnoreCase("udder") == 0)
               plugin.printUdder(name, output);
            else if(args.getString(0).compareToIgnoreCase("tux") == 0)
               plugin.printTux(name, output);
            else if(args.getString(0).compareToIgnoreCase("tiny") == 0)
               plugin.printTiny(name, output);
            else{
               output = "";
               output = makeMessage(0, output, args);
               plugin.printCow(name, output);
            }
         }
         else
            source.sendMessage("Needs more arguments. Try \'/cowsay [cow_type] message\'");
      }
   }
   
   private String makeMessage(int start, String output, CommandContext args){
      int i;
      
      for(i = start; i < args.length(); i++){
         output = output + args.getString(i) + " ";
      }
      
      return output;
   }

}
