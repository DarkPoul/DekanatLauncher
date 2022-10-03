package org.ioc.DataBase;

import java.io.IOException;
import java.sql.*;

import static org.ioc.controller.ControllerEduProcessCuration.GroupID;

public class DB_EduProcessAdd {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";
        return DriverManager.getConnection(url, open_Login, open_Password);
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
}
