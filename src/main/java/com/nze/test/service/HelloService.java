package com.nze.test.service;

import com.nze.test.pojo.Result;
import jakarta.servlet.http.HttpSession;

public interface HelloService {
    Result hello(HttpSession session);
}
