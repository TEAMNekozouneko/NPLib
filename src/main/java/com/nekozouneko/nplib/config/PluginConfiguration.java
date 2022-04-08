package com.nekozouneko.nplib.config;

import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class PluginConfiguration {

    private final JavaPlugin instance;
    private final InputStream ConfigFile;

    private final Map<Object, Object> ConfigMap;

    private final Yaml yml = new Yaml();

    /**
     * プラグインの設定ファイルのインスタンスを作成 (ymlのみ)
     * @param plugin プラグインのインスタンス
     * @param resourceConfigFile 設定ファイルとして扱う.jar内のリソースディレクトリ内蔵のファイル
     * @throws IOException リソースディレクトリに入ってない場合
     */
    public PluginConfiguration(@Nonnull JavaPlugin plugin, String resourceConfigFile) throws IOException {
        this.instance = plugin;
        if (instance.getResource(resourceConfigFile) == null) throw new IOException("Plugin resource file \"" + resourceConfigFile + "\" is not found!");
        else ConfigFile = instance.getResource(resourceConfigFile);

        Iterable<Object> ConfigObj = yml.loadAll(ConfigFile);
        ConfigMap = (Map<Object, Object>) ConfigObj;
    }

    /**
     * config.ymlから値を取得します。
     * @param key 値のキー (.でその中参照)
     * @return 取得した値 (存在しなければnull)
     * @throws IllegalArgumentException 空白指定なら
     */
    @Nullable
    public Object get(String key) throws IllegalArgumentException {
        if (key.isEmpty() || key.isBlank()) {
            throw new IllegalArgumentException("key is empty!");
        }

        String[] path = key.split("\\.");
        if (path.length >= 1) return ConfigMap.get(key);
        else {
            Map<Object, Object> CfgMap = ConfigMap;
            for (String k : path) {
                if (path[path.length-1].equalsIgnoreCase(k)) return CfgMap.get(k);
                else {
                    CfgMap = (Map<Object, Object>) CfgMap.get(k);
                }
            }
            return null;
        }
    }

}