package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDBConnection {

    private static  String USERNAME = "tom";
    private static String PASSWORD = "$Q@ygXZM*8qp@Z9";
    private static final String EMPLOYEE_URL = "jdbc:mysql://127.0.0.1/Employee";
    private static final String PERON_URL = "jdbc:mysql://127.0.0.1/Employee";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(EMPLOYEE_URL, USERNAME, PASSWORD);
    }

   public static Connection getConnection(String user, String password) throws SQLException {
        return DriverManager.getConnection(PERON_URL, user, password);
    }


    public static String getEmployeeUrl() {
        return EMPLOYEE_URL;
    }
}
