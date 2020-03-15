package io.daff.springboot_mongodb.service;

import io.daff.springboot_mongodb.po.Student;

import java.util.List;

/**
 * @author daffupman
 * @since 2020/3/10
 */
public interface StudentService {

    void save(Student student);
    void delete(String id);
    void update(Student student);
    Student getOne(String id);
    List<Student> getAll();
}
