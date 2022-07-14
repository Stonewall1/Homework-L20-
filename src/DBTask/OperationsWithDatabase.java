package DBTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperationsWithDatabase {
    public void insertInfo() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement prep = connection.prepareStatement("INSERT INTO students(name , country) VALUES(?,?)");

            String name = "Vasya Dvoechnick";
            String country = "Russia";

            prep.setString(1, name);
            prep.setString(2, country);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByStudentName() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM students WHERE name=?");

            String name = "Sage Fry";

            prep.setString(1, name);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByCountry() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM students WHERE country=?");

            String country = "Russia";

            prep.setString(1, country);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
