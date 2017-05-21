# Cadbury
A library for shape generation

Resolving artifacts using Maven
```
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
          xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
    
    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-pukingminion-Cadbury</id>
                    <name>bintray</name>
                    <url>http://pukingminion.bintray.com/Cadbury</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-pukingminion-Cadbury</id>
                    <name>bintray-plugins</name>
                    <url>http://pukingminion.bintray.com/Cadbury</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```


Resolving artifacts using Gradle

```
repositories {
    maven {
        url  "http://pukingminion.bintray.com/Cadbury" 
    }
}
```
