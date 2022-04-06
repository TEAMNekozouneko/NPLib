package com.nekozouneko.nplib.chat;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerSender {

    private String prefix;
    private final Player Sender;

    /**
     * 新しいPlayerSenderインスタンスを作成
     * @param p プレイヤー
     */
    public PlayerSender(Player p) {
        Sender = p;
    }

    /**
     * メッセージのprefixをセットします。
     * @param prefix プレフィックス
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * プレイヤーにメッセージを送信します
     * @param text 送信するテキスト
     */
    public void sendMessage(String text) {
        Sender.sendMessage(text);
    }

    /**
     * プレイヤーにメッセージを送信します
     * @param text 送信するテキスト
     */
    public void sendMessage(BaseComponent text) {
        Sender.spigot().sendMessage(text);
    }

    /**
     * プレイヤーにプレフィックス付きでメッセージを送信します
     * @param text 送信するテキスト
     */
    public void sendMessageWithPrefix(String text) {
        if (prefix == null) sendMessage(text);
        else sendMessage(prefix + text);
    }

    /**
     * プレイヤーにプレフィックス付きでメッセージを送信します
     * @param text 送信するテキスト
     */
    public void sendMessageWithPrefix(BaseComponent text) {
        if (prefix == null) sendMessage(text);
        else {
            BaseComponent bc = new TextComponent(prefix);
            bc.addExtra(text);

            sendMessage(bc);
        }
    }

    /**
     * プレイヤーにタイトルを送信します。
     * いずれかの値がnullの場合表示されない場合があります。
     * @param Title 一番大きく表示するテキスト
     * @param subTitle 二番目に大きく表示するテキスト
     * @param fadeIn フェードイン (Tick換算)
     * @param stay 表示時間 (Tick換算)
     * @param fadeOut フェードアウト (Tick換算)
     */
    public void sendTitle(@Nullable String Title, @Nullable String subTitle, int fadeIn, int stay, int fadeOut) {
        Sender.sendTitle(Title, subTitle, fadeIn, stay, fadeOut);
    }

    /**
     * プレイヤーにタイトルを送信します。
     * いずれかの値がnullの場合表示されない場合があります。
     * (フェードイン: 10tick / 表示時間: 70tick / フェードアウト: 20tick)
     * @param Title 一番大きく表示するテキスト
     * @param subTitle 二番目に大きく表示するテキスト
     */
    public void sendTitle(@Nullable String Title, @Nullable String subTitle) {
        Sender.sendTitle(Title, subTitle, 10, 70, 20);
    }

    /**
     * プレイヤーにアクションバーを送信します。
     * @param Actionbar アクションバーに表示するテキスト
     */
    public void sendActionbar(@Nonnull String Actionbar) {
        BaseComponent ac = new TextComponent(Actionbar);
        Sender.spigot().sendMessage(ChatMessageType.ACTION_BAR, ac);
    }

    /**
     * プレイヤーにアクションバーを送信します。
     * @param Actionbar アクションバーに表示するテキスト
     */
    public void sendActionbar(@Nonnull BaseComponent Actionbar) {
        Sender.spigot().sendMessage(ChatMessageType.ACTION_BAR, Actionbar);
    }

}
