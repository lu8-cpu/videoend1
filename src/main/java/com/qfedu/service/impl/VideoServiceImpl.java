package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.VideoDao;
import com.qfedu.entity.Video;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VoVideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<VoVideoInfo> findAll(Integer page, Integer limit) {
        //设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);
        List<VoVideoInfo> list = videoDao.findAll();
        return list;

    }

    @Override
    public void add(Video video) {
        videoDao.add(video);
    }

    @Override
    public void delete(Integer id) {
        videoDao.delete(id);
    }

    @Override
    public Video findOne(Integer id) {
        return videoDao.findOne(id);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public void deleteVideos(Integer[] ids) {
        videoDao.deleteVideos(ids);
    }

    @Override
    public List<VoVideoInfo> findVo(Map map) {
        PageHelper.startPage((Integer)map.get("page"),(Integer)map.get("limit"));
        List<VoVideoInfo> list =videoDao.findVo(map);
        return list;
    }
}
