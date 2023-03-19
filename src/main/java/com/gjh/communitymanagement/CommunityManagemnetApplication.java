package com.gjh.communitymanagement;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.gjh.communitymanagement.dao")
public class CommunityManagemnetApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunityManagemnetApplication.class);
    }

}
