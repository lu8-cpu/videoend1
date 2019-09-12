package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lu
 * @date 2019/9/11 11:14
 */
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("findAllSubject.do")
    @ResponseBody
    public Map<String, Object> findAll(){
        Map<String,Object> map= new HashMap<>();
        List<Subject> subjects=subjectService.findAll();
        map.put("subject",subjects);
        return map;
    }
}
