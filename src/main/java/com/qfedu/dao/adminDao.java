package com.qfedu.dao;

import com.qfedu.entity.Admin;

public interface adminDao {
    Admin findByUserName(String username);
}
