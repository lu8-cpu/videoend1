package com.qfedu.service.impl;

import com.qfedu.dao.SubejctDao;
import com.qfedu.entity.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Lu
 * @date 2019/9/11 11:26
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubejctDao subejctDao;

    @Override
    public List<Subject> findAll() {
        return subejctDao.findAll() ;
    }
}
