package com.qfedu.service;

import com.qfedu.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll(Integer page, Integer limit);

    public List<Course> findAll();


    void add(Course course);

    void delete(Integer id);

    Course findOne(Integer id);

    void updateCourse(Course course);
}
