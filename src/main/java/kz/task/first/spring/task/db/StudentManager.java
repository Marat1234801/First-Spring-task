package kz.task.first.spring.task.db;

import kz.task.first.spring.task.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        String mark = student.calculateMark(student.getExam());
        student.setMark(mark);
        student.setId(studentId);
        students.add(student);
        studentId++;
    }

    public static void deleteStudentById(Long id) {
        students.removeIf(student -> Objects.equals(student.getId(), id));
    }

    public static Student getStudentById(Long id) {
        return students.stream().filter(student -> Objects.equals(student.getId(), id))
                .findFirst().orElse(null);
    }

    public static void updateStudent(Long id, String name, String surname, Integer exam) {
        Student student = getStudentById(id);
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        String mark = student.calculateMark(student.getExam());
        student.setMark(mark);
    }

    public static List<Student> findStudent(String search) {
        if (search.isEmpty())
            return students;

        return students.stream().filter(student -> student.getName()
                        .toLowerCase()
                        .contains(search.toLowerCase()) || student
                        .getSurname()
                        .toLowerCase()
                        .contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }
}
