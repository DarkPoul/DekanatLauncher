package org.ioc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ioc.DataBase.DB_EduProcessAdd;
import org.ioc.models.Table_Edu_Advanced_Student;

import java.sql.ResultSet;

public class ControllerEduCurationAdd {

    @FXML
    private Button Button_SelectAllDisc;

    @FXML
    private Button Button_SelectAllStudent;

    @FXML
    private TableView<?> ListOfDisc_Advanced;

    @FXML
    private TableView<Table_Edu_Advanced_Student> ListOfStudent_Advanced;

    @FXML
    private TableColumn<?, ?> TableColumn_CheckBox_Disc;

    @FXML
    private TableColumn<Table_Edu_Advanced_Student, CheckBox> TableColumn_CheckBox_Student;

    @FXML
    private TableColumn<?, ?> TableColumn_ListOfDisc;

    @FXML
    private TableColumn<Table_Edu_Advanced_Student, String> TableColumn_ListOfStudent;

    @FXML
    void divers(ActionEvent event) {

    }

    @FXML
    void initialize() {
        TableColumn_CheckBox_Student.setCellValueFactory(new PropertyValueFactory<>("Student_Check"));
        TableColumn_ListOfStudent.setCellValueFactory(new PropertyValueFactory<>("Student_String"));

        TableColumn_CheckBox_Disc.setCellValueFactory(new PropertyValueFactory<>("Disc_CheckBox"));
        TableColumn_ListOfDisc.setCellValueFactory(new PropertyValueFactory<>("Disc_String"));

        DB_EduProcessAdd db = new DB_EduProcessAdd();
        ResultSet rs = DB_EduProcessAdd.StudentsPIB();


    }

}

