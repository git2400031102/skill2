package com.university.studentapi.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.studentapi.exception.InvalidInputException;
import com.university.studentapi.exception.StudentNotFoundException;
import com.university.studentapi.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final Map<Long, Student> students = Map.of(
            1L, new Student(1L, "Aarav", "Computer Science"),
            2L, new Student(2L, "Meera", "Electronics"),
            3L, new Student(3L, "Rahul", "Mechanical"));

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        if (id <= 0) {
            throw new InvalidInputException("Student ID must be greater than 0.");
        }

        Student student = students.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found for ID: " + id);
        }
        return student;
    }
}
