package repository;

import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String password = "123";


    public static ArrayList<Student> getStudents (){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                students.add(new Student(id, name, surname));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static void createStudent(String name, String surname) {
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students(name, surname) VALUES(?, ?)");

            statement.setString(1, name);
            statement.setString(2, surname);
            statement.execute();

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
