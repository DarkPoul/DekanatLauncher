package org.ioc.controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import org.ioc.DataBase.DB_Authentication;

import org.ioc.Main;

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
    public static String Id_User = "";

    @FXML
    void initialize() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("settings.properties"));
        LoginName = prop.getProperty("login");
        login_field.setText(LoginName);







        login_button.setOnAction(actionEvent -> {
            if (!Objects.equals(prop.getProperty("login"), login_field.getText())){
                prop.setProperty("login", login_field.getText());
                try {
                    prop.store(new FileOutputStream("settings.properties"), null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            Open_main();
        });

        update_button.setOnAction(actionEvent -> {
        });
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


