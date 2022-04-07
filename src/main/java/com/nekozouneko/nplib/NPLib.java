package com.nekozouneko.nplib;

/**
 * NPLibはBukkit / Spigotプラグインの簡単なユーティリティ関数軍です。
 * @author Taitaitatata
 * @version 1.2
 */
public final class NPLib {
    /**
     * 複数のテキストと比較します。
     * @param equals_str 比較元のテキスト
     * @param strings 比較する複数のテキスト
     * @return 比較した時同一テキストがあるかどうか
     */
    public static boolean equalsStrings(String equals_str, String... strings) {
        for (String str : strings) {
            if (str.equalsIgnoreCase(equals_str)) return true;
        }
        return false;
    }

    /**
     * ティックから秒数に変換します。
     * @param tick ティック
     * @return 秒数
     */
    public static double tickToSecond(double tick) {
        return tick / 20d;
    }

    /**
     * ティックから秒数に変換します。
     * @param tick ティック
     * @return 秒数
     */
    public static double tickToSecond(int tick) {
        return tick / 20d;
    }

    /**
     * ティックから秒数に変換します。
     * @param tick ティック
     * @return 秒数
     */
    public static double tickToSecond(long tick) {
        return tick / 20d;
    }

    /**
     * ティックから秒数に変換します。
     * @param tick ティック
     * @return 秒数
     */
    public static double tickToSecond(short tick) {
        return tick / 20d;
    }

    /**
     * 秒数からティックに変換します。
     * @param second 秒数
     * @return ティック
     */
    public static double secondToTick(double second) {
        return second * 20;
    }

    /**
     * 秒数からティックに変換します。
     * @param second 秒数
     * @return ティック
     */
    public static double secondToTick(int second) {
        return second * 20;
    }

    /**
     * 秒数からティックに変換します。
     * @param second 秒数
     * @return ティック
     */
    public static double secondToTick(long second) {
        return second * 20;
    }

    /**
     * 秒数からティックに変換します。
     * @param second 秒数
     * @return ティック
     */
    public static double secondToTick(short second) {
        return second * 20;
    }

}
