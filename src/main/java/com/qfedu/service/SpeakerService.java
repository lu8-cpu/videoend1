package com.qfedu.service;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerService {

    List<Speaker> findAll(Integer page, Integer limit);

    void delete(Integer id);

    List<Speaker> findAll();

    void add(Speaker speaker);

    Speaker findOne(Integer id);

    void updateSpeaker(Speaker speaker);




}
