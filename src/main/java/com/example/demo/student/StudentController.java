package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping("/new")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path="/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
    	studentService.deleteStudent(studentId);
    }
    @PutMapping(path="/update/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
    	studentService.updateStudent(studentId, name, email);
    }

}
