package cn.louiswu.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String,String> init = new HashMap<>();
        init.put("resetEnable","false");//禁用HTML页面上的“Rest All”功能
        init.put("allow","");           //ip白名单（没有配置或者为空，则允许所有访问）
        init.put("deny","");            //ip黑名单
        //如果某个ip同时存在，deny优先于allow
        init.put("loginUsername", "admin");  //++监控页面登录用户名
        init.put("loginPassword", "LouisWu1028");  //++监控页面登录用户密码
        servletRegistrationBean.setInitParameters(init);
        return servletRegistrationBean;
    }

}
