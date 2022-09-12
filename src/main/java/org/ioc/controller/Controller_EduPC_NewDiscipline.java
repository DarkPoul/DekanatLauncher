package org.ioc.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.ioc.models.Table_Search_D;
import org.ioc.models.Table_disc_mark;

import static org.ioc.DataBase.DB_EduProcess.Disc;

public class Controller_EduPC_NewDiscipline {

    public static String newName;

    @FXML
    private TextField NewName;

    @FXML
    private TableColumn<Table_Search_D, String> TableColumnNewName;

    @FXML
    private TableView<Table_Search_D> TableViewNewName;

    @FXML
    void initialize() {
        ResultSet Discipline = Disc();
        List<String> TitleDisc = new ArrayList<>();
        ObservableList<Table_Search_D> TitleDisc_OL = FXCollections.observableArrayList();
        getInfo(TitleDisc, Discipline, "NameOfDiscipline_ukr");
        for (String s: TitleDisc){
            TitleDisc_OL.add(new Table_Search_D(s));
        }
        TableColumnNewName.setCellValueFactory(new PropertyValueFactory<>("NameOfDisc"));
        TableViewNewName.setItems(TitleDisc_OL);

        FilteredList<Table_Search_D> Filter = new FilteredList<>(TitleDisc_OL, b -> true);
        NewName.textProperty().addListener((observable, oldValue, newValue) -> Filter.setPredicate(Model_Table_Search_D -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String LowerCase = newValue.toLowerCase();
            return Model_Table_Search_D.getNameOfDisc().toLowerCase().contains(LowerCase);
        }));

        SortedList<Table_Search_D> sortedData = new SortedList<>(Filter);
        sortedData.comparatorProperty().bind(TableViewNewName.comparatorProperty());
        TableViewNewName.setItems(sortedData);



    }

    public void getInfo(List<String> list, ResultSet rs , String NameColumn){
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String str = null;
            try {
                str = rs.getString(NameColumn);
            } catch (SQLException e){
                e.printStackTrace();
            }
            list.add(str);
        }
    }

    @FXML
    public void GetItem(MouseEvent event){
        if (event.getClickCount() == 2){
            NewName.setText(TableViewNewName.getItems().get(TableViewNewName.getSelectionModel().getFocusedIndex()).getNameOfDisc());
        }
    }

    public void ChangeDisc(ActionEvent event) {
        if (!Objects.equals(NewName.getText(), "")){
            newName = NewName.getText();
            Close_window();
        }
    }

    public void Close_window(){
        Stage close_window = (Stage) NewName.getScene().getWindow();
        close_window.close();
    }
}
