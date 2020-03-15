package io.daff.springboot_mongodb.service.impl;

import io.daff.springboot_mongodb.mapper.StudentMapper;
import io.daff.springboot_mongodb.po.Student;
import io.daff.springboot_mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author daffupman
 * @since 2020/3/10
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void save(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(String id) {
        studentMapper.delete(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public Student getOne(String id) {
        return studentMapper.selectOne(id);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }
}
