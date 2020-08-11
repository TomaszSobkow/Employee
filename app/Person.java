package app;

import java.security.PublicKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String password;
    private String department;


    public Person(String name, String password, String department){
        this.name = name;
        this.password = password;
        this.department = department;
    }

    static List<Person> personsInArray = new ArrayList();

    public static void getPersons(ResultSet rs) throws SQLException {
           while (rs.next()){
                Person person = new Person(rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("department"));
            personsInArray.add(person);
            }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }
    public static List<Person> getPersonsInArray() {
        return personsInArray;
    }
}
