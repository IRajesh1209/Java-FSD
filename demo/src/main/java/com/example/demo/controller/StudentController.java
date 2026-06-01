package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // ✅ POST - Add student
    @PostMapping
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    // ✅ GET - Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // ✅ PUT - Update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student s = repo.findById(id).orElse(null);

        if (s != null) {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setCourse(student.getCourse());
            return repo.save(s);
        }
        return null;
    }

    // ✅ DELETE - Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted successfully";
    }

    // ✅ BULK POST - Add multiple students
    @PostMapping("/bulk")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return repo.saveAll(students);
    }
}