package kz.task.first.spring.task.db;

import kz.task.first.spring.task.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    @Getter
    private static List<Student> students = new ArrayList<>();
    private static Long studentId = 5L;

    static {
        students.add(new Student(1L, "Ilyas", "Zhuanyshev", 88, "B"));
        students.add(new Student(2L, "Serik", "Erikov", 91, "A"));
        students.add(new Student(3L, "Erik", "Serikov", 65, "C"));
        students.add(new Student(4L, "Nurzhan", "Bolatov", 48, "F"));
    }

    public static void addStudent(Student student) {
        student.setMark("F");
        if (student.getExam() >= 90)
            student.setMark("A");
        if (student.getExam() >= 75 && student.getExam() <= 89)
            student.setMark("B");
        if (student.getExam() >= 60 && student.getExam() <= 74)
            student.setMark("C");
        if (student.getExam() >= 50 && student.getExam() <= 59)
            student.setMark("D");
        student.setId(studentId);
        students.add(student);
        studentId++;
    }
}
