import java.time.OffsetDateTime;

public class Mark {
    private int id;
    private static int lastId = 0;
    private CourseEnrollment courseEnrollment;
    private int mark;
    private OffsetDateTime date;


    public Mark(CourseEnrollment courseEnrollment, int mark, OffsetDateTime date) {
        this.id = lastId++;
        this.date = date;
        this.courseEnrollment = courseEnrollment;
        this.mark = mark;
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
