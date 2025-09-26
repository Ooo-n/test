package com.nze.test.service.impl;

import com.nze.test.pojo.Result;
import com.nze.test.service.HelloService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public Result hello(HttpSession session) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("{}",username);
        return Result.success("Hello world");

    }
}
