package org.itxtech.nemisys.command.defaults;

import org.itxtech.nemisys.Server;
import org.itxtech.nemisys.command.CommandSender;
import org.itxtech.nemisys.command.ConsoleCommandSender;
import org.itxtech.nemisys.event.TranslationContainer;
import org.itxtech.nemisys.synapse.SynapsePlayer;
import org.itxtech.nemisys.utils.TextFormat;

/**
 * Created on 2019/04/23 by NycuRO.
 * Package org.itxtech.nemisys.command.defaults in project Nemisys .
 */
public class HubCommand extends VanillaCommand {

    public HubCommand(String name) {
        super(name, "%nemisys.command.hub.description", "%commands.hub.usage");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            String message = TextFormat.RED + "This command can be used only by a player"; // sorry for hardcoded :(
            sender.sendMessage(message);
            return true;
        }
        if (args.length == 0) {
            if (sender instanceof SynapsePlayer) {
                SynapsePlayer synapsePlayer = (SynapsePlayer) sender;
                synapsePlayer.transfer(Server.getInstance().getFallbackClient().getDescription());
                return true;
            }
        } else {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
            return false;
        }
    }
}
