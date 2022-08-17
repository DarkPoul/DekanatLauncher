package org.ioc.DataBase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DB_Authentication{//Головний клас підключення бази даних

    public static boolean True_connection;

    public static void Open_DB() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//підключення драйверу
            try (Connection ignored = getConnection()){
                System.out.println("Connection to Store DB successfully!");
                True_connection = true;
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

    public ResultSet Connection_Dekanat() {//Створення методу для отримання даних з бази даних
        ResultSet resultSet = null;
        String query = "SELECT Login, password, ID_Faculty FROM Users_dekanat";//SQL запит на отримання інформації
        try {
            PreparedStatement prSt = getConnection().prepareStatement(query);
            resultSet = prSt.executeQuery();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}

