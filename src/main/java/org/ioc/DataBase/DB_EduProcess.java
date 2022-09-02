package org.ioc.DataBase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import static org.ioc.controller.ControllerApp.Id_User;
import static org.ioc.controller.ControllerEduProcessCuration.*;

public class DB_EduProcess {
    public static void Open_DB() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//підключення драйверу
            try (Connection ignored = getConnection()){
                System.out.println("Connection to Store DB successfully!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";

        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public ResultSet GroupName_SQL() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfGroup, NumberOfCourse, NumberOfGroup, YearOfGroup, GroupId FROM GroupOfStudents WHERE GroupId > '1' ORDER BY NameOfGroup";//SQL запит на отримання інформації
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

    public ResultSet StudentsPIB() {
        ResultSet resultSet = null;
        String query = "SELECT LastName_ukr, FirstName_ukr, Surname_ukr, IdFO FROM AnketaOfStudents where GroupID = '" + GroupID + "' ORDER BY LastName_ukr";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet StudentsEdu() {
        ResultSet resultSet = null;
        String query = "SELECT NameOfDiscipline_ukr, Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6, Coursework, CourseProject, DifferentiatedTest, NumberOfDepartment FROM EducationalPlan, Discipline where IdOfStudent = '" + StudentFO +"' and NumberOfSemester ='" + NumberOfSession + "'and Discipline.DisciplineId = EducationalPlan.DisciplineId";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet EduProgramAndSpec() {//Створення методу для отримання даних з бази даних
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

    public ResultSet StudentsInGroup() {
        ResultSet resultSet = null;
        String query = "SELECT IdFO FROM Dekanat.AnketaOfStudents where GroupID = '" + GroupID + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet DiscID() {//Створення методу для отримання даних з бази даних
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

    public void Study_plan_Insert_null_RGR() {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + StudentFO + "', '" + NumberOfSession + "', '" + DisciplineIdSql + "', '" +
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
    public void Study_plan_Insert_four_RGR() {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, " +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + StudentFO + "', '" + NumberOfSession + "', '" + DisciplineIdSql + "', '" +
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
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /////////////               Запит на внесення навчального плану з 6 ргр у базу даних                ////////////////
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Study_plan_Insert_six_RGR() throws SQLException, IOException {
        String query = "INSERT INTO EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + StudentFO + "', '" + NumberOfSession + "', '" + DisciplineIdSql + "', '" +
                Hours + "', '" + Test + "', '" + Exam + "', '" + CGW + "', '"+ CGW_1 +"', '" + CGW_2 +"', '"+ CGW_3 +"', '"+ CGW_4 +"', '"+ CGW_5 +"', '"+ CGW_6 +"', '" + CW + "', '" + CP + "', '" + Dif_Test + "', '"+ Uni_cod +"', '" + Kafedra + "')";//SQL запит на отримання інформації
        String query_2 = "UPDATE EducationalPlan (FacultyId, EducationalProgramId, IdOfStudent, NumberOfSemester, DisciplineId, " +
                "Hours, Test, Exam, CalculationGraphicWork, CalculationGraphicWork_1, CalculationGraphicWork_2, CalculationGraphicWork_3, CalculationGraphicWork_4, CalculationGraphicWork_5, CalculationGraphicWork_6," +
                "Coursework, CourseProject, DifferentiatedTest, Uni_Cod, NumberOfDepartment)" +
                "VALUES ('" + IdFaculty + "', '" + IdEduProgram + "', '" + StudentFO + "', '" + NumberOfSession + "', '" + DisciplineIdSql + "', '" +
                Hours + "', '" + Test + "', '" + Exam + "', '" + CGW + "', '"+ CGW_1 +"', '" + CGW_2 +"', '"+ CGW_3 +"', '"+ CGW_4 +"', '"+ CGW_5 +"', '"+ CGW_6 +"', '" + CW + "', '" + CP + "', '" + Dif_Test + "', '"+ Uni_cod +"', '" + Kafedra + "')";//SQL запит на отримання інформації

        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            PreparedStatement prSt = getConnection().prepareStatement(query_2);
            prSt.executeUpdate();
            throwables.printStackTrace();
        }
    }

    public void InsertIntoTable() {
        String query = "insert into EducationalPlan_Delet select * from EducationalPlan where EducationalPlan.IdOfStudent = '" + StudentFO + "' and EducationalPlan.NumberOfSemester = '" + NumberOfSession + "' and EducationalPlan.DisciplineId = '"+ DisciplineIdSql +"';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteIntoTable() {
        String query = "delete from EducationalPlan where EducationalPlan.IdOfStudent = '" + StudentFO + "' and EducationalPlan.NumberOfSemester = '" + NumberOfSession + "' and EducationalPlan.DisciplineId = '"+ DisciplineIdSql +"';";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
