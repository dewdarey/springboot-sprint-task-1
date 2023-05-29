package kz.bitlab.techorda.JavaSpring1.conroller;

import kz.bitlab.techorda.JavaSpring1.db.DBManager;
import kz.bitlab.techorda.JavaSpring1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Student> studentArray = DBManager.getStudents();
        model.addAttribute("students", studentArray);
        return "index";
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage(Model model) {
        return "add_student";
    }

    @PostMapping(value = "add-student")
    public String addStudent(Student student) {
        DBManager.addStudent(student);
        return "redirect:/";
    }

    @PostMapping(value = "add-student-v2")
    public String addStudnetV2(
            @RequestParam(name = "student-name") String name,
            @RequestParam(name = "student-surname") String surname,
            @RequestParam(name = "student-exam") int exam,
            @RequestParam(name = "student-mark") String mark
    ) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        student.setMark(mark);
        DBManager.addStudent(student);

        if (exam >= 90) {
            student.setMark("A");
        } else if (exam >= 75 && exam <= 89) {
            student.setMark("B");
        } else if (exam >= 60 && exam <= 74) {
            student.setMark("C");
        } else if (exam >= 50 && exam <= 59) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }

        return "redirect:/";
    }
}
