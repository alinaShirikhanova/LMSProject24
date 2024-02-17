import java.util.ArrayList;

public class CourseEnrollment {
    private int id;
    private static int lastId = 0;
    private Student student;
    private Course course;

    private static ArrayList<CourseEnrollment> list = new ArrayList<>();

    public CourseEnrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.id = lastId++;
        list.add(this);
    }

    public int getId() {
        return id;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static ArrayList<CourseEnrollment> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "CourseEnrollment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
