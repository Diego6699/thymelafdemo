package br.com.diego6699.thymeleafdemo.controller;

import br.com.diego6699.thymeleafdemo.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class StudentController {

    @GetMapping
    public String loginForm(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @PostMapping
    public String processLogin(@ModelAttribute("student") Student student){
        System.out.println(student);
        return "process-form";
    }
}
