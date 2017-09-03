package org.hhs.service;

import org.springframework.stereotype.Service;

/**
 * Created by hewater on 2017/9/3.
 */
public class BeanWayService {

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("初始化构造函数-beanWayService");
    }

    public void destory(){
        System.out.println("@Bean-destory-method");
    }
}
