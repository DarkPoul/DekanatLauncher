package org.ioc.DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import static org.ioc.controller.ControllerAddStudent.*;

public class DB_AddStudent {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";
        return DriverManager.getConnection(url, open_Login, open_Password);
    }

//    public void AddStudent() {
//        String query = "INSERT INTO AnketaOfStudents VALUES " + ID_FO +  ", " + sur_name_ukr + ", " + sur_name_eng
//                + "," + name_ukr +  "," + name_eng +  "," + father_ukr +  ","
//                + father_eng +  "," + name_ukr +  "," + professional_direction + ", " +
//                group + "," + year + "," + zalik_book + ", " +
//                ident + ", " + date_birth + ", " + nationality_student +
//                ", " + sex + ", " + marital + ", " + pass_ser + ", " +
//                pass_nam + ", " + pass_date + ", " + formStudy +
//                ", " + Osv_stupin + ", " + index + ", " + Oblast +
//                ", " + address + ", " + cost + ";";//SQL запит на отримання інформації
//
//        try {
//            PreparedStatement prSt = getConnection().prepareStatement(query);
//            prSt.executeUpdate();
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
