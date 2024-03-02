package repository;

import model.Course;
import model.CourseEnrollment;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CourseEnrollmentRepository {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String password = "123";

    public static ArrayList<CourseEnrollment> getCourseEnrollments () {
        ArrayList<CourseEnrollment> enrollments = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM enrollments");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                Student student = StudentRepository.getStudentById(studId);
                Course course = CourseRepository.getCourseById(courseId);
                enrollments.add(new CourseEnrollment(id, student, course));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enrollments;
    }

    public static void createCourseEnrollment( int studentId, int courseId) {
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO enrollment(student_id, course_id) VALUES(?,?)");


            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.execute();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
