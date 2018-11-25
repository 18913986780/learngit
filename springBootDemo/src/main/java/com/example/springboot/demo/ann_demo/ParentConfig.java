package com.example.springboot.demo.ann_demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JavaConfigA.class,JavaConfigB.class})
public class ParentConfig {
}
