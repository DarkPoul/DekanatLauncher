package org.ioc.settings;

import java.net.MalformedURLException;
import java.net.URL;

public class Settings {
    public static URL update;
    public static String zipPath = System.getProperty("user.home")+"/IdeaProjects/DekanatLauncher/target";
    public static String zipFile = "/Update.zip";
    public static String HashFile = System.getProperty("user.home")+"/IdeaProjects/DekanatLauncher/target/Update/Update-main/Hash.txt";
    public static String ConfigFile = System.getProperty("user.home")+"/IdeaProjects/DekanatLauncher/src/main/resources/org/ioc/settings/Config.xml";



    static {
        try {
            update = new URL("https://github.com/DarkPoul/Update/archive/refs/heads/main.zip");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
