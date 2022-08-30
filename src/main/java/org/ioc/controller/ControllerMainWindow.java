package org.ioc.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.App;
import org.ioc.Main;

import static org.ioc.controller.ControllerApp.LoginName;


public class ControllerMainWindow {


    public static  VBox box;
    public Label exit;
    public ImageView icon;


    @FXML
    public Label name;

    @FXML
    void initialize() {name.setText(LoginName);}

    public void Registration_of_enrolled_students() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui/Registration_of_enrolled_students.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void Support_of_the_educational_process() {
    }

    public void Making_changes_and_transferring_to_a_course() {
    }

    public void View_and_print_information() {
    }

    public void Modular_control() {
    }

    public void Directory() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui/Directory.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void About_developers() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Про розробників");
        alert.setHeaderText("Розробку вели 'Інформаційно-обчислювальний центр'");
        alert.setContentText("По всім питанням звертатися - НТУ ІОЦ( 244 к.) \nПочта - ntu2445@gmail.com");
        alert.showAndWait();
    }

    public void Exit(ActionEvent event) {
        ((Stage) name.getScene().getWindow()).close();
    }
}
