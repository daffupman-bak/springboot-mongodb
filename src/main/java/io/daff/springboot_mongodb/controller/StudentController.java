package io.daff.springboot_mongodb.controller;

import io.daff.springboot_mongodb.po.Student;
import io.daff.springboot_mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daffupman
 * @since 2020/3/10
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String save(@RequestBody Student student) {
        try {
            studentService.save(student);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Student student) {
        try {
            studentService.update(student);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @DeleteMapping("/delete")
    public String remove(Integer id) {
        try {
            studentService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("/get/{id}")
    public String getOne(@PathVariable("id") String id) {
        try {
            Student one = studentService.getOne(id);
            return one.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("/list")
    public List<Student> getALl() {
        try {
            return studentService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
