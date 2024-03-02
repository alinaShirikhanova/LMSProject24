import model.Course;
import model.Student;
import repository.CourseEnrollmentRepository;
import repository.StudentRepository;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
//        StudentRepository.getStudents();
//        StudentRepository.createStudent("Владимир", "Пупкин");
//        System.out.println(StudentRepository.getStudents());
//        StudentRepository.deleteStudent(1);
//        System.out.println(StudentRepository.getStudents());
        System.out.println(StudentRepository.getStudentById(5));
        System.out.println(CourseEnrollmentRepository.getCourseEnrollments());
    }
}
//Реализовать редактирование курса