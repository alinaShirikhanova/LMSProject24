import model.Course;
import model.Student;
import repository.StudentRepository;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        StudentRepository.getStudents();
        System.out.println(Student.getStudents());
    }
}