package com.workercv.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.workercv.springboot.mapper")
public class WorkerCVSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkerCVSpringbootApplication.class, args);
    }

}
