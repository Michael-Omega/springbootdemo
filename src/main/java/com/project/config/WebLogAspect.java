package com.project.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private  Long startTime = System.currentTimeMillis();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 定义拦截规则：拦截cn.louiswu.controller..*(..))包下面的所有类中，有@PostMapping注解的方法
     */
    @Pointcut("execution(public * cn.louiswu.controller.*.*.*(..))")
    private void weblog(){}


    @Before("weblog()")
    public void controller(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        String before = "\n"+"SpringBoot"+"==================================="+sdf.format(new Date())+"===================================\n";
        String path = request.getRequestURL().toString()+"\n";
        String method = request.getMethod()+"\n";
        String ip = request.getRemoteAddr()+"\n";
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+"\n";
        //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        Map<Object,Object> params = new HashMap<>();
        while(enu.hasMoreElements()){
            String paraName=enu.nextElement();
            params.put(paraName,request.getParameter(paraName));
        }

        logger.info("\011[35;4m"+before+"\t\tPATH:\t\t\t"+path+"\t\tMETHOD:\t\t\t"+method+"\t\tIP:\t\t\t\t"+ip+"\t\tCLASSMETHOD:\t"+classMethod+"\t\tPARAMS:\t\t\t"+params+"\n\033[0m");
    }
    @After("weblog()")
    public void AfterConntroller(){
        String after = "===================================================================================================";
        System.out.println(after);
    }

}
