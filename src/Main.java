public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Иван", "Иванов");
        Student student2 = new Student("Петя", "Петров");
        Student student3 = new Student("Костя", "Виноградов");
        Course course1 = new Course("Java", "для начинающих");
        Course course2 = new Course("Java", "для профи");
        Course course3 = new Course("Python", "для начинающих");

        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

        student2.addCourse(course2);

        student3.addCourse(course3);
        System.out.println(student1.getCourses());
        System.out.println(student2.getCourses());
        System.out.println(student3.getCourses());

        System.out.println(course1.getStudents());
        System.out.println(course2.getStudents());
        System.out.println(course3.getStudents());
    }
}