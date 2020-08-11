package dataBase;

import app.Person;
import sample.Login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBasesConnections {

        static Statement stmt;
        static ResultSet rs;

        private static void databaseNotConnected(SQLException s){
            JOptionPane.showMessageDialog(null,"Data Base Not Connected !!"+
                            s.toString().substring(s.toString().indexOf(':')+1)+"\n\t\tProgram will be terminated !!!",
                    "Connection Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    public static void connectToEmployeeTable(String query) throws SQLException {
        try {
            Connection conEmployee = EmployeeDBConnection.getConnection();
            stmt = conEmployee.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);

             JOptionPane.showMessageDialog(null,"Connection successful","Connected",JOptionPane.PLAIN_MESSAGE);
           //System.exit(0);

        }catch (SQLException s){
           databaseNotConnected(s);
        }finally {
            rs.close();
            stmt.close();
        }
    }

    public static void connectToPersonTable(String query) throws SQLException {
        try {
            Connection connection = EmployeeDBConnection.getConnection(Login.getUser(), Login.getPassword());
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            //Create new Person object
            JOptionPane.showMessageDialog(null,"Connection successful to table Admin","Connected",JOptionPane.PLAIN_MESSAGE);
            Person.getPersons(rs);
        }catch (SQLException ex){
          JOptionPane.showMessageDialog(null,"User not found. Check your user name or password ","User not found",
                  JOptionPane.ERROR_MESSAGE);
        }finally {
            stmt.close();
            rs.close();
        }

    }
}
