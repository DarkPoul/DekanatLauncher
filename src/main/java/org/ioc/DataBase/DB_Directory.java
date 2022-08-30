package org.ioc.DataBase;

import java.io.IOException;
import java.sql.*;

public class DB_Directory {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";
        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public ResultSet Directory_Info_Department() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT DepartmentId, NameOfDepartment FROM Department";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet Directory_Info_Faculty() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet2 = null;
        String query = "SELECT NameOfFaculty, AbriviaturaOfFaculty_ukr FROM Faculty";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt2 = getConnection().prepareStatement(query);
            resultSet2 = prSt2.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet2;
    }

    public ResultSet Directory_Info_Discipline() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT DepartmentId, DisciplineId, NameOfDiscipline_ukr FROM Discipline";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet Directory_Info_Speciality() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT KodOfSpeciality, NameOfSpeciality FROM Speciality";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet Directory_Info_Education() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfEducationalProgram, ShortNameOfEducationalProgram, Qualification FROM EducationalProgram";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
