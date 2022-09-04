package org.ioc.controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.DataBase.DB_Authentication;

import org.ioc.Main;
import org.ioc.settings.*;

//import static org.ioc.settings.Settings.BatFile;


public class ControllerApp {

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
    public static String hash = "fail";
    public static String Id_User = "";

    @FXML
    void initialize() throws IOException, InterruptedException {
        System.out.println(Hash.getHashText());
        downloadFile(Settings.update, Settings.OutPutFolder);
        unpackZip(Settings.zipPath, Settings.zipFile);

        Thread thread = new XmlReader();
        thread.start();

        thread.join();
        login_field.setText(String.valueOf(LoginName));




        try (BufferedReader reader = Files.newBufferedReader(Paths.get(Settings.HashFile))) {
           hash = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!Objects.equals(hash, HashCodOld)){
            update_box.setVisible(true);
            login_box.setVisible(false);
        }

        login_button.setOnAction(actionEvent -> {
            Open_main();
        });

        update_button.setOnAction(actionEvent -> {
            try {
                FileHandler.NewLogin("<hesh>"+HashCodOld+"</hesh>", "<hesh>"+hash+"</hesh>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Thread up_dekanat = new UpdateDekanat();
            up_dekanat.start();
            try {
                up_dekanat.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (!up_dekanat.isAlive()){
                unpackZip(Settings.zipPath, Settings.zipFile);
//                try {
//                    Runtime.getRuntime().exec("cmd /c " + BatFile);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
                Close_window();
            }


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

    public void Close_window(){
        Stage close_window = (Stage) update_button.getScene().getWindow();
        close_window.close();
    }

    public void Open(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Open_main();
        }
    }

    public void Open_main(){
        if (!Objects.equals(login_field.getText(), LoginName)){
            try {
                FileHandler.NewLogin("<login_dekanat>"+LoginName+"</login_dekanat>", "<login_dekanat>"+login_field.getText()+"</login_dekanat>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            DB_Authentication.Open_DB();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (DB_Authentication.True_connection){
            //////////////////////////////////////////////////////////////////////////
            boolean Connection_dekanat = false;
            DB_Authentication dataBaseHandler = new DB_Authentication();//Створюємо нову змінну на основі створеного нами класу
            ResultSet Log_pass = dataBaseHandler.Connection_Dekanat();//Викликаємо функцію з іншого класу
            List<String> var_1_List = new LinkedList<>();
            List<String> var_2_List = new LinkedList<>();//Створюємо список
            List<String> var_3_List = new LinkedList<>();//Створюємо список
            while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
                try {
                    if (!Log_pass.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String Login_string = null;
                String Password_string = null;
                String Login_ID = null;
                try {
                    Login_string = Log_pass.getString("Login");
                    Password_string = Log_pass.getString("password");
                    Login_ID = Log_pass.getString("ID_Faculty");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                var_1_List.add(Login_string);//додаємо отримані результати у список
                var_2_List.add(Password_string);
                var_3_List.add(Login_ID);
            }
            for (int i = 0; i < var_1_List.size(); i++) {
                if(Objects.equals(login_field.getText(), var_1_List.get(i))){
                    Connection_dekanat = Objects.equals(pass_field.getText(), var_2_List.get(i));
                    Id_User = var_3_List.get(i);
                }
            }

            if (Connection_dekanat) {
                System.out.println("to new class");
                try {
                    Stage stage = new Stage();
                    stage.setTitle("");
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui/MainWindow.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1024, 768);

                    stage.setScene(scene);
                    stage.show();
                    Close_window();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("Connection failed...");
            }
        } else System.out.println("Connection failed...");
    }
}


