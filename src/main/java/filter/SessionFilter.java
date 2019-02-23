package main.java.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 不过滤的uri
        String[] notFilter = new String[] { "/login.do", "/loginSubmit.do" };
        // 获取session的值
        Object obj01 = request.getSession().getAttribute("user");
        Object obj02 = request.getSession().getAttribute("passWord");
        // 判断session里是否有值，如果为空则执行过滤
        if (obj01 == null && obj02 == null) {
            // 请求的uri
            String uri = request.getRequestURI();
            // 判断uri中是否包含do，为了防止通过界面所在的路径直接访问
            if (uri.indexOf("do") != -1) {
                // 是否过滤
                boolean doFilter = true;
                // 请求在"不过滤"的“名单”中， doFilter = false
                for (String s : notFilter) {
                    if (uri.indexOf(s) != -1) {
                        // 如果uri中包含不过滤的uri，则不进行过滤
                        doFilter = false;
                        break;
                    }
                }
                if (doFilter) {
                    // 执行过滤
                    // 从session中获取登录者实体
                    // request.setCharacterEncoding("UTF-8");
                    // response.setCharacterEncoding("UTF-8");
                    request.getRequestDispatcher("/login.do").forward(request, response);
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            }
        } else {
            // 如果uri中不包含do，则继续
            filterChain.doFilter(request, response);
        }
    }
}