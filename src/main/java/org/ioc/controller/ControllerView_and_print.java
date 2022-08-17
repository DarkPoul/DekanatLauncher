package org.ioc.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import org.ioc.App;

public class ControllerView_and_print {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Export_printing;

    @FXML
    private ChoiceBox<?> Form_education_printing;

    @FXML
    private ChoiceBox<?> Group_printing;

    @FXML
    private ChoiceBox<?> Level_studing;

    @FXML
    private TableColumn<?, ?> Name_printing;

    @FXML
    private Button Rating_printing;

    @FXML
    private TableColumn<?, ?> Secondname_printing;

    @FXML
    private TableColumn<?, ?> Surname_printing;

    @FXML
    private Button To_exel;

    @FXML
    private Button journal_printing;

    @FXML
    private TableColumn<?, ?> rating_paper_printing;


    @FXML
    void initialize() {
        assert Export_printing != null : "fx:id=\"Export_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Form_education_printing != null : "fx:id=\"Form_education_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Group_printing != null : "fx:id=\"Group_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Level_studing != null : "fx:id=\"Level_studing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Name_printing != null : "fx:id=\"Name_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Rating_printing != null : "fx:id=\"Rating_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Secondname_printing != null : "fx:id=\"Secondname_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert Surname_printing != null : "fx:id=\"Surname_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert To_exel != null : "fx:id=\"To_exel\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert journal_printing != null : "fx:id=\"journal_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";
        assert rating_paper_printing != null : "fx:id=\"rating_paper_printing\" was not injected: check your FXML file 'view_and_print.fxml'.";


    }

    public void menu(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/MainWindow");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void suprovid(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/EduProcessCuration");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/view_and_print");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void modular(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Modular_results_preview");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ask(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Directory");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void info(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/about_developers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateGroup(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Creating_group");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddNewStudent(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/add_student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void MigrateStudentGroup(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Diversification_of_students_by_groups");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddStudent(ActionEvent actionEvent) {
        //
        //
        //
    }

    public void ViewCard(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Student_Сard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddMark(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Entering_estimates_from_the_information");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ViewBorg(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/Students_with_debts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void MigrateCourse(ActionEvent actionEvent) {
        try {
            App.setRoot("gui/for_next_course");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
