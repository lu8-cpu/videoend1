package com.qfedu.dao;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerDao {
    List<Speaker> findAll();

    void deleteSpeaker(Integer id);

    void addSpeaker(Speaker speaker);

    Speaker findOne(Integer id);

    void updateSpeaker(Speaker speaker);
}
