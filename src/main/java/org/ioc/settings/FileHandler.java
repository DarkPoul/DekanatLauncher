package org.ioc.settings;
import org.ioc.settings.Settings;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileHandler {
    public static void NewLogin(String OldData, String NewData) throws IOException {
        Scanner sc = new Scanner(new File(Settings.ConfigFile));
        StringBuilder buffer = new StringBuilder();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()).append(System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        sc.close();
        fileContents = fileContents.replaceAll(OldData, NewData);
        FileWriter writer = new FileWriter(Settings.ConfigFile);
        System.out.println("");
        System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();
    }


}
