package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String drivername = "com.mysql.jdbc.Driver";
    private static String name = "root";
    private static String pass = "admin";
    private static String uri = "jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=utf-8";

    static {
        try {
            Class.forName(drivername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon() throws SQLException {

        return DriverManager.getConnection(uri,name,pass);
    }

    public static void main(String[] args) {
        try {
            System.out.println(DBUtil.getCon());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
