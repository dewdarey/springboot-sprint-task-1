package kz.bitlab.techorda.JavaSpring1.db;

import kz.bitlab.techorda.JavaSpring1.model.Student;

import java.util.ArrayList;

public class DBManager {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static Long id = 6L;

    static {
        students.add(new Student(1L, "Ilyas", "Zhuanyshev", 94, "A"));
        students.add(new Student(2L, "Aibek", "Bagit", 75, "B"));
        students.add(new Student(3L, "Kuat", "Abylai", 63, "C"));
        students.add(new Student(4L, "Galym", "Ilyas", 57, "D"));
        students.add(new Student(5L, "Serik", "Berikov", 2, "E"));
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        student.setId(id);
        id++;
        students.add(student);
    }
}
