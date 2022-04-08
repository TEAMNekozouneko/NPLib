package com.nekozouneko.nplib.config;

import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PluginConfiguration {

    private final JavaPlugin instance;
    private final InputStream ConfigFile;
    private final String fileName;

    private Map<String, Object> ConfigMap;

    private final Yaml yml = new Yaml();

    /**
     * プラグインの設定ファイルのインスタンスを作成 (ymlのみ)
     * @param plugin プラグインのインスタンス
     * @param resourceConfigFile 設定ファイルとして扱う.jar内のリソースディレクトリ内蔵のファイル
     * @throws IOException リソースディレクトリに入ってない場合
     */
    public PluginConfiguration(@Nonnull JavaPlugin plugin, String resourceConfigFile) throws IOException {
        this.instance = plugin;
        this.fileName = resourceConfigFile;
        if (instance.getResource(resourceConfigFile) == null) throw new IOException("Plugin resource file \"" + resourceConfigFile + "\" is not found!");
        else ConfigFile = instance.getResource(resourceConfigFile);

        Iterable<Object> ConfigObj = yml.loadAll(ConfigFile);
        ConfigMap = (Map<String, Object>) ConfigObj;
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
            Map<String, Object> CfgMap = ConfigMap;
            for (String k : path) {
                if (path[path.length-1].equalsIgnoreCase(k)) return CfgMap.get(k);
                else {
                    CfgMap = (Map<String, Object>) CfgMap.get(k);
                }
            }
            return null;
        }
    }

    /**
     * 設定ファイルを保存します。
     * @param isForceSave 強制保存するか
     * @throws IOException ファイルの入出力や権限問題が発生したときに流れます。
     */
    public void save(boolean isForceSave) throws IOException {
        File configPath = new File(instance.getDataFolder(), fileName);
        if (!isForceSave) {
            if (!configPath.exists()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(ConfigFile, StandardCharsets.UTF_8));
                String readStr;
                StringBuilder appender = new StringBuilder();

                while ((readStr = reader.readLine()) != null) {
                    appender.append(readStr);
                }

                String output = appender.toString();

                FileWriter writer = new FileWriter(configPath);
                writer.write(output);
            }
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ConfigFile, StandardCharsets.UTF_8));
            String readStr;
            StringBuilder appender = new StringBuilder();

            while ((readStr = reader.readLine()) != null) {
                appender.append(readStr);
            }

            String output = appender.toString();

            FileWriter writer = new FileWriter(configPath);
            writer.write(output);
        }
    }

    /**
     * 設定ファイルを再読み込みします。
     * @throws IOException 権限や入出力エラー
     */
    public void reload() throws IOException {
        File configPath = new File(instance.getDataFolder(), fileName);

        Iterable<Object> ConfigObj = yml.loadAll(ConfigFile);
        ConfigMap = (Map<String, Object>) ConfigObj;
    }

}