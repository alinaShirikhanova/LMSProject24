package repository;

import model.Course;
import model.CourseEnrollment;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CourseEnrollmentRepository {
    private static String url = Data.getUrl();
    private static String login = Data.getLogin();
    private static String password = Data.getPassword();


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
                enrollments.add(new CourseEnrollment(id,student, course));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enrollments;
    }

//    public static ArrayList<Course> getCoursesByStudent(int student_id){
//        ArrayList<Course> courses = new ArrayList<>();
//
//        try {
//            Connection connection = DriverManager.getConnection(url, login, password);
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM enrollments WHERE student_id=?");
//
//            statement.setInt(1, student_id);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int courseId = resultSet.getInt("course_id");
//
//            }
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return enrollments;
//    }

    public static ArrayList<Course> getCoursesByStudentId(int student_id){
        ArrayList<Course> courses = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM enrollments WHERE student_id=?");

            statement.setInt(1, student_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                Course course = CourseRepository.getCourseById(courseId);
                courses.add(course);

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
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

    public static ArrayList<Student> getStudentsByCourseId(int course_id){
        ArrayList<Student> students = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM enrollments WHERE course_id=?");
            statement.setInt(1, course_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int st_id = resultSet.getInt("student_id");
                Student student = StudentRepository.getStudentById(st_id);
                students.add(student);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
