package org.ioc.settings;

import java.net.MalformedURLException;
import java.net.URL;

public class Settings {
    public static URL update;
    public static String HomePass = System.getProperty("user.home");
    public static String zipPath = HomePass + "/AppData/Local/Programs/main/resources/org/ioc/settings";
    public static String zipFile = "/Update.zip";

    public static String OutPutFolder = HomePass + "/AppData/Local/Programs/main/resources/org/ioc/settings/Update.zip";
    public static String HashFile = HomePass + "/AppData/Local/Programs/main/resources/org/ioc/settings/Update/Update-main/Hash.txt";
    public static String ConfigFile = HomePass + "/AppData/Local/Programs/main/resources/org/ioc/settings/Config.xml";





    static {
        try {
            update = new URL("https://github.com/DarkPoul/Update/archive/refs/heads/main.zip");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
