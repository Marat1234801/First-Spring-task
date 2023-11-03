package kz.task.first.spring.task.controllers;

import kz.task.first.spring.task.db.StudentManager;
import kz.task.first.spring.task.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getStudents(Model model) {
        List<Student> students = StudentManager.getStudents();
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping("/add-student")
    public String addStudentPage() {
        return "addStudent";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam String name, @RequestParam String surname, @RequestParam Integer exam) {
        Student newStudent = Student.builder()
                .name(name)
                .surname(surname)
                .exam(exam)
                .build();
        StudentManager.addStudent(newStudent);
        return "redirect:/";
    }
}
