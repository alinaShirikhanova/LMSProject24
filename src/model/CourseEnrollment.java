package model;



import repository.CourseEnrollmentRepository;

import java.util.ArrayList;

public class CourseEnrollment {
    private int id;
    private Student student;
    private Course course;


    public CourseEnrollment(int id, Student student, Course course) {
        this.student = student;
        this.course = course;
        this.id = id;
    }

//    public static ArrayList<model.Course> getCoursesByStudent()

//    public static model.CourseEnrollment createCourseEnrollment(model.Student student, model.Course course){
//        model.CourseEnrollment courseEnrollment = getCourseEnrollmentByStudentAndCourse(student, course);
//        if (courseEnrollment != null){
//            return courseEnrollment;
//        }
//        return new model.CourseEnrollment(student, course);
//    }


    public static ArrayList<Course> getCourseByStudent(Student student) {
        ArrayList<Course> courses = new ArrayList<>() ;
        for (CourseEnrollment courseEnrollment : CourseEnrollmentRepository.getCourseEnrollments()){
            if (courseEnrollment.student.getId() == student.getId()){
                courses.add(courseEnrollment.course);
            }
        }
        return courses;
    }


    public static ArrayList<Student> getStudentsByCourse(Course course) {
        ArrayList <Student> students = new ArrayList<>();
        for (CourseEnrollment courseEnrollment : CourseEnrollmentRepository.getCourseEnrollments()){
            if (courseEnrollment.course.getId() == course.getId()){
                students.add(courseEnrollment.student);
            }
        }
        return students;
    }
//    public static CourseEnrollment getCourseEnrollmentByStudentAndCourse(Student student, Course course){
//        for (CourseEnrollment courseEnrollment: CourseEnrollmentRepository.getCourseEnrollments()) {
//            if (courseEnrollment.student.getId() == student.getId()
//                    && courseEnrollment.course.getId() == course.getId()){
//                return courseEnrollment;
//            }
//        }
//        return new CourseEnrollment(student, course);
//    }

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


    @Override
    public String toString() {
        return "model.CourseEnrollment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
