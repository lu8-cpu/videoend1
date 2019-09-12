package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
   @Autowired
   private SpeakerDao speakerDao;


    @Override
    public List<Speaker> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return speakerDao.findAll();
    }

    @Override
    public void delete(Integer id) {
        speakerDao.deleteSpeaker(id);
    }


    @Override
    public List<Speaker> findAll() {
        return speakerDao.findAll();
    }

    @Override
    public void add(Speaker speaker) {
        speakerDao.addSpeaker(speaker);
    }

    @Override
    public Speaker findOne(Integer id) {

        return speakerDao.findOne(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerDao.updateSpeaker(speaker);
    }


}
