package sample;

import javafx.stage.Stage;

import java.sql.*;
import java.util.function.DoubleToIntFunction;

public class Db extends Configs {
    private static Connection dbConnection;


    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String connection = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connection, dbUser, dbPass);
        System.out.println("Подключение установлено!\n");
        return dbConnection;
    }

    public static void closeDbConnection() {
        //dbConnection.close();
    }

    public static boolean authorization(String login, String password) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String insert = "SELECT * FROM users where login = '" + login + "' and password='" + password + "'";
        Statement st = getDbConnection().createStatement();
        resSet = st.executeQuery(insert);
        if (resSet.next()) {
            System.out.println("Пользователь найден!\n");
            return true;
        } else {
            System.out.println("Пользователь не найден!\n");
            return false;
        }
    }

    public static void registration(String name, String surname, String middle_name, String polis, String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_ID + "," + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + "," + Const.USERS_SURNAME + "," + Const.USERS_NAME + "," + Const.USERS_MIDNAME + "," + Const.USERS_POLIS + ")" + "VALUES (DEFAULT,'" + login + "','" + password + "','" + surname + "','" + name + "','" + middle_name + "','" + polis + "')";
        Statement st = getDbConnection().createStatement();
        st.executeUpdate(insert);
        System.out.println("Пользователь внесен в базу данных!\n");
    }

}
