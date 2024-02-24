package model;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private static int lastId = 0;
    private int id;
    private static ArrayList<Student> students = new ArrayList<>();

    public static ArrayList<Student> getStudents() {
        return students;
    }
//    private ArrayList<model.Mark> marks = new ArrayList<>();


//    public ArrayList<model.Mark> getMarks() {
//        return marks;
//    }

    public Student(int id, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        students.add(this);
    }



    public void addMark(Course course, int mark, OffsetDateTime date){
        addMark(CourseEnrollment.getCourseEnrollmentByStudentAndCourse(this, course), mark, date);
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