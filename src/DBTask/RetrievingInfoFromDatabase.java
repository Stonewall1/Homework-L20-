package DBTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetrievingInfoFromDatabase {
    public void getFullDBInfo() {
        try (Connection connection = DataBaseConnection.getConnection()) {

            HashMap<String, String> studentsInfo = new HashMap<>();

            Statement statement = connection.createStatement();
            ResultSet studentsFullInfo = statement.executeQuery("SELECT * FROM students");
            while (studentsFullInfo.next()) {
                studentsInfo.put(studentsFullInfo.getString("name"),
                        studentsFullInfo.getString("country"));
            }
            for (Map.Entry<String, String> entry : studentsInfo.entrySet()) {
                System.out.println("Name : " + entry.getKey() + "\n" + "Country : " + entry.getValue() + "\n-----------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getListOfStudents() {
        List<String> listOfStudents = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet studentsFullInfo = statement.executeQuery("SELECT * FROM students");
            while (studentsFullInfo.next()) {
                listOfStudents.add(studentsFullInfo.getString("name"));
            }
            System.out.println("---All students list---");
            for (String name : listOfStudents) {
                System.out.println(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
