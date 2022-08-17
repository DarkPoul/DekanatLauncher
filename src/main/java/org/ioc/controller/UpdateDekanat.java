package org.ioc.controller;

import org.ioc.models.XmlParser;
import org.ioc.settings.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.ioc.controller.ControllerApp.downloadFile;

public class UpdateDekanat extends Thread{
    public void run() {
        try {
            downloadFile(Settings.update_Dekanat, Settings.OutPutFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
