package io.daff.springboot_mongodb.mapper;

import io.daff.springboot_mongodb.po.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daffupman
 * @since 2020/3/10
 */
public interface StudentMapper {

    void insert(Student student);
    void delete(String id);
    void update(Student student);
    Student selectOne(String id);
    List<Student> selectAll();
}
