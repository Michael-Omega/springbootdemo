package cn.louiswu.config.jwt;

import cn.louiswu.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtil jwtUtil;

    private static final PathMatcher pathMatcher = new AntPathMatcher();
    //......一些不重要的代码......
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if(isProtectedUrl(request)) {
                String token = request.getHeader("Authorization");
                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                jwtUtil.validateToken(token);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        filterChain.doFilter(request, response);
    }
    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean isProtectedUrl(HttpServletRequest request) {
        boolean flag;
        flag = !pathMatcher.match("/user/login", request.getServletPath()) || pathMatcher.match("/user/register", request.getServletPath());
        if (flag){
            return pathMatcher.match("/**", request.getServletPath());
        }else {
            return false;
        }

    }

    private boolean isExceededUrl(HttpServletRequest request) {
        return pathMatcher.match("/user/login", request.getServletPath()) || pathMatcher.match("/user/register", request.getServletPath());
    }
}
