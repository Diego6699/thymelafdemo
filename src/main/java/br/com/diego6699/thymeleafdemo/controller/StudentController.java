package br.com.diego6699.thymeleafdemo.controller;

import br.com.diego6699.thymeleafdemo.entities.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/login")
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping
    public String loginForm(Model model){

        model.addAttribute("student",new Student());
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);
        return "login-form";
    }

    @PostMapping
    public String processLogin(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("countries",countries);
            model.addAttribute("languages",languages);
            model.addAttribute("systems",systems);
            return "login-form";
        }else{
            System.out.println(student);
            return "process-form";
        }
    }
}
