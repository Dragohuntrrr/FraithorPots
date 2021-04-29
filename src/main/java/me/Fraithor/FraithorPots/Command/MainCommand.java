package me.Fraithor.FraithorPots.Command;

import me.Fraithor.FraithorPots.FraithorPots;
import me.Fraithor.FraithorPots.Utilities.File.CustomPotionInfo;
import me.Fraithor.FraithorPots.Utilities.File.CustomPotions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sendi, Command command, String label, String[] args) {
        if (args.length >= 2) {
            try {
                SUB_CMDS cmd = SUB_CMDS.valueOf(args[0].toUpperCase());
                if (cmd.onlyPlayer && !(sendi instanceof Player)) {
                    sendi.sendMessage("Console cannot execute this command!");
                    return true;
                }
                switch (cmd) {
                    case GET:
                        String _item = args[1];
                        for (CustomPotions potionInfo : FraithorPots.getInstance().getPotions().getPotionsList()) {
                            if (potionInfo.name.equalsIgnoreCase(_item)) {
                                Player p = (Player) sendi;
                                p.getInventory().addItem(potionInfo.getItem());
                                sendi.sendMessage("Item Given!");
                                break;
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                usage(sendi, label);
            }
        } else
            usage(sendi, label);
        return true;
    }

    private void usage(CommandSender sendi, String label) {
        sendi.sendMessage("Usage: /%command% get <potion_name>".replace("%command%", label));
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (SUB_CMDS cmd : SUB_CMDS.values())
                if (cmd.name().startsWith(args[0].toUpperCase()))
                    list.add(cmd.name());
        } else if (args.length == 2) {
            for (SUB_CMDS cmd : SUB_CMDS.values())
                if (cmd.name().equalsIgnoreCase(args[0]))
                    switch (cmd) {
                        case GET:
                            for (CustomPotions potionInfo : FraithorPots.getInstance().getPotions().getPotionsList()) {
                                if (potionInfo.name.toLowerCase().startsWith(args[1].toLowerCase()))
                                    list.add(potionInfo.name);
                            }
                            break;
                    }
        }
        return list;
    }

    private enum SUB_CMDS {
        GET(true);

        boolean onlyPlayer;

        SUB_CMDS(boolean onlyPlayer) {
            this.onlyPlayer = onlyPlayer;
        }
    }
}
