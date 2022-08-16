package org.ioc.controller;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.ioc.models.XmlParser;

import org.ioc.settings.Hash;
import org.ioc.settings.Settings;

//import org.ioc.DB;


public class ControllerApp {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox login_box;

    @FXML
    private Button login_button;

    @FXML
    private VBox update_box;

    @FXML
    private Button update_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    public static String LoginName;
    public static String HashCodOld;

    @FXML
    void initialize() throws IOException, InterruptedException {
        System.out.println("ooooooo");

        System.out.println(Hash.getHashText());


        downloadFile(Settings.update, Settings.OutPutFolder);

        unpackZip(Settings.zipPath, Settings.zipFile);



        Thread thread1 = Thread.currentThread();



        Thread thread = new XmlReader();
        thread.start();
        //thread1.join();
        thread.join();

        System.out.println(LoginName);
        login_field.setText(String.valueOf(LoginName));

        String hash = "fail";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(Settings.HashFile))) {
           hash = reader.readLine();
        } catch (IOException e) {
            System.out.println("test2");
        }

        System.out.println(hash);
        System.out.println(HashCodOld);
        if (!Objects.equals(hash, HashCodOld)){
            update_box.setVisible(true);
            login_box.setVisible(false);
        }



//





        //XmlParser xml = new XmlParser();








        login_button.setOnAction(actionEvent -> {
                login_box.setVisible(false);
                update_box.setVisible(true);
            if (login_field.getText() != LoginName){
                try {
                    FileHandler.NewLogin("<login_dekanat>"+LoginName+"</login_dekanat>", "<login_dekanat>"+login_field.getText()+"</login_dekanat>");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
        });
        update_button.setOnAction(actionEvent -> {
            login_box.setVisible(true);
            update_box.setVisible(false);
        });
    }


    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    private void unpackZip(String path, String zipname)
    {
        InputStream is;
        ZipInputStream zis;
        try
        {
            is = new FileInputStream(path + zipname);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;

            while((ze = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                String filename = ze.getName();
                String substring = zipname.substring(0, zipname.length() - 4);
                String s = path + substring + "\\" + filename;
                if(ze.isDirectory()) {
                    File directPath = new File(s);
                    directPath.mkdirs();
                } else {
                    File directPath = new File(path + substring + "\\");
                    directPath.mkdir();
                    FileOutputStream fout = new FileOutputStream(s);

                    // reading and writing
                    while((count = zis.read(buffer)) != -1)
                    {
                        baos.write(buffer, 0, count);
                        byte[] bytes = baos.toByteArray();
                        fout.write(bytes);
                        baos.reset();
                    }

                    fout.close();
                    zis.closeEntry();
                }
            }

            zis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return;
        }

        System.out.println(true);
    }

}


