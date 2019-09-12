package com.qfedu.controller;


import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpeakerController {
   @Autowired
    private SpeakerService speakerService;

   @RequestMapping("/listSpeaker.do")
    @ResponseBody
    public Map<String, Object> listSpeaker(Integer page, Integer limit){

       List<Speaker> speakers = speakerService.findAll(page,limit);
       long total = ((Page) speakers).getTotal();
       Map<String,Object> map=new HashMap<>();
       // 结合layui的表格组件， 0 表示成功
       map.put("code", 0);
       map.put("msg", "");
       // 表中总记录数
       map.put("count", total);
       // 获取到的分页数据
       map.put("data", speakers);

       return map;
   }

   @RequestMapping("deleteSpeaker.do")
    @ResponseBody
    public JsonResult delete(Integer id){
       try {
           speakerService.delete(id);
           return new JsonResult(1,"删除成功");
       } catch (Exception e) {
           return new JsonResult(0,"删除失败");
       }

   }

   @RequestMapping("addSpeaker.do")
    @ResponseBody
    public JsonResult addSpeaker(Speaker speaker){
       try {
           speakerService.add(speaker);
           return new JsonResult(1,"添加成功");
       } catch (Exception e) {
           return new JsonResult(0,"添加失败");
       }
   }

   @RequestMapping("updateSpeaker.do")
    @ResponseBody
    public JsonResult update(Speaker speaker){
       try {
           speakerService.updateSpeaker(speaker);
           return new JsonResult(1,"修改成功");
       } catch (Exception e) {
           return new JsonResult(0,"修改失败");
       }

   }

   @RequestMapping("findOneSpeaker")
    @ResponseBody
    public JsonResult findOne(Integer id){
       try {
           Speaker speaker = speakerService.findOne(id);
           return new JsonResult(1,speaker);
       } catch (Exception e) {
           return new JsonResult(0,"修改失败");
       }
   }












}
