<h1 align="center">NPLib</h1>
<p align="center">NPLibはBukkit/Spigotのを簡単に使うためのユーティリティライブラリです。</p>

## インストール方法
### Maven
```xml
<project>
    <repositories>
        <repository>
            <id>nekorepo</id>
            <url>https://nekozouneko.ddns.net/nexus/repository/nekorepo/</url>
        </repository>
    </repositories>

    <dependency>
        <groupId>com.nekozouneko.NPLib</groupId>
        <artifactId>nplib</artifactId>
        <version>1.0</version>
    </dependency>
</project>
```

```groovy
repositories {
    maven { url = 'https://nekozouneko.ddns.net/nexus/repository/nekorepo/' }
}

dependencies {
    implementation 'com.nekozouneko.NPLib:nplib:1.0'
}
```