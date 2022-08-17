package org.ioc.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import org.ioc.App;

public class ControllerModular_results_preview {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> choose_control_type;

    @FXML
    private ChoiceBox<?> choose_faculty;

    @FXML
    private ChoiceBox<?> choose_group;

    @FXML
    private Spinner<?> choose_semester;

    @FXML
    private Button consolidated_table;

    @FXML
    private Button departments;

    @FXML
    private Button exit;

    @FXML
    private Button faculties;

    @FXML
    private Button general_table_button;

    @FXML
    private Button not_inputed_data;

    @FXML
    private Button schedule;

    @FXML
    private Button students_with_unsatisfying_results;

    @FXML
    private Button table;

    @FXML
    void initialize() {
        assert choose_control_type != null : "fx:id=\"choose_control_type\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert choose_faculty != null : "fx:id=\"choose_faculty\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert choose_group != null : "fx:id=\"choose_group\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert choose_semester != null : "fx:id=\"choose_semester\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert consolidated_table != null : "fx:id=\"consolidated_table\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert departments != null : "fx:id=\"departments\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert faculties != null : "fx:id=\"faculties\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert general_table_button != null : "fx:id=\"general_table_button\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert not_inputed_data != null : "fx:id=\"not_inputed_data\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert schedule != null : "fx:id=\"schedule\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert students_with_unsatisfying_results != null : "fx:id=\"students_with_unsatisfying_results\" was not injected: check your FXML file 'module_results_preview.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'module_results_preview.fxml'.";

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
