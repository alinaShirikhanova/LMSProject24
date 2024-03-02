package model;

import model.CourseEnrollment;

import java.time.OffsetDateTime;

public class Mark {
    private int id;
    private static int lastId = 0;
    private CourseEnrollment courseEnrollment;
    private int mark;
    private Student student;
    private OffsetDateTime date;


    public Mark(CourseEnrollment courseEnrollment, int mark, OffsetDateTime date) {
        this.id = lastId++;
        this.date = date;
        this.courseEnrollment = courseEnrollment;
        this.student = courseEnrollment.getStudent();
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseEnrollment getCourseEnrollment() {
        return courseEnrollment;
    }

    public void setCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollment = courseEnrollment;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }
}
