package com.qfedu.service;

import com.qfedu.entity.Video;
import com.qfedu.vo.VoVideoInfo;

import java.util.List;
import java.util.Map;

public interface VideoService {
    List<VoVideoInfo> findAll(Integer page, Integer limit);

    void add(Video video);

    void delete(Integer id);

    Video findOne(Integer id);

    void update(Video video);

    void deleteVideos(Integer[] ids);

    List<VoVideoInfo> findVo(Map map);
}
