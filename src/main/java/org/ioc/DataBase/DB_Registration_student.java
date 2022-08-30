package org.ioc.DataBase;

import org.ioc.controller.ControllerRegistration_of_enrolled_students;

import java.io.IOException;
import java.sql.*;

public class DB_Registration_student {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://212.111.203.181/Dekanat";
        String open_Login = "admin";
        String open_Password = "Darkpoul@1";
        return DriverManager.getConnection(url, open_Login, open_Password);
    }

    public ResultSet Spec_ID() throws SQLException {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT SpecialityId FROM Speciality WHERE KodOfSpeciality = '" + ControllerRegistration_of_enrolled_students.Anketa_8_Name + "'";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        assert resultSet != null;
        return resultSet;
    }

    public void AnketaInsert() {//Створення методу для отримання даних з бази даних
        String query = "INSERT INTO AnketaOfStudents (IdFO, LastName_ukr, LastName_eng, FirstName_ukr, FirstName_eng, " +
                "Surname_ukr, Surname_eng, SpecialityId, YearOfEntery, StudentBook, IdentificationCode, " +
                "DateOfBirth, UkrainianCitizenship, SocialStatus, Sex, SeriesOfPassport, NumberOfPassport, IssuanceDateOfPassport, " +
                "FormOfTraining, ObtainingDegree, Financing, SeriesOfDocumentOfEducation, NumbersOfDocumentOfEducation, " +
                "NameOfDocumentOfEducation, NameOfEducationalInstitution)" +
                "VALUES ('" + ControllerRegistration_of_enrolled_students.anketa_1 + "', '" + ControllerRegistration_of_enrolled_students.anketa_2 + "', '" + ControllerRegistration_of_enrolled_students.anketa_3 + "', '" + ControllerRegistration_of_enrolled_students.anketa_4 + "', '" + ControllerRegistration_of_enrolled_students.anketa_5 + "', '" +
                ControllerRegistration_of_enrolled_students.anketa_6 + "', '" + ControllerRegistration_of_enrolled_students.anketa_7 + "', '" + ControllerRegistration_of_enrolled_students.anketa_8 + "', '" + ControllerRegistration_of_enrolled_students.anketa_9  + "', '" + ControllerRegistration_of_enrolled_students.anketa_11 + "', '" + ControllerRegistration_of_enrolled_students.anketa_12 +
                "', '" + ControllerRegistration_of_enrolled_students.anketa_13 + "', '" + ControllerRegistration_of_enrolled_students.anketa_14 + "', '" + ControllerRegistration_of_enrolled_students.anketa_15 + "', '" + ControllerRegistration_of_enrolled_students.anketa_16 + "', '" + ControllerRegistration_of_enrolled_students.anketa_18 + "', '" +
                ControllerRegistration_of_enrolled_students.anketa_19 + "', '" + ControllerRegistration_of_enrolled_students.anketa_20 + "', '" + ControllerRegistration_of_enrolled_students.anketa_21 + "', '" + ControllerRegistration_of_enrolled_students.anketa_22 + "', '" + ControllerRegistration_of_enrolled_students.anketa_27 + "', '" + ControllerRegistration_of_enrolled_students.anketa_28 +
                "', '" + ControllerRegistration_of_enrolled_students.anketa_29 + "', '" + ControllerRegistration_of_enrolled_students.anketa_30 + "', '" + ControllerRegistration_of_enrolled_students.anketa_31 +"')";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            prSt.executeUpdate();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }


}
