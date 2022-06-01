package com.jb.test5.controllers;

import com.jb.test5.beans.Student;
import com.jb.test5.exceptions.SchoolSystemException;
import com.jb.test5.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long id) throws SchoolSystemException {
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable long id) throws SchoolSystemException {
        return studentService.getOneStudent(id);
    }

    @GetMapping("ByName")
    public List<Student> getStudentsByName(@RequestParam String name){
        return studentService.getStudentsByName(name);
    }

    @GetMapping("AvgGrade/{id}")
    public double avgStudentGrades(@PathVariable long id){
        return studentService.avgStudentGrades(id);
    }
}
