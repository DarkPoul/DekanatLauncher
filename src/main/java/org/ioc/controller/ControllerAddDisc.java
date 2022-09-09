package org.ioc.controller;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import org.ioc.DataBase.DB_AddDisc;

public class ControllerAddDisc {

    @FXML
    private TextField FullNameOfDisc;

    @FXML
    private TextField NumberOfDepartment;

    @FXML
    private Button Save;

    @FXML
    private TextField ShortNameOfDisc;

    @FXML
    private TextField TranslateDisc;

    @FXML
    void initialize() {

        NumberOfDepartment.setBorder(Border.stroke(Paint.valueOf("Gray")));
        ShortNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Gray")));
        FullNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Gray")));
        TranslateDisc.setBorder(Border.stroke(Paint.valueOf("Gray")));



        NumberOfDepartment.setOnMouseClicked(mouseEvent -> NumberOfDepartment.setBorder(Border.stroke(Paint.valueOf("Gray"))));
        ShortNameOfDisc.setOnMouseClicked(mouseEvent -> ShortNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Gray"))));
        FullNameOfDisc.setOnMouseClicked(mouseEvent -> FullNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Gray"))));

        Save.setOnAction(actionEvent -> {
            System.out.println(FullNameOfDisc.getText());
            if ((!Objects.equals(FullNameOfDisc.getText(), "")) && (!Objects.equals(NumberOfDepartment.getText(), "")) && (!Objects.equals(ShortNameOfDisc.getText(), ""))){
                DB_AddDisc db = new DB_AddDisc();
                if (!Objects.equals(TranslateDisc.getText(), "")){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Внесення даних");
                    alert.setHeaderText("Ви впевнені що бажаєте внести дисципліну?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent()){
                        if (result.get() == ButtonType.OK){
                            db.AddDisc(NumberOfDepartment.getText(), ShortNameOfDisc.getText(), FullNameOfDisc.getText(), TranslateDisc.getText());
                        } else System.out.println("Відміна");
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Внесення даних");
                    alert.setHeaderText("Ви впевнені що бажаєте внести дисципліну?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent()){
                        if (Objects.equals(NumberOfDepartment.getText(), "")){
                            NumberOfDepartment.setBorder(Border.stroke(Paint.valueOf("Red")));
                        }
                        if (Objects.equals(ShortNameOfDisc.getText(), "")){
                            ShortNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Red")));
                        }
                        if (Objects.equals(FullNameOfDisc.getText(), "")){
                            FullNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Red")));
                        }
                        if (result.get() == ButtonType.OK){
                            System.out.println(NumberOfDepartment.getText());
                            System.out.println(ShortNameOfDisc.getText());
                            System.out.println(FullNameOfDisc.getText());
                            db.AddDisc(NumberOfDepartment.getText(), ShortNameOfDisc.getText(), FullNameOfDisc.getText());

                        } else System.out.println("Відміна");
                    }
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Помилка!");
                alert.setHeaderText("Введені не всі данні.\nПеревірте та спробуйте ще раз");
                alert.showAndWait();
                if (Objects.equals(NumberOfDepartment.getText(), "")){
                    NumberOfDepartment.setBorder(Border.stroke(Paint.valueOf("Red")));
                }
                if (Objects.equals(ShortNameOfDisc.getText(), "")){
                    ShortNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Red")));
                }
                if (Objects.equals(FullNameOfDisc.getText(), "")){
                    FullNameOfDisc.setBorder(Border.stroke(Paint.valueOf("Red")));
                }
            }
        });
    }



}
