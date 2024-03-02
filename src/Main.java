import model.Course;
import model.CourseEnrollment;
import model.Student;
import repository.CourseEnrollmentRepository;
import repository.StudentRepository;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(CourseEnrollmentRepository.getCourseEnrollments());
        System.out.println(CourseEnrollment.getCoursesByStudent(5));
        System.out.println(CourseEnrollment.getStudentsByCourse(1));
    }
}
