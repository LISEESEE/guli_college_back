package com.lss.serviceedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient  //nacos注册
@EnableFeignClients  //微服务  服务调用
@ComponentScan(basePackages = {"com.lss"})
public class EduApplication {
    public static void main(String[] args) {
        try {

        SpringApplication.run(EduApplication.class,args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}