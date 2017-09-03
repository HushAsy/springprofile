package org.hhs.config;

import org.hhs.service.BeanWayService;
import org.hhs.service.JSRService;
import org.hhs.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by hewater on 2017/9/3.
 */
@Configuration
@ComponentScan("org.hhs")
@EnableWebMvc
public class Config {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public BeanWayService getBWS(){
        return new BeanWayService();
    }

    @Bean
    public JSRService getJSRService(){
        return new JSRService();
    }

    //spring profile配置
    @Bean
    @Profile("dev")
    public Person devPerson(){
        Person p = new Person();
        p.setName("dev");
        p.setMessage("profile");
        return p;
    }

    @Bean
    @Profile("test")
    public Person testPerson(){
        Person p = new Person();
        p.setName("test");
        p.setMessage("profile");
        return p;
    }

    @Bean
    public UrlBasedViewResolver setViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }
}
