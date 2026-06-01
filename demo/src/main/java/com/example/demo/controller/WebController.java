package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final StudentRepository repo;

    public WebController(StudentRepository repo) {
        this.repo = repo;
    }

    // Home page (form + list)
    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("students", repo.findAll());
        model.addAttribute("student", new Student());
        return "index";
    }

    // Save student (from form)
    @PostMapping("/save")
    public String saveStudent(Student student) {
        repo.save(student);
        return "redirect:/";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}