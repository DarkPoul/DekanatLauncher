package org.ioc.settings;

import org.ioc.controller.ControllerApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlReader extends Thread{
    public void run(){
            System.out.println("hello Thread");
            XmlParser xml;
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(Settings.ConfigFile))) {
                System.out.println("test1");
                reader.readLine();
                reader.readLine();
                String value2= reader.readLine();
                String value3 = reader.readLine();
                xml = new XmlParser(value2, value3);
            } catch (IOException e) {
                System.out.println("test2");
                throw new RuntimeException(e);
            }
            ControllerApp.HashCodOld = xml.getHashCod().split(">")[1].split("<")[0];
            ControllerApp.LoginName = xml.getLogin().split(">")[1].split("<")[0];
    }
}
