package kz.task.first.spring.task.controllers;

import kz.task.first.spring.task.db.StudentManager;
import kz.task.first.spring.task.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getStudents(Model model) {
        var students = StudentManager.getStudents();
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping("/add-student")
    public String addStudentPage() {
        return "addStudent";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam String name, @RequestParam String surname, @RequestParam Integer exam) {
        var newStudent = Student.builder()
                .name(name)
                .surname(surname)
                .exam(exam)
                .build();
        StudentManager.addStudent(newStudent);
        return "redirect:/";
    }

    @PostMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        StudentManager.deleteStudentById(id);
        return "redirect:/";
    }

    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        var student = StudentManager.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "editUser";
        }
        return "redirect:/";
    }

    @PostMapping("/edit-student/{id}")
    public String editStudent(@PathVariable Long id,
                              @RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam Integer exam) {
        if (!name.isEmpty() && !surname.isEmpty() && exam >= 1) {
            StudentManager.updateStudent(id, name, surname, exam);
        }
        return "redirect:/";
    }

    @GetMapping("/search-student")
    public String searchStudent(@RequestParam String search, Model model) {
        var students = StudentManager.findStudent(search);
        model.addAttribute("students", students);
        return "home";
    }
}
