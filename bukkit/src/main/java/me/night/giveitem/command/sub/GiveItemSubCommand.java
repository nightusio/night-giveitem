package me.night.giveitem.command.sub;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.bukkit.BukkitCommand;
import cc.dreamcode.utilities.builder.MapBuilder;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import me.night.giveitem.ItemPlugin;
import me.night.giveitem.config.MessageConfig;
import me.night.giveitem.config.PluginConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@RequiredPermission(permission = "setitem.admin")
public class GiveItemSubCommand extends BukkitCommand {

    @Inject
    private PluginConfig pluginConfig;

    @Inject
    private ItemPlugin itemPlugin;

    @Inject
    private MessageConfig messageConfig;

    public GiveItemSubCommand() {
        super("giveitem");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        if (this.pluginConfig.itemStack == null) {
            this.messageConfig.itemStackIsNull.send(sender);
            return;
        }

        try {
            int amount = Integer.parseInt(args[1]);
            ItemStack itemToGive = this.pluginConfig.itemStack.clone();
            itemToGive.setAmount(amount);

            if(args[0].equalsIgnoreCase("all")) {
                this.itemPlugin.getServer().getOnlinePlayers().forEach(player -> {
                    player.getInventory().addItem(itemToGive);
                    this.messageConfig.gaveItemAllSuccessfuly.send(sender);
                });
                return;
            }

            Player targetPlayer = Bukkit.getPlayerExact(args[1]);

            if (targetPlayer == null || !targetPlayer.isOnline()) {
                this.messageConfig.noPlayer.send(sender);
                return;
            }

            targetPlayer.getInventory().addItem(itemToGive);
            this.messageConfig.gaveItemPlayerSuccessfuly.send(sender, new MapBuilder<String, Object>()
                    .put("player", targetPlayer.getName())
                    .build());
        } catch (NumberFormatException e) {
            this.messageConfig.notNumber.send(sender);
        }
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
