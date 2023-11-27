package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @GetMapping("students")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "mani",
                "prasad"
        );
        return ResponseEntity.ok().header("custome-header", "mani").body(student);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "mani", "Sid"));
        students.add(new Student(2, "Prasad", "Sid"));
        students.add(new Student(3, "jaya", "ponaganti"));
        students.add(new Student(4, "mukesh", "Neli"));
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);

    }


    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student=new Student(id, firstName, lastName);
        return ResponseEntity.ok(student) ;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getId());
        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
       return ResponseEntity.ok("Deleted sucessfully");
    }


}
