package org.ioc.settings;

//import org.ioc.settings.UpdateDekanat;

import java.net.MalformedURLException;
import java.net.URL;

public class Settings {
    public static URL update;
    public static URL update_Dekanat;
    public static String HomePass = System.getProperty("user.home");

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////                                      Для компіляції                                ///////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//    public static String zipPath = HomePass + "/AppData/Local/Programs/Dekanat/main/resources/org/ioc/settings";
//    public static String zipFile = "/Update.zip";
//
//    public static String OutPutFolder = HomePass + "/AppData/Local/Programs/Dekanat/main/resources/org/ioc/settings/Update.zip";
//    public static String HashFile = HomePass + "/AppData/Local/Programs/Dekanat/main/resources/org/ioc/settings/Update/Update-main/Hash.txt";
//    public static String ConfigFile = HomePass + "/AppData/Local/Programs/Dekanat/main/resources/org/ioc/settings/Config.xml";
//    public static String BatFile = HomePass + "/AppData/Local/Programs/Dekanat/update.bat";


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////                                 Для роботи з проекту                               ///////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static String zipPath = HomePass + "/IdeaProjects/DekanatLauncher/src/main/resources/org/ioc/settings";
    public static String zipFile = "/Update.zip";

    public static String OutPutFolder = HomePass + "/IdeaProjects/DekanatLauncher/src/main/resources/org/ioc/settings/Update.zip";
    public static String HashFile = HomePass + "/IdeaProjects/DekanatLauncher/src/main/resources/org/ioc/settings/Update/Update-main/Hash.txt";
    public static String ConfigFile = HomePass + "/IdeaProjects/DekanatLauncher/src/main/resources/org/ioc/settings/Config.xml";





    static {
        try {
            update = new URL("https://github.com/DarkPoul/Update/archive/refs/heads/main.zip");
            update_Dekanat = new URL("https://github.com/DarkPoul/Update_Dekanat/archive/refs/heads/master.zip");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
