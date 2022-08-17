package org.ioc.controller;

import org.ioc.settings.Settings;
import java.io.IOException;

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
