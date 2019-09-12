package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lu
 * @date 2019/9/10 13:58
 */

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/courseList.do")
    @ResponseBody
    public Map<String, Object> listSpeaker(Integer page, Integer limit){

        List<Course> courses = courseService.findAll(page,limit);
        long total = ((Page)courses).getTotal();
        Map<String,Object> map=new HashMap<>();
        // 结合layui的表格组件， 0 表示成功
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录数
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", courses);

        return map;
    }
    @RequestMapping("/addCourses.do")
    @ResponseBody
    public JsonResult addCourse(Course course){
        try {
            courseService.add(course);
            return new JsonResult(1,"添加成功");
        } catch (Exception e) {
            return new JsonResult(1,"添加失败");
        }

    }
    @ResponseBody
    @RequestMapping("/deleteCourse.do")
    public JsonResult delete(Integer id){

        try {
            courseService.delete(id);
            return new JsonResult(1,"添加成功");
        } catch (Exception e) {
            return new JsonResult(1,"添加失败");
        }
    }

    @RequestMapping("/findOneCourse.do")
    @ResponseBody
    public JsonResult findOne(Integer id){
        try {
            Course course = courseService.findOne(id);

            return new JsonResult(1, course);
        } catch (Exception e) {
            return new JsonResult(0, "查找失败");
        }

    }

    @RequestMapping("/updateCourse.do")
    @ResponseBody
    public JsonResult modify(Course course) {
        try {
            courseService.updateCourse(course);
            return  new JsonResult(1, "修改成功");
        } catch (Exception e){
            return new JsonResult(0, "修改失败");
        }

    }


}
