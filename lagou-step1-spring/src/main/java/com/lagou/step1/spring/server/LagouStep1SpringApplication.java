package com.lagou.step1.spring.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author luozhengchao
 * @Date 2020/10/18 2:07 下午
 */
@SpringBootApplication
public class LagouStep1SpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LagouStep1SpringApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
