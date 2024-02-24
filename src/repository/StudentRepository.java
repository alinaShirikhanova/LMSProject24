package repository;

import model.Student;

import java.sql.*;

public class StudentRepository {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String password = "123";


    public static void getStudents() {
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");


            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                new Student(id, name, surname);


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
