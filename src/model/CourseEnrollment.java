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



    public static ArrayList<Course> getCoursesByStudent(int student_id) {
        return CourseEnrollmentRepository.getCoursesByStudentId(student_id);
    }


    public static ArrayList<Student> getStudentsByCourse(int course_id) {
        return CourseEnrollmentRepository.getStudentsByCourseId(course_id);
    }

    public static CourseEnrollment getCourseEnrollmentByStudentAndCourse(Student student, Course course){
        for (CourseEnrollment courseEnrollment: list) {
            if (courseEnrollment.student.getId() == student.getId()
                    && courseEnrollment.course.getId() == course.getId()){
                return courseEnrollment;
            }
        }
        return new CourseEnrollment(student, course);
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


    @Override
    public String toString() {
        return String.format("Зачисление: %d%n Студент :%s%nКурс: %s%n", id, student, course);
    }
}
