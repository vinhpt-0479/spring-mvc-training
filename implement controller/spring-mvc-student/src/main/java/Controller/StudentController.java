package Controller;

import DAO.StudentDAO;
import Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        System.out.println("getAllStudents");
        List<Student> students = studentDAO.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
//    @GetMapping("/student")
//    public String getStudent(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
//        Student student = new Student(id, "Student Name");
//        model.addAttribute("student", student);
//        return "student";
//    }
}
