package com.musicweb.config;

import com.musicweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration

public class LoginConfig  extends WebMvcConfigurationSupport  {
//public class LoginConfig  implements WebMvcConfigurer  {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器，没有登录的用户不得访问后台
         *
         */
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/background/**")
                .excludePathPatterns("/","/register","/findMusic","/Login","/loginout","/login","/goodlrc","/Register","/static/**","/static/img","/static/js","/static/css");

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }


}
