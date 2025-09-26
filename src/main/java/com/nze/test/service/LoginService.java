package com.nze.test.service;

import com.nze.test.pojo.Result;
import com.nze.test.pojo.User;
import jakarta.servlet.http.HttpSession;

public interface LoginService {

    Result login(User user, HttpSession session);
}
