package me.night.giveitem.command;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.bukkit.BukkitCommand;
import cc.dreamcode.utilities.builder.MapBuilder;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import me.night.giveitem.ItemPlugin;
import me.night.giveitem.command.sub.GiveItemSubCommand;
import me.night.giveitem.command.sub.SetItemSubCommand;
import me.night.giveitem.config.MessageConfig;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredPermission(permission = "setitem.admin")
public class GiveItemCommand extends BukkitCommand {

    @Inject
    private MessageConfig messageConfig;

    @Inject
    private ItemPlugin itemPlugin;

    public GiveItemCommand() {
        super("giveitem");

        this.registerSubcommand(SetItemSubCommand.class);
        this.registerSubcommand(GiveItemSubCommand.class);
    }


    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        this.messageConfig.usage.send(sender, new MapBuilder<String, Object>()
                .put("usage", "/giveitem (setitem/giveitem) (player/all) (amount)")
                .build());
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        if(args.length == 1) {
            return Arrays.asList("setitem", "giveitem");
        }
        if(args.length == 2 && args[0].equalsIgnoreCase("giveitem")) {
            return this.itemPlugin.getServer().getOnlinePlayers()
                    .stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
        }
        if(args.length == 3 && args[0].equalsIgnoreCase("giveitem")) {
            return Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        }
        return null;
    }
}
