package org.ioc.DataBase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import static org.ioc.controller.ControllerApp.Id_User;
import static org.ioc.controller.ControllerEduProcessCuration.*;

public class DB_EduProcess {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";

        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public ResultSet GroupName_SQL() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT FullNameOfGroup, GroupId FROM GroupOfStudents WHERE GroupId > '1' ORDER BY NameOfGroup";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet Disc() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfDiscipline_ukr FROM Discipline";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet GetGroup() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT GroupId FROM GroupOfStudents where FullNameOfGroup ='" + GroupName + "';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet StudentsIDFO() {
        ResultSet resultSet = null;
        String query = "SELECT IdFO FROM AnketaOfStudents where GroupID = '" + GroupID + "';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet StudentsPIB() {
        ResultSet resultSet = null;
        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + GroupID + "';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet StudentsEdu() {
        ResultSet resultSet = null;
        String query = "SELECT NameOfDiscipline_ukr, Hours, Exam, Test, DifferentiatedTest, Coursework, CourseProject, CalculationGraphicWork_4, CalculationGraphicWork_6, NumberOfDepartment FROM EducationalPlan, Discipline where IdOfStudent = '" + Student_FO +"' and NumberOfSemester ='" + NumberOfSemester + "'and Discipline.DisciplineId = EducationalPlan.DisciplineId";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet EduProgram() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT IdOfEducationalProgram FROM GroupOfStudents WHERE GroupId = '" + GroupID + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet Spec_ID_For_Edu() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT IdOfSpeciality FROM EducationalProgram WHERE EducationalProgramId = '" + IdEduProgram + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public ResultSet FacultyID() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT FacultyID FROM Speciality WHERE SpecialityId = '" + IdSpec + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
//
    public static ResultSet DiscID() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT DisciplineId FROM Discipline WHERE NameOfDiscipline_ukr = '" + NameOfDisc_SQL + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
//
    public static void Study_plan_Insert_null_RGR() {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + Student_FO + "', '" + NumberOfSemester + "', '" + DisciplineIdSql + "', '" +
                Hours + "', '" + Test + "', '" + Exam + "', '" + CGW + "', '" + CW + "', '" + CP + "', '" + Dif_Test + "', '"+ Uni_cod +"', '" + Kafedra + "')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
    //
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 4 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Study_plan_Insert_four_RGR() {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, " +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + Student_FO + "', '" + NumberOfSemester + "', '" + DisciplineIdSql + "', '" +
                Hours + "', '" + Test + "', '" + Exam + "', '" + CGW + "', '"+ CGW_1 +"', '" + CGW_2 +"', '"+ CGW_3 +
                "', '"+ CGW_4 +"', '" + CW + "', '" + CP + "', '" + Dif_Test + "', '"+ Uni_cod +"', '" + Kafedra + "')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 6 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Study_plan_Insert_six_RGR() throws SQLException, IOException {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + Student_FO + "', '" + NumberOfSemester + "', '" + DisciplineIdSql + "', '" +
                Hours + "', '" + Test + "', '" + Exam + "', '" + CGW + "', '"+ CGW_1 +"', '" + CGW_2 +"', '"+ CGW_3 +"', '"+ CGW_4 +"', '"+ CGW_5 +"', '"+ CGW_6 +"', '" + CW + "', '" + CP + "', '" + Dif_Test + "', '"+ Uni_cod +"', '" + Kafedra + "')";//SQL запит на отримання інформації
//        String query_2 = "UPDATE EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
//                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
//                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
//                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + StudentFO + "', '" + NumberOfSession + "', '" + DisciplineIdSql + "', '" +
//                Hours + "', '" + Test + "', '" + Exam + "', '" + CGW + "', '"+ CGW_1 +"', '" + CGW_2 +"', '"+ CGW_3 +"', '"+ CGW_4 +"', '"+ CGW_5 +"', '"+ CGW_6 +"', '" + CW + "', '" + CP + "', '" + Dif_Test + "', '"+ Uni_cod +"', '" + Kafedra + "')";//SQL запит на отримання інформації

        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
//            PreparedStatement prSt = getConnection().prepareStatement(query_2);
//            prSt.executeUpdate();
            throwables.printStackTrace();
        }
    }
//
    public static void InsertIntoTable() {
        String query = "insert into EducationalPlan_Delet select * from EducationalPlan where EducationalPlan.IdOfStudent = '" + Student_FO + "' and EducationalPlan.NumberOfSemester = '" + NumberOfSemester + "' and EducationalPlan.DisciplineId = '"+ DisciplineIdSql +"';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void DeleteIntoTable() {
        String query = "delete from EducationalPlan where EducationalPlan.IdOfStudent = '" + Student_FO + "' and EducationalPlan.NumberOfSemester = '" + NumberOfSemester + "' and EducationalPlan.DisciplineId = '"+ DisciplineIdSql +"';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
//
    public static ResultSet get_all_discipline(){
        ResultSet resultSet = null;
        String query = "Select Discipline.NameOfDiscipline_ukr, NumberOfSemester, Hours, Test, Exam, Coursework, CourseProject, CalculationGraphicWork from EducationalPlan, Discipline where EducationalPlan.DisciplineId = Discipline.DisciplineId and IdOfStudent = '" + Student_FO + "';";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
