package com.qfedu.dao;

import com.qfedu.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {


    public List<Course> findAll();


    void add(Course course);

    void delete(Integer id);

    Course findOne(Integer id);

    void update(Course course);
}
