package com.nze.test.service.impl;

import com.nze.test.pojo.Result;
import com.nze.test.pojo.User;
import com.nze.test.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nze.utils.SecurityContextUtils.setAuthenticatedUser;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Override
    public Result login(User user, HttpSession session) {
        log.info("{}",user);
        //若使用数据库，改if条件
        if (user.getUsername().equals("test") && user.getPassword().equals("123456")) {
            //模拟添加一个具有HELLO角色的用户
            List<String> roles = List.of("HELLO"); // 等价于 ["ROLE_USER"]
            setAuthenticatedUser(user.getUsername(), roles,session);

            //验证是否添加成功
            System.out.println("当前登录用户：" +
                    SecurityContextHolder.getContext().getAuthentication().getName()); // 输出 testUser
            System.out.println("用户权限：" +
                    SecurityContextHolder.getContext().getAuthentication().getAuthorities()); // 输出 [ROLE_USER]
            return Result.success(user);
        }
        return Result.error("用户名或密码不正确！");
        //可以增加逻辑判断具体错误原因（用户名不存在、密码不正确）
    }
}
