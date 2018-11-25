package com.example.springboot.demo.ann_demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextLoaderTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ParentConfig.class);
    Car toyota_car=(Car)context.getBean("toyota");
        toyota_car.print();
        Car bmw_car=(Car)context.getBean("bmw");
        bmw_car.print();
    }
}
