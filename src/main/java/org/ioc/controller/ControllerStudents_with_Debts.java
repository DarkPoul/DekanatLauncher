package org.ioc.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import org.ioc.App;

public class ControllerStudents_with_Debts {

    @FXML
    private ChoiceBox<?> choose_course;

    @FXML
    private ChoiceBox<?> choose_faculty;

    @FXML
    private ChoiceBox<?> choose_group;

    @FXML
    private ChoiceBox<?> choose_group_number;

    @FXML
    private TableColumn<?, ?> column_fatherName;

    @FXML
    private TableColumn<?, ?> column_name;

    @FXML
    private TableColumn<?, ?> column_surName;

    @FXML
    private TableColumn<?, ?> column_year;

    @FXML
    private Label number_of_debts;

    @FXML
    private Label students_with_debts;

    @FXML
    private TableColumn<?, ?> table_reasons;

    @FXML
    void initialize() {
        assert choose_course != null : "fx:id=\"choose_course\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert choose_faculty != null : "fx:id=\"choose_faculty\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert choose_group != null : "fx:id=\"choose_group\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert choose_group_number != null : "fx:id=\"choose_group_number\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_fatherName != null : "fx:id=\"column_fatherName\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_name != null : "fx:id=\"column_name\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_surName != null : "fx:id=\"column_surName\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert column_year != null : "fx:id=\"column_year\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert number_of_debts != null : "fx:id=\"number_of_debts\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert students_with_debts != null : "fx:id=\"students_with_debts\" was not injected: check your FXML file 'Students_with_debts.fxml'.";
        assert table_reasons != null : "fx:id=\"table_reasons\" was not injected: check your FXML file 'Students_with_debts.fxml'.";

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
