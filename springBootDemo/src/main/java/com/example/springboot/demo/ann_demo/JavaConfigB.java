package com.example.springboot.demo.ann_demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable//加了这个注解就代表这个类是ioc容器
public class JavaConfigB {
    @Bean("bmw")//这就相当于一个bean
    public Car getBMW(){
        return new BMW();
    }
}
