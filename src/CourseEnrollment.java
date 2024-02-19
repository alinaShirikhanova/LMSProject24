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

//    public static ArrayList<Course> getCoursesByStudent()

    public static CourseEnrollment createCourseEnrollment(Student student, Course course){
        CourseEnrollment courseEnrollment = getCourseEnrollmentByStudentAndCourse(student, course);
        if (courseEnrollment != null){
            return courseEnrollment;
        }
        return new CourseEnrollment(student, course);
    }


    public static ArrayList<Course> getCourseByStudent(Student student) {
        ArrayList<Course> courses = new ArrayList<>() ;
        for (CourseEnrollment courseEnrollment : list){
            if (courseEnrollment.student.getId() == student.getId()){
                courses.add(courseEnrollment.course);
            }
        }
        return courses;
    }


    public static ArrayList<Student> getStudentByCourse(Course course) {
        ArrayList <Student> students = new ArrayList<>();
        for (CourseEnrollment courseEnrollment : list){
            if (courseEnrollment.course.getId() == course.getId()){
                students.add(courseEnrollment.student);
            }
        }
        return students;
    }
    public static CourseEnrollment getCourseEnrollmentByStudentAndCourse(Student student, Course course){
        for (CourseEnrollment courseEnrollment: list) {
            if (courseEnrollment.student.getId() == student.getId()
                    && courseEnrollment.course.getId() == course.getId()){
                return courseEnrollment;
            }
        }
        return null;

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
