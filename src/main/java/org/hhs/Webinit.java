package org.hhs;

import org.hhs.config.Config;
import org.hhs.service.BeanWayService;
import org.hhs.service.JSRService;
import org.hhs.vo.Person;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.DispatcherServlet;
/**
 * Created by hewater on 2017/9/3.
 */
public class Webinit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext cac = new AnnotationConfigWebApplicationContext();
        cac.setServletContext(servletContext);
        cac.register(Config.class);
        cac.getEnvironment().setActiveProfiles("dev");
        cac.refresh();
        //测试profile
        Person person = cac.getBean(Person.class);
        System.out.println(person.toString());
        //测试@Bean与jsr250
        System.out.println("-------------测试@Bean--------------");
        BeanWayService beanWayService = cac.getBean(BeanWayService.class);
        System.out.println("-------------测试@JSR250--------------");
        JSRService jsrService = cac.getBean(JSRService.class);

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(cac));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(0);

    }
}
