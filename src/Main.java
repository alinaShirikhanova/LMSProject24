public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Иван", "Иванов");
        Course course = new Course("Java", "для начинающих");
        student1.addCourse(course);
        System.out.println(CourseEnrollment.getList());

    }
}