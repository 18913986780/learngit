package com.example.springboot.demo.ann_demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable//spring的一个注解，用来自动注入bean的注解，不需要通过BeanFactory去获取（加了这个注解就代表这个类是ioc容器）
public class JavaConfigA {
    @Bean("toyota")//这就相当于一个bean
    public Car getToyota(){
        return new Toyota();
    }
}
