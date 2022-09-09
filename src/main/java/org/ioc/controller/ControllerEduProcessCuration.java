package org.ioc.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ioc.DataBase.DB_EduProcess;
import org.ioc.Main;
import org.ioc.models.Table_Edu;
import org.ioc.models.Table_Search_D;
import org.ioc.models.Table_Student;
import org.ioc.models.Table_disc_mark;

import static org.ioc.DataBase.DB_EduProcess.Disc;

public class ControllerEduProcessCuration {
    @FXML
    private Button Button_Add_D;

    @FXML
    private Button Button_Diversity_For_Group;

    @FXML
    private Button Button_Remove_Discipline;

    @FXML
    private Button Button_Remove_For_Group;

    @FXML
    private Button Del_expansion;

    @FXML
    private ChoiceBox<String> GroupChoice;

    @FXML
    private TableColumn<?, ?> KP_column;

    @FXML
    private TableColumn<?, ?> KR_column;

    @FXML
    private TableColumn<?, ?> NumberOfDiscipline;

    @FXML
    private TableColumn<?, ?> NumberOfKafedra;

    @FXML
    private TableView<Table_disc_mark> Progress_Table;

    @FXML
    private TableColumn<?, ?> RGR_column;

    @FXML
    private TextField Search_Box;

    @FXML
    private TableView<Table_Student> Student_Table;

    @FXML
    private TableColumn<?, ?> Student_column;

    @FXML
    private TableView<Table_Search_D> TableV_Search_D;

    @FXML
    private TableView<Table_Edu> TableView_Disc;

    @FXML
    private TableColumn<String, Table_Search_D> Table_C_Search_D;

    @FXML
    private ChoiceBox<String> choose_session;

    @FXML
    private Button diversity_expansion;

    @FXML
    private Button AddToBase;

    @FXML
    private TableColumn<?, ?> ekz_column;

    @FXML
    private TableColumn<?, ?> hour_column;

    @FXML
    private ComboBox<String> performance_choose_group;

    @FXML
    private TableColumn<?, ?> plan_table_Df_Zalik;

    @FXML
    private TableColumn<?, ?> plan_table_RGR;

    @FXML
    private TableColumn<?, ?> plan_table_Zalik;

    @FXML
    private TableColumn<?, ?> plan_table_course_project;

    @FXML
    private TableColumn<?, ?> plan_table_course_work;

    @FXML
    private TableColumn<?, ?> plan_table_discipline;

    @FXML
    private TableColumn<?, ?> plan_table_exam;

    @FXML
    private TableColumn<?, ?> plan_table_hours;

    @FXML
    private TableColumn<Table_disc_mark, String> pred_column;

    @FXML
    private TableColumn<?, ?> semestr_column;

    @FXML
    private TableColumn<?, ?> zal_column;

    @FXML
    private Button Save;


    public static String GroupName;
    public static String GroupID;
    public static String NameOfDisc_SQL;



    public static String IdFaculty;
    public static String IdEduProgram;
    public static String Student_FO;
    public static String NumberOfSemester;
    public static String DisciplineIdSql;
    public static String Hours;
    public static String Test;
    public static String Exam;
    public static String CGW;
    public static String CGW_1;
    public static String CGW_2;
    public static String CGW_3;
    public static String CGW_4;
    public static String CGW_5;
    public static String CGW_6;
    public static String CW;
    public static String CP;
    public static String Dif_Test;
    public static String Uni_cod;
    public static String Kafedra;
    public static String IdSpec;





    @FXML
    void initialize() {

        plan_table_discipline.setCellValueFactory(new PropertyValueFactory<>("NameOfDiscipline"));
        plan_table_hours.setCellValueFactory(new PropertyValueFactory<>("HH"));
        plan_table_Zalik.setCellValueFactory(new PropertyValueFactory<>("Zalik"));
        plan_table_exam.setCellValueFactory(new PropertyValueFactory<>("Exam"));
        plan_table_RGR.setCellValueFactory(new PropertyValueFactory<>("RGR"));
        plan_table_course_work.setCellValueFactory(new PropertyValueFactory<>("KR"));
        plan_table_course_project.setCellValueFactory(new PropertyValueFactory<>("KP"));
        plan_table_Df_Zalik.setCellValueFactory(new PropertyValueFactory<>("D_Zalik"));
        NumberOfKafedra.setCellValueFactory(new PropertyValueFactory<>("KF"));
        NumberOfDiscipline.setCellValueFactory(new PropertyValueFactory<>("NumberOfDiscipline"));
        ObservableList<Table_Edu> EduUp = FXCollections.observableArrayList();

        DB_EduProcess db = new DB_EduProcess();

        ResultSet GroupOFStudent = db.GroupName_SQL();
        List<String> nameGroup = new ArrayList<>();
        ObservableList<String> name_Group_OL = FXCollections.observableArrayList();
        getInfo(nameGroup, GroupOFStudent, "FullNameOfGroup", "GroupId");
        for (String s : nameGroup){
            name_Group_OL.add(s.split(";")[0]);
        }
        performance_choose_group.setItems(name_Group_OL);






        choose_session.setItems(FXCollections.observableArrayList("Зимова", "Літня"));
        choose_session.setValue("Зимова");


        ResultSet Discipline = Disc();
        List<String> TitleDisc = new ArrayList<>();
        ObservableList<Table_Search_D> TitleDisc_OL = FXCollections.observableArrayList();
        getInfo(TitleDisc, Discipline, "NameOfDiscipline_ukr");
        for (String s: TitleDisc){
            TitleDisc_OL.add(new Table_Search_D(s));
        }
        Table_C_Search_D.setCellValueFactory(new PropertyValueFactory<>("NameOfDisc"));
        TableV_Search_D.setItems(TitleDisc_OL);

        FilteredList<Table_Search_D> Filter = new FilteredList<>(TitleDisc_OL, b -> true);
        Search_Box.textProperty().addListener((observable, oldValue, newValue) -> Filter.setPredicate(Model_Table_Search_D -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String LowerCase = newValue.toLowerCase();
            return Model_Table_Search_D.getNameOfDisc().toLowerCase().contains(LowerCase);
        }));

        SortedList<Table_Search_D> sortedData = new SortedList<>(Filter);
        sortedData.comparatorProperty().bind(TableV_Search_D.comparatorProperty());
        TableV_Search_D.setItems(sortedData);




        Button_Add_D.setOnAction(actionEvent -> {
            EduUp.add(new Table_Edu((TableV_Search_D.getItems().get(TableV_Search_D.getSelectionModel().getFocusedIndex()).getNameOfDisc()).replace("'", "`")));
            EduUp.get(EduUp.size() - 1).setNumberOfDiscipline(String.valueOf(EduUp.size()));
            TableView_Disc.setItems(EduUp);
        });

        performance_choose_group.setOnAction(actionEvent ->{
            EduUp.clear();
            TableView_Disc.setItems(EduUp);
            TableView_Disc.refresh();
            getSemester();
            getGroup();
            List<String> StudentFO = new ArrayList<>();
            ResultSet StudentFO_rs = DB_EduProcess.StudentsIDFO();
            getInfo(StudentFO, StudentFO_rs, "IdFO");
            List<String> EduPlan = new ArrayList<>();

            Student_FO = StudentFO.get(0);
            ResultSet EduPlan_rs = db.StudentsEdu();
            GetEduPlan(EduPlan, EduPlan_rs, "NameOfDiscipline_ukr", "Hours", "Exam", "Test",
                    "DifferentiatedTest", "Coursework", "CourseProject",
                    "CalculationGraphicWork_4", "CalculationGraphicWork_6", "NumberOfDepartment");


            for (String s : EduPlan){
                EduUp.add(new Table_Edu(s.split(";")[0]));
            }
            TableView_Disc.setItems(EduUp);

            for (Table_Edu s : TableView_Disc.getItems()){
                for (String n : EduPlan){
                    if (Objects.equals(s.getNameOfDiscipline(), n.split(";")[0])){
                        s.setNumberOfDiscipline(n.split(";")[9]);
                        s.HH.setText(n.split(";")[1]);
                        s.Exam.setSelected(Boolean.parseBoolean(n.split(";")[2]));
                        s.Zalik.setSelected(Boolean.parseBoolean(n.split(";")[3]));
                        s.D_Zalik.setSelected(Boolean.parseBoolean(n.split(";")[4]));
                        s.KR.setSelected(Boolean.parseBoolean(n.split(";")[5]));
                        s.KP.setSelected(Boolean.parseBoolean(n.split(";")[6]));
                        s.RGR.setValue(n.split(";")[7]);
                        s.KF.setText(n.split(";")[8]);
                    }
                }
            }
            TableView_Disc.refresh();

        });

        choose_session.setOnAction(actionEvent -> {
            //EduUp.removeAll();
            EduUp.clear();
            TableView_Disc.setItems(EduUp);
            TableView_Disc.refresh();
            getSemester();
            getGroup();

            List<String> StudentFO = new ArrayList<>();
            ResultSet StudentFO_rs = DB_EduProcess.StudentsIDFO();
            getInfo(StudentFO, StudentFO_rs, "IdFO");
            List<String> EduPlan = new ArrayList<>();

            Student_FO = StudentFO.get(0);
            ResultSet EduPlan_rs = db.StudentsEdu();
            GetEduPlan(EduPlan, EduPlan_rs, "NameOfDiscipline_ukr", "Hours", "Exam", "Test",
                    "DifferentiatedTest", "Coursework", "CourseProject",
                    "CalculationGraphicWork_4", "CalculationGraphicWork_6", "NumberOfDepartment");

            for (String s : EduPlan){
                System.out.println(s);
            }

            for (String s : EduPlan){
                EduUp.add(new Table_Edu(s.split(";")[0]));
            }
            TableView_Disc.setItems(EduUp);

            for (Table_Edu s : TableView_Disc.getItems()){
                for (String n : EduPlan){
                    if (Objects.equals(s.getNameOfDiscipline(), n.split(";")[0])){
                        s.setNumberOfDiscipline(n.split(";")[9]);
                        s.HH.setText(n.split(";")[1]);
                        s.Exam.setSelected(Boolean.parseBoolean(n.split(";")[2]));
                        s.Zalik.setSelected(Boolean.parseBoolean(n.split(";")[3]));
                        s.D_Zalik.setSelected(Boolean.parseBoolean(n.split(";")[4]));
                        s.KR.setSelected(Boolean.parseBoolean(n.split(";")[5]));
                        s.KP.setSelected(Boolean.parseBoolean(n.split(";")[6]));
                        s.RGR.setValue(n.split(";")[7]);
                        s.KF.setText(n.split(";")[8]);
                    }
                }
            }
            TableView_Disc.refresh();
        });

        Button_Remove_For_Group.setOnAction(actionEvent ->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ви впевнені?");
            alert.setHeaderText("Ви впевнені, що бажаєте видалити \nдисципліну для усієї групи?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent()){
                if (result.get() == ButtonType.OK){
                    List<String> DiscIdForSql = new LinkedList<>();
                    List<String> IdFo = new ArrayList<>();
                    ResultSet IdFo_rs = DB_EduProcess.StudentsIDFO();
                    getInfo(IdFo, IdFo_rs, "IdFO");
                    for (String s : IdFo){
                        Student_FO = s;
                        for (Table_Edu Edu : EduUp) {
                            NameOfDisc_SQL = Edu.getNameOfDiscipline();
                            ResultSet IdOfDisc = DB_EduProcess.DiscID();
                            try {
                                if (!IdOfDisc.next()) break;
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            String str11 = null;
                            try {
                                str11 = IdOfDisc.getString("DisciplineId");
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            DiscIdForSql.add(0, str11);
                            DisciplineIdSql = DiscIdForSql.get(0);
                            System.out.println(Student_FO);
                            System.out.println(NumberOfSemester);
                            System.out.println(DisciplineIdSql);
                            DB_EduProcess.InsertIntoTable();
                            DB_EduProcess.DeleteIntoTable();
                            TableView_Disc.refresh();
                        }
                    }
                    EduUp.clear();
                    TableView_Disc.setItems(EduUp);
                }else System.out.println("Відміна");

            }

        });

        Button_Diversity_For_Group.setOnAction(ActionEvent -> EduPlanToDB());

        Del_expansion.setOnAction(actionEvent ->{

        });
        diversity_expansion.setOnAction(actionEvent ->{

        });

        Button_Remove_Discipline.setOnAction(actionEvent -> {
            ObservableList<Table_Edu> Disc = TableView_Disc.getItems();
            Disc.remove(TableView_Disc.getSelectionModel().getFocusedIndex());
            TableView_Disc.refresh();
        });

        AddToBase.setOnAction(actionEvent -> {
            Stage stage = new Stage();
            stage.setTitle("");
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui/AddDiscipline.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 470, 234);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        });


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///                                               Успішність                                                 ///
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        GroupChoice.setItems(name_Group_OL);


        Student_column.setCellValueFactory(new PropertyValueFactory<>("name"));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Student_Table.setEditable(true);
        pred_column.setCellValueFactory(new PropertyValueFactory<>("disc"));
        pred_column.setEditable(true);
        pred_column.setOnEditCommit(event -> {
            alert.showAndWait();
        });
        semestr_column.setCellValueFactory(new PropertyValueFactory<>("sem"));
        hour_column.setCellValueFactory(new PropertyValueFactory<>("hh"));
        zal_column.setCellValueFactory(new PropertyValueFactory<>("zal"));
        ekz_column.setCellValueFactory(new PropertyValueFactory<>("ekz"));
        KR_column.setCellValueFactory(new PropertyValueFactory<>("kr"));
        KP_column.setCellValueFactory(new PropertyValueFactory<>("kp"));
        RGR_column.setCellValueFactory(new PropertyValueFactory<>("rgr"));



        GroupChoice.setOnAction(actionEvent->{
            getGroupUsp();
            List<String> StudentPIB = new ArrayList<>();
            ResultSet StudentPIB_rs = DB_EduProcess.StudentsPIB();
            getInfo(StudentPIB, StudentPIB_rs, "LastName_ukr", "FirstName_ukr", "Surname_ukr", "IdFO");
            ObservableList<Table_Student> students = FXCollections.observableArrayList();
            for (String s : StudentPIB){
                students.add(new Table_Student(s.split(";")[0]));
            }
            Student_Table.setItems(students);
        });

        Student_Table.setOnMouseClicked(MouseEvent -> {
            List<String> StudentPIB = new ArrayList<>();
            ResultSet StudentPIB_rs = DB_EduProcess.StudentsPIB();
            getInfo(StudentPIB, StudentPIB_rs, "LastName_ukr", "FirstName_ukr", "Surname_ukr", "IdFO");
            ObservableList<Table_Student> students = FXCollections.observableArrayList();
            for (String s : StudentPIB){
                if (Objects.equals(s.split(";")[0], Student_Table.getItems().get(Student_Table.getSelectionModel().getFocusedIndex()).getName())){
                    Student_FO = s.split(";")[1];
                }
            }

            System.out.println(Student_Table.getItems().get(Student_Table.getSelectionModel().getFocusedIndex()).getName());
            ResultSet all_discipline = DB_EduProcess.get_all_discipline();
            ObservableList<Table_disc_mark> all_discipline_OL = FXCollections.observableArrayList();
            getInfoUsp(all_discipline_OL, all_discipline);

            Progress_Table.setItems(all_discipline_OL);
        });

        Save.setOnAction(actionEvent -> {
            System.out.println("h");
            List<String> list = new LinkedList<>();
            for (Table_disc_mark s: Progress_Table.getItems()){
                NameOfDisc_SQL = s.getDisc();
                System.out.println(NameOfDisc_SQL);
                ResultSet rs = DB_EduProcess.DiscID();
                getInfo(list, rs, "DisciplineId");
                System.out.println(list.get(0));


            }





        });





    }


    public void GetEduPlan(List<String> get_edu_plan, ResultSet rs, String temp1, String temp2, String temp3,
                           String temp4, String temp5, String temp6, String temp7, String temp8, String temp9, String temp10){

        int number = 0;
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String name_1 = null;
            String name_2 = null;
            String name_3 = null;
            String name_4 = null;
            String name_5 = null;
            String name_6 = null;
            String name_7 = null;
            String name_8 = null;
            String name_9;
            String name_10 = null;
            try {
                name_1 = rs.getString(temp1);
                name_2 = rs.getString(temp2);
                name_3 = rs.getString(temp3);
                if (Objects.equals(name_3, "false")){
                    System.out.println(false);
                } else name_3 = "true";
                name_4 = rs.getString(temp4);
                if (Objects.equals(name_4, "false")){
                    System.out.println(false);
                } else name_4 = "true";
                name_5 = rs.getString(temp5);
                if (Objects.equals(name_5, "false")){
                    System.out.println(false);
                } else name_5 = "true";
                name_6 = rs.getString(temp6);
                if (Objects.equals(name_6, "false")){
                    System.out.println(false);
                } else name_6 = "true";
                name_7 = rs.getString(temp7);
                if (Objects.equals(name_7, "false")){
                    System.out.println(false);
                } else name_7 = "true";
                name_8 = rs.getString(temp8);
                name_9 = rs.getString(temp9);
                name_10 = rs.getString(temp10);

                if (Objects.equals(name_9, "false")) {
                    System.out.println("ne 6");
                    if (Objects.equals(name_8, "false")) {
                        System.out.println("ne 4");
                        name_8 = "-";
                    } else name_8 = "4";
                } else name_8 = "6";

                name_10 = rs.getString(temp10);
            } catch (SQLException e){
                e.printStackTrace();
            }
            number++;
            get_edu_plan.add(name_1+";"+name_2+";"+name_3+";"+name_4+";"+name_5+";"+name_6+";"+name_7+";"+name_8+";"+name_10+";"+number);
        }
    }

    public void EduPlanToDB(){
        DB_EduProcess db = new DB_EduProcess();
        ObservableList<Table_Edu> Disc = TableView_Disc.getItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ви впевнені?");
        alert.setHeaderText("Ви впевнені, що бажаєте рознести \nдисципліни для усієї групи?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                if (!(Disc.size() == 0) && !Objects.equals(performance_choose_group.getValue(), null)) {
                    List<String> IdOfEduProgram = new ArrayList<>();
                    ResultSet IdOfEduProgram_rs = db.EduProgram();
                    getInfo(IdOfEduProgram, IdOfEduProgram_rs, "IdOfEducationalProgram");
                    System.out.println(IdOfEduProgram.size());
                    IdEduProgram = IdOfEduProgram.get(0);
                    List<String> IdOfSpec = new ArrayList<>();
                    ResultSet IdOfSpec_rs = db.Spec_ID_For_Edu();
                    getInfo(IdOfSpec, IdOfSpec_rs, "IdOfSpeciality");
                    IdSpec = IdOfSpec.get(0);
                    List<String> FacultyId = new ArrayList<>();
                    ResultSet FacultyId_rs = db.FacultyID();
                    getInfo(FacultyId, FacultyId_rs, "FacultyID");
                    IdFaculty = FacultyId.get(0);

                    List<String> Students = new ArrayList<>();
                    ResultSet Students_rs = DB_EduProcess.StudentsIDFO();
                    getInfo(Students, Students_rs, "IdFO");
                    for (String s : Students){
                        Student_FO = s;
                        for (Table_Edu Edu : Disc){
                            NameOfDisc_SQL = Edu.getNameOfDiscipline();
                            List<String> DiscId = new ArrayList<>();
                            ResultSet DiscId_rs = DB_EduProcess.DiscID();
                            getInfo(DiscId, DiscId_rs, "DisciplineId");
                            DisciplineIdSql = DiscId.get(0);

                            Hours = Edu.getHH().getText();
                            Kafedra = Edu.getKF().getText();
                            if (String.valueOf(Edu.getZalik().isSelected()).equals("true")) {
                                Test = "0";
                            } else Test = "false";

                            if (String.valueOf(Edu.getExam().isSelected()).equals("true")) {
                                Exam = "0";
                            } else Exam = "false";

                            CGW = String.valueOf(Edu.getRGR().getValue());
                            if (!Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")) {
                                if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "4")) {
                                    CGW = "0";
                                    CGW_1 = "0";
                                    CGW_2 = "0";
                                    CGW_3 = "0";
                                    CGW_4 = "0";

                                } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "6")) {
                                    CGW = "0";
                                    CGW_1 = "0";
                                    CGW_2 = "0";
                                    CGW_3 = "0";
                                    CGW_4 = "0";
                                    CGW_5 = "0";
                                    CGW_6 = "0";

                                }
                            } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")) {
                                CGW = "false";
                            }

                            if (String.valueOf(Edu.getKR().isSelected()).equals("true")) {
                                CW = "0";
                            } else CW = "false";


                            if (String.valueOf(Edu.getKP().isSelected()).equals("true")) {
                                CP = "0";
                            } else CP = "false";


                            if (String.valueOf(Edu.getD_Zalik().isSelected()).equals("true")) {
                                Dif_Test = "0";
                            } else Dif_Test = "false";
                            getSemester();
                            Uni_cod = IdFaculty + "-" + IdEduProgram + "-" + NumberOfSemester + "-" + DisciplineIdSql + "-" + Student_FO; //Для забезпечення бездубляжного додавання

                            if (!Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")) {
                                if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "4")) {
                                    DB_EduProcess.Study_plan_Insert_four_RGR();
                                } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "6")) {
                                    try {
                                        DB_EduProcess.Study_plan_Insert_six_RGR();
                                    } catch (SQLException | IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            } else if (Objects.equals(String.valueOf(Edu.getRGR().getValue()), "-")) {
                                DB_EduProcess.Study_plan_Insert_null_RGR();
                            }
                        }
                    }
                }
            }
        }

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

    public void getInfo(List<String> list, ResultSet rs , String NameColumn_1, String NameColumn_2){
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String str = null;
            String str2 = null;
            try {
                str = rs.getString(NameColumn_1);
                str2 = rs.getString(NameColumn_2);
            } catch (SQLException e){
                e.printStackTrace();
            }
            list.add(str+";"+str2);
        }
    }

    public void getInfo(List<String> list, ResultSet rs , String NameColumn_1, String NameColumn_2, String NameColumn_3, String NameColumn_4){
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            try {
                str = rs.getString(NameColumn_1);
                str2 = rs.getString(NameColumn_2);
                str3 = rs.getString(NameColumn_3);
                str4 = rs.getString(NameColumn_4);
            } catch (SQLException e){
                e.printStackTrace();
            }

            assert str2 != null;
            assert str3 != null;
            list.add(str+" "+str2.charAt(0)+". "+str3.charAt(0) + "." + ";"+str4);
        }
    }

    public void getInfoUsp(ObservableList<Table_disc_mark> list, ResultSet rs){
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                list.add(new Table_disc_mark(rs.getString(1), rs.getString(2),new TextField(rs.getString(3)) ,new TextField(rs.getString(4)) ,new TextField(rs.getString(5)) , new TextField(rs.getString(6)) , new TextField(rs.getString(7)), new TextField(rs.getString(8))));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void getSemester(){
        if (!Objects.equals(performance_choose_group.getValue(), "")){
            if (Objects.equals(choose_session.getValue(), "Зимова")){
                NumberOfSemester = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("_")[1]) * 2 - 1);
            } else if (Objects.equals(choose_session.getValue(), "Літня")) {
                NumberOfSemester = String.valueOf(Integer.parseInt(performance_choose_group.getValue().split("_")[1]) * 2);
            }
            System.out.println(NumberOfSemester);
        }
    }

    public void getGroup(){
        if (!Objects.equals(performance_choose_group.getValue(), "")){
            GroupName = performance_choose_group.getValue();
        }
        List<String> group_name = new ArrayList<>();
        ResultSet group_name_rs = DB_EduProcess.GetGroup();
        getInfo(group_name, group_name_rs, "GroupId");
        GroupID = group_name.get(0);
    }
    public void getGroupUsp(){
        if (!Objects.equals(GroupChoice.getValue(), "")){
            GroupName = GroupChoice.getValue();
        }
        List<String> group_name = new ArrayList<>();
        ResultSet group_name_rs = DB_EduProcess.GetGroup();
        getInfo(group_name, group_name_rs, "GroupId");
        GroupID = group_name.get(0);
    }

    public void SaveUsp(){

    }
}
