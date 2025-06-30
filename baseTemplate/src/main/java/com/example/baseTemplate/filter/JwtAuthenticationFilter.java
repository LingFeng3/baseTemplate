package com.example.baseTemplate.filter;

import com.example.baseTemplate.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class JwtAuthenticationFilter implements Filter {

    private final JwtConfig jwtConfig;

    @Autowired
    public JwtAuthenticationFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String currentPath = httpRequest.getRequestURI();
        // 打印当前请求路径用于调试
        System.out.println("[DEBUG] Request URI: " + currentPath);

        List<String> excludePaths = Arrays.asList(
                "/health",
                "/api/test/selectList"
        );
        // 增强路径匹配逻辑
        boolean isExcluded = excludePaths.stream().anyMatch(path -> {
            if (path.contains("**")) {
                // 支持 ant 风格路径匹配
                String regexPath = path.replace("/**", ".*");
                return Pattern.matches(regexPath, currentPath);
            }
            return currentPath.equals(path);
        });

        if (isExcluded) {
            chain.doFilter(request, response);
            return;
        }

        // 从请求头获取token
        String authHeader = httpRequest.getHeader("Authorization");
        String token = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }

        // 验证token
        if (token == null || !jwtConfig.validateToken(token)) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Invalid or missing token");
            return;
        }

        // Token验证通过，继续处理请求
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}