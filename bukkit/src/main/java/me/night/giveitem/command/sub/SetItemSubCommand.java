package me.night.giveitem.command.sub;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.annotations.RequiredPlayer;
import cc.dreamcode.command.bukkit.BukkitCommand;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import me.night.giveitem.config.MessageConfig;
import me.night.giveitem.config.PluginConfig;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@RequiredPlayer
@RequiredPermission(permission = "setitem.admin")
public class SetItemSubCommand extends BukkitCommand {

    @Inject
    private MessageConfig messageConfig;

    @Inject
    private PluginConfig pluginConfig;

    public SetItemSubCommand() {
        super("setitem");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        Player player = (Player) sender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if(itemStack.getType() == Material.AIR) {
            this.messageConfig.itemIsAir.send(sender);
            return;
        }

        this.pluginConfig.set("itemStack", itemStack);
        this.pluginConfig.save();

        this.messageConfig.itemSuccessfulySet.send(sender);
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
