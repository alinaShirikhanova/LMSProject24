import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private static int lastId = 0;
    private int id;
    private static ArrayList<Student> students = new ArrayList<>();


    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = lastId++;
        students.add(this);
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
}