package io.daff.springboot_mongodb.mapper.impl;

import io.daff.springboot_mongodb.mapper.StudentMapper;
import io.daff.springboot_mongodb.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daffupman
 * @since 2020/3/10
 */
@Repository
public class StudentMapperImpl implements StudentMapper {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Student student) {
        mongoTemplate.save(student, "students");
    }

    @Override
    public void delete(Integer id) {
        Student student = mongoTemplate.findById(id, Student.class);
        if (student != null) {
            mongoTemplate.remove(student,"students");
        }
    }

    @Override
    public void update(Student student) {
        // 条件
        Query query = new Query(Criteria.where("_id").is(student.getId()));
        // 修改的内容
        Update update = new Update();
        update.set("content", "nice啊胖虎！");
        update.set("name", "胖虎");
        update.set("userId", "ph666");
        update.set("visits", 200);
        mongoTemplate.updateFirst(query, update, Student.class, "students");
    }

    @Override
    public Student selectOne(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Student.class, "students");
    }

    @Override
    public List<Student> selectAll() {
        return mongoTemplate.findAll(Student.class, "students");
    }
}
