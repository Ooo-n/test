package com.nze.test.controller;

import com.nze.test.pojo.Result;
import com.nze.test.service.HelloService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public Result hello(HttpSession session) {
        return  helloService.hello(session);
    }
}
