package com.qfedu.service;

import com.qfedu.entity.Admin;

import javax.servlet.http.HttpSession;

public interface AdminService {
    Admin findByUserName(String username, String password);
}
