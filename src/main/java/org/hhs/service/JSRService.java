package org.hhs.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by hewater on 2017/9/3.
 */
public class JSRService {

    @PostConstruct
    public void init(){
        System.out.println("jsr250:init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("jsr250:destory");
    }
}
