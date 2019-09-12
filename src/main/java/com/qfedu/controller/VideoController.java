package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Video;
import com.qfedu.service.CourseService;
import com.qfedu.service.SpeakerService;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VoVideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private SpeakerService speakerService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/VideoList.do")
    @ResponseBody
    public Map<String, Object> listVideo(HttpSession session,Integer page,Integer limit){
        List<VoVideoInfo> videoList= videoService.findAll(page,limit);
        long total = ((Page) videoList).getTotal();
        Map<String, Object> map = new HashMap<>();
        // 结合layui的表格组件， 0 表示成功
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录数
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", videoList);
        return map;

    }

    @RequestMapping("/findSpeakerAndCourse.do")
    @ResponseBody
    public Map<String,Object> findSpeakerAndCourse(){
        Map<String ,Object> map = new HashMap<>();
        List<Course> courses = courseService.findAll();
        List<Speaker> speakers=speakerService.findAll();

        map.put("course",courses);
        map.put("speaker",speakers);

        return map;
    }

    @RequestMapping("/addVideo.do")
    @ResponseBody

    public JsonResult addVideo(Video video){
        try {
            videoService.add(video);
            return new JsonResult(1,"添加成功");
        } catch (Exception e) {
            return new JsonResult(0,"添加失败");
        }

    }

    @ResponseBody
    @RequestMapping("deleteVideo.do")
    public JsonResult delete(Integer id){
        try {
            videoService.delete(id);
            return new JsonResult(1,"删除成功");
        } catch (Exception e) {
            return new JsonResult(0,"删除失败");
        }

    }

    @RequestMapping("/findOneVideo.do")
    @ResponseBody
    public JsonResult findOne(Integer id){
        try {
            Video video = videoService.findOne(id);
            return new JsonResult(1,video);
        } catch (Exception e) {
            return new JsonResult(0,"查询失败");
        }
    }

    @RequestMapping("/updateVideo.do")
    @ResponseBody

    public JsonResult modify(Video video){
        try {
            videoService.update(video);
            return new JsonResult(1,"修改成功");
        } catch (Exception e) {
            return new JsonResult(0,"查询失败");
        }
    }

    @RequestMapping("/deleteVideos.do")
    @ResponseBody
    public JsonResult deleteVideos(Integer[] ids){
        try {
            videoService.deleteVideos(ids);
            return new JsonResult(1,"删除成功");
        } catch (Exception e) {
            return new JsonResult(0,"删除失败");
        }
    }

    @RequestMapping("/findVo.do")
    @ResponseBody

    public Map<String,Object> findBySearch(Integer page,Integer limit,String info,Integer speakerId,Integer courseId){
        Map<String, Object> mpp=new HashMap<>();
        mpp.put("page",page);
        mpp.put("limit",limit);
        mpp.put("info",info);
        mpp.put("speakerId",speakerId);
        mpp.put("courseId",courseId);

        List<VoVideoInfo> infoList = videoService.findVo(mpp);

        long total = ((Page) infoList).getTotal();
        HashMap<String, Object> map = new HashMap<>();
        // 结合layui的表格组件， 0 表示成功
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录数
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", infoList);
        return map;
    }


}
