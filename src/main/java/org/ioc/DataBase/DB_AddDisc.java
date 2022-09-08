package org.ioc.DataBase;

import org.apache.poi.hssf.record.StandardRecord;

import java.io.IOException;
import java.sql.*;

public class DB_AddDisc {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";
        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public void AddDisc(String D_I, String S_N, String N_D) {//Створення методу для отримання даних з бази даних
        String query = "INSERT INTO Discipline (DepartmentId, ShortNameOfDiscipline, NameOfDiscipline_ukr) Values (" + D_I + ", " + S_N + ", " + N_D + ");";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void AddDisc(String D_I, String S_N, String N_D, String N_D_eng) {//Створення методу для отримання даних з бази даних
        String query = "INSERT INTO Discipline (DepartmentId, ShortNameOfDiscipline, NameOfDiscipline_ukr, NameOfDiscipline_eng) Values (" + D_I + ", " + S_N + ", " + N_D + ", " + N_D_eng + ");";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
