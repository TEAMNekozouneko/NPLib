package com.nekozouneko.NPLib;

/**
 * @author Taitaitatata
 * @version 1.0
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

}
