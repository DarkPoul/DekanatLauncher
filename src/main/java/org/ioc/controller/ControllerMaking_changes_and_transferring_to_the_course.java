package org.ioc.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.App;
import org.ioc.Main;

import java.io.IOException;

public class ControllerMaking_changes_and_transferring_to_the_course {

    @FXML
    private Button Entering_estimates_from_the_information;

    @FXML
    private Button Supporting_documents;

    @FXML
    private Button Transfer_to_the_course;

    @FXML
    private Button View_debtors;

    @FXML
    void initialize() {

    }

    public void View_and_edit_cards() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui/view_and_print.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
