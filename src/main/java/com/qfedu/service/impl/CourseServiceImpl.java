package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZZzz
 * @version 1.0
 * @className CourseServiceImpl
 * @description TODO
 * @date 2019/8/6 19:40
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll(Integer page, Integer limit) {
        //设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);
        List<Course> courseList = courseDao.findAll();
        return courseList;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public void add(Course course) {
        courseDao.add(course);
    }

    @Override
    public void delete(Integer id) {
        courseDao.delete(id);
    }

    @Override
    public Course findOne(Integer id) {

        return courseDao.findOne(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.update(course);
    }


}
