package org.ioc.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import org.ioc.App;

public class ControllerFor_next_course {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button_for_next_course;

    @FXML
    private DatePicker Date_for_next_course;

    @FXML
    private Button Debtors;

    @FXML
    private ChoiceBox<?> Group_for_next_course;

    @FXML
    private TableColumn<?, ?> Lastname_for_next_course;

    @FXML
    private TableColumn<?, ?> Name_for_next_course;

    @FXML
    private TableColumn<?, ?> Surname_for_next_course;

    @FXML
    private TextField number_of_order;

    @FXML
    void initialize() {
        assert Button_for_next_course != null : "fx:id=\"Button_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Date_for_next_course != null : "fx:id=\"Date_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Debtors != null : "fx:id=\"Debtors\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Group_for_next_course != null : "fx:id=\"Group_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Lastname_for_next_course != null : "fx:id=\"Lastname_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Name_for_next_course != null : "fx:id=\"Name_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert Surname_for_next_course != null : "fx:id=\"Surname_for_next_course\" was not injected: check your FXML file 'for_next_course.fxml'.";
        assert number_of_order != null : "fx:id=\"number_of_order\" was not injected: check your FXML file 'for_next_course.fxml'.";

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

