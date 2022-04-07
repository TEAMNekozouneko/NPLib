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

    <dependencies>
        <dependency>
            <groupId>com.nekozouneko.nplibcom.nekozouneko.nplib</groupId>
            <artifactId>nplib</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>
</project>
```
### Gradle
```groovy
repositories {
    maven { url = 'https://nekozouneko.ddns.net/nexus/repository/nekorepo/' }
}

dependencies {
    implementation 'com.nekozouneko.nplib:nplib:1.2'
}
```