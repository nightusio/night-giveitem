package me.night.giveitem.config;

import cc.dreamcode.notice.minecraft.MinecraftNoticeType;
import cc.dreamcode.notice.minecraft.bukkit.BukkitNotice;
import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.Headers;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;

@Configuration(
        child = "message.yml"
)
@Headers({
        @Header("## night-giveitem (Message-Config) ##"),
        @Header("Dostepne type: (DO_NOT_SEND, CHAT, ACTION_BAR, SUBTITLE, TITLE, TITLE_SUBTITLE)")
})
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class MessageConfig extends OkaeriConfig {

    public BukkitNotice usage = new BukkitNotice(MinecraftNoticeType.CHAT, "&7Poprawne uzycie: &c{usage}");
    public BukkitNotice noPermission = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Nie posiadasz uprawnien.");
    public BukkitNotice noPlayer = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Podanego gracza &cnie znaleziono.");
    public BukkitNotice notPlayer = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Nie jestes graczem.");
    public BukkitNotice notNumber = new BukkitNotice(MinecraftNoticeType.CHAT, "&4Podana liczba &cnie jest cyfra.");

    public BukkitNotice itemIsAir = new BukkitNotice(MinecraftNoticeType.CHAT, "&4>> &cNie mozesz ustawic itemku jako powietrze!");
    public BukkitNotice itemSuccessfulySet = new BukkitNotice(MinecraftNoticeType.CHAT, "&2>> &aPomyslnie ustawiles itemek!");
    public BukkitNotice itemStackIsNull = new BukkitNotice(MinecraftNoticeType.CHAT, "&4>> &cPrzedmiot nie jest ustawiony!");

    public BukkitNotice gaveItemAllSuccessfuly = new BukkitNotice(MinecraftNoticeType.CHAT, "&2>> &aPomyslnie dales itemek &6calemu serwerowi &a!");
    public BukkitNotice gaveItemPlayerSuccessfuly = new BukkitNotice(MinecraftNoticeType.CHAT, "&2>> &aPomyslnie dales itemek graczowi &6{player} &a!");


}
