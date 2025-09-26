package com.nze.utils;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityContextUtils
{
    /**
     * 手动向 SecurityContext 中添加已认证用户
     * @param username 用户名
     * @param roles 角色列表（如 ["ROLE_USER", "ROLE_ADMIN"]）
     */
    public static void setAuthenticatedUser(String username, List<String> roles, HttpSession session) {
        // 1. 转换角色为 Spring Security 认可的权限（必须以 "ROLE_" 开头）
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            // 确保角色以 "ROLE_" 开头（Spring Security 权限规范）
            if (!role.startsWith("ROLE_")) {
                role = "ROLE_" + role;
            }
            authorities.add(new SimpleGrantedAuthority(role));
        }

        // 2. 创建已认证的 Authentication 对象（第三个参数为权限列表，非空表示已认证）
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(username, null, authorities);

        // 3. 设置到 SecurityContextHolder（当前线程上下文）
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 4. 同时存入 Session，实现跨请求共享
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
    }

}
