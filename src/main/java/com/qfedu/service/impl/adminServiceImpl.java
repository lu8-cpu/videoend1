package com.qfedu.service.impl;

import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl implements AdminService {
    @Autowired
    private com.qfedu.dao.adminDao adminDao;

    @Override
    public Admin findByUserName(String username,String password) {
        Admin admin =adminDao.findByUserName(username);
        if(null==admin){
            throw new RuntimeException("账号错误");
        }
        if(!admin.getPassword().equals(password)){
            throw new RuntimeException(("密码错误"));
        }

        return admin;
    }
}
