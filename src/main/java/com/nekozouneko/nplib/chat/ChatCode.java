package com.nekozouneko.nplib.chat;

import com.nekozouneko.nplib.NPLib;

public final class ChatCode {

    public final static String BLACK = "§0";
    public final static String DARK_BLUE = "§1";
    public final static String DARK_GREEN = "§2";
    public final static String DARK_AQUA = "§3";
    public final static String DARK_RED = "§4";
    public final static String DARK_PURPLE = "§5";
    public final static String GOLD = "§6";
    public final static String GRAY = "§7";
    public final static String DARK_GRAY = "§8";
    public final static String BLUE = "§9";
    public final static String GREEN = "§a";
    public final static String AQUA = "§b";
    public final static String RED = "§c";
    public final static String LIGHT_PURPLE = "§d";
    public final static String YELLOW = "§e";
    public final static String WHITE = "§f";

    public final static String OBFUSCATED = "§k";
    public final static String BOLD = "§l";
    public final static String STRIKETHROUGH = "§m";
    public final static String UNDERLINE = "§n";
    public final static String ITALIC = "§o";
    public final static String RESET = "§r";

    /**
     * テキストからカラーに変換します。
     * @param color 変換するカラー
     * @return 変換済みのカラー
     */
    public static String valueOf(String color) {
        // カラー達やでぇ
        if (NPLib.equalsStrings(color, "BLACK", "black", "0", "Black")) return BLACK;
        else if (NPLib.equalsStrings(color, "DARK_BLUE", "dark_blue", "1", "Dark_blue", "Dark_Blue")) return DARK_BLUE;
        else if (NPLib.equalsStrings(color, "DARK_GREEN", "dark_green", "2", "Dark_green", "Dark_Green")) return DARK_GREEN;
        else if (NPLib.equalsStrings(color, "DARK_AQUA", "dark_aqua", "3", "Dark_aqua", "Dark_Aqua")) return DARK_AQUA;
        else if (NPLib.equalsStrings(color, "DARK_RED", "dark_red", "4", "Dark_red", "Dark_Red")) return DARK_RED;
        else if (NPLib.equalsStrings(color, "DARK_PURPLE", "dark_purple", "5", "Dark_purple", "Dark_Purple")) return DARK_PURPLE;
        else if (NPLib.equalsStrings(color, "GOLD", "gold", "6", "Gold")) return GOLD;
        else if (NPLib.equalsStrings(color, "GRAY", "gray", "7", "Gray")) return GRAY;
        else if (NPLib.equalsStrings(color, "DARK_GRAY", "dark_gray", "8", "Dark_gray", "Dark_Gray")) return DARK_GRAY;
        else if (NPLib.equalsStrings(color, "BLUE", "blue", "9", "Blue")) return BLUE;
        else if (NPLib.equalsStrings(color, "GREEN", "green", "a", "Green")) return GREEN;
        else if (NPLib.equalsStrings(color, "AQUA", "aqua", "b", "Aqua")) return AQUA;
        else if (NPLib.equalsStrings(color, "RED", "red", "c", "Red")) return RED;
        else if (NPLib.equalsStrings(color, "LIGHT_PURPLE", "light_purple", "d", "Light_purple", "Light_Purple")) return LIGHT_PURPLE;
        else if (NPLib.equalsStrings(color, "YELLOW", "yellow", "e", "Yellow")) return YELLOW;
        else if (NPLib.equalsStrings(color, "WHITE", "white", "f", "White")) return WHITE;
        // 装飾コード達やでぇ
        else if (NPLib.equalsStrings(color, "OBFUSCATED", "obfuscated", "k", "Obfuscated")) return OBFUSCATED;
        else if (NPLib.equalsStrings(color, "BOLD", "bold", "l", "Bold")) return BOLD;
        else if (NPLib.equalsStrings(color, "STRIKETHROUGH", "strikethrough", "m", "Strikethrough")) return STRIKETHROUGH;
        else if (NPLib.equalsStrings(color, "UNDERLINE", "underline", "n", "Underline")) return UNDERLINE;
        else if (NPLib.equalsStrings(color, "ITALIC", "italic", "o", "Italic")) return ITALIC;
        else if (NPLib.equalsStrings(color, "RESET", "reset", "r", "Reset")) return RESET;
        // 404
        else return null;
    }

    /**
     * cpをカラーコードに変換
     * @param cp §からカラーコードに置き換えするもの
     * @param str テキスト
     * @return
     */
    public static String toColorCode(String cp, String str) {
        return str.replaceAll("\\\\"+cp, cp)
                .replaceAll(cp+"a", "§a").replaceAll(cp+"A", "§a")
                .replaceAll(cp+"b", "§b").replaceAll(cp+"B", "§b")
                .replaceAll(cp+"c", "§c").replaceAll(cp+"C", "§c")
                .replaceAll(cp+"d", "§d").replaceAll(cp+"D", "§d")
                .replaceAll(cp+"e", "§e").replaceAll(cp+"E", "§e")
                .replaceAll(cp+"f", "§f").replaceAll(cp+"F", "§f")
                .replaceAll(cp+"k", "§k").replaceAll(cp+"K", "§k")
                .replaceAll(cp+"l", "§l").replaceAll(cp+"L", "§l")
                .replaceAll(cp+"m", "§m").replaceAll(cp+"M", "§m")
                .replaceAll(cp+"n", "§n").replaceAll(cp+"N", "§n")
                .replaceAll(cp+"o", "§o").replaceAll(cp+"O", "§o")
                .replaceAll(cp+"r", "§r").replaceAll(cp+"R", "§r")
                .replaceAll(cp+"0", "§0").replaceAll(cp+"1", "§1")
                .replaceAll(cp+"2", "§2").replaceAll(cp+"3", "§3")
                .replaceAll(cp+"4", "§4").replaceAll(cp+"5", "§5")
                .replaceAll(cp+"6", "§6").replaceAll(cp+"7", "§7")
                .replaceAll(cp+"8", "§8").replaceAll(cp+"9", "§9");
    }

}
