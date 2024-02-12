public class CourseEnrollment {
    private int id;
    private static int lastId = 0;
    private Student student;
    private Course course;

    public CourseEnrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.id = lastId++;
    }
}
