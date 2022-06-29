//package cn.louiswu.config.jwt;
//
//import cn.louiswu.bean.User;
//import cn.louiswu.config.anno.PassToken;
//import cn.louiswu.config.anno.UserLoginToken;
//import cn.louiswu.service.UserService;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
//
//public class AuthenticationInterceptor implements HandlerInterceptor {
//    @Autowired
//    UserService userService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
//        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
//        System.err.println("token="+token);
//        // 如果不是映射到方法直接通过
//        if (!(object instanceof HandlerMethod)) {
//            System.out.println("1");
//            return true;
//        }
//        System.out.println("2");
//        HandlerMethod handlerMethod = (HandlerMethod) object;
//        Method method = handlerMethod.getMethod();
//        //检查是否有passtoken注释，有则跳过认证
//        if (method.isAnnotationPresent(PassToken.class)) {
//            System.out.println("PassToken");
//            PassToken passToken = method.getAnnotation(PassToken.class);
//            if (passToken.required()) {
//                return true;
//            }
//        }
//
//        System.out.println("3");        //检查有没有需要用户权限的注解
//        if (method.isAnnotationPresent(UserLoginToken.class)) {
//            System.out.println("UserLoginToken");
//            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//            if (userLoginToken.required()) {
//                // 执行认证
//                if (null == token) {
//                    System.out.println("4");
//                    throw new RuntimeException("无token，请重新登录");
//                }
//                // 获取 token 中的 user id
//                String userId;
//                try {
//                    userId = JWT.decode(token).getAudience().get(0);
//                } catch (JWTDecodeException j) {
//                    throw new RuntimeException("401");
//                }
//                User user =  userService.selectById(userId);
////                User user = userService.findUserById(userId);
//                if (user == null) {
//                    System.out.println("5");
//                    throw new RuntimeException("用户不存在，请重新登录");
//                }
//                // 验证 token
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUserPwd())).build();
//                try {
//                    System.out.println("6");
//                    jwtVerifier.verify(token);
//                } catch (JWTVerificationException e) {
//                    throw new RuntimeException("401");
//                }
//                return true;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest,
//                           HttpServletResponse httpServletResponse,
//                           Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest,
//                                HttpServletResponse httpServletResponse,
//                                Object o, Exception e) throws Exception {
//    }
//}