import java.lang.reflect.Array;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private static int lastId = 0;
    private int id;
    private static ArrayList<Student> students = new ArrayList<>();

    private ArrayList<Mark> marks = new ArrayList<>();



    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = lastId++;
        students.add(this);
    }

    public void addMark(Student student, Course course, int mark, OffsetDateTime date){
        addMark(CourseEnrollment.getCourseEnrollmentByStudentAndCourse(student, course), mark, date);
    }
    public void addMark(CourseEnrollment courseEnrollment, int mark, OffsetDateTime date){
        new Mark(courseEnrollment, mark, date);
    }

    public CourseEnrollment addCourse(Course course){
        return CourseEnrollment.getCourseEnrollmentByStudentAndCourse(this, course);
    }

    public ArrayList<Course> getCourses(){
        return CourseEnrollment.getCourseByStudent(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("%d. %s %s", id, name, surname);
    }
}