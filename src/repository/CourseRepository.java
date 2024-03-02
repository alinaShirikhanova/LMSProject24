package repository;

import model.Course;
import model.Student;

import java.sql.*;

public class CourseRepository {
    private static String url = Data.getUrl();
    private static String login = Data.getLogin();
    private static String password = Data.getPassword();


    public static Course getCourseById(int id){
        Course course = null;
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM courses WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int course_id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                course = new Course(course_id,title,description);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return course;
    }

//    public static Course getCourseById(int id){
//        Course course = null;
//        try {
//            Connection connection = DriverManager.getConnection(url, login, password);
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM courses WHERE id=?");
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                int course_id = resultSet.getInt("id");
//                String title = resultSet.getString("title");
//                String description = resultSet.getString("description");
//                course = new Course(course_id, title, description);
//            }
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return course;
//    }


//    public static void editStudent(int id, String title, String description){
//        try {
//            Connection connection = DriverManager.getConnection(url, login, password);
//            PreparedStatement statement = connection.prepareStatement("UPDATE courses SET title=?, description=? WHERE id=?");
//
//            statement.setString(1, title);
//            statement.setString(2, description);
//            statement.setInt(3, id);
//            statement.execute();
//
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
}
//Реализовать удаление курса