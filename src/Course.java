import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private String description;
    private int id;
    private static int lastId = 0;
    private static ArrayList<Course> courses = new ArrayList<>();


    public Course(String title, String description) {
        this.title = title;
        this.description = description;
        this.id = lastId++;
        courses.add(this);
    }

    public void addMark( CourseEnrollment courseEnrollment, int mark, OffsetDateTime date){
        marks.add(new Mark(courseEnrollment, mark, date));
    }
    public void addMark( Student student, int mark, OffsetDateTime date){
        addMark(CourseEnrollment.getCourseEnrollmentByStudentAndCourse(student, this), mark, date);
    }
    public CourseEnrollment addStudent(Student student) {
        return CourseEnrollment.getCourseEnrollmentByStudentAndCourse(student, this);
    }

    public ArrayList<Student> getStudents() {
        return CourseEnrollment.getStudentsByCourse(this);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%d. %s %s", id, title, description);
    }
}