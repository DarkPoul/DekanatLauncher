package org.ioc.DataBase;

import java.io.IOException;
import java.sql.*;

import static org.ioc.controller.ControllerApp.Id_User;
import static org.ioc.controller.ControllerCreating_group.*;

public class DB_CreateGroupe {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";
        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public ResultSet SpecialityOfFaculty() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT SpecialityId, NameOfSpeciality FROM Speciality WHERE FacultyID = '" + Id_User + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet ShortNameOfGroup() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT ShortNameOfEducationalProgram FROM EducationalProgram WHERE Qualification = '" + DegreeName + "' and IdOfSpeciality = '" + N + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet FullNameAndIdOfGroup() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT NameOfEducationalProgram, EducationalProgramId FROM EducationalProgram WHERE ShortNameOfEducationalProgram = '" + GroupName_SQL + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void GroupInsert() {//Створення методу для отримання даних з бази даних
        String query = "INSERT INTO GroupOfStudents (FullNameOfGroup, NameOfGroup, NumberOfCourse, NumberOfGroup, YearOfGroup, " +
                "College, IdOfEducationalProgram)" +
                "VALUES ('" + GroupNameFull_SQL + "', '" + GroupName_SQL + "', '" + NumberOfCourse_SQL + "', '" + NumberOfGroup_SQL + "', '" + YearOfGroup_SQL + "', '" +
                College_SQL + "', '" + GroupID_SQL + "')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
