package cn.enjoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by zzy on 2019/3/17.
 */
@SpringBootApplication
@MapperScan("cn.enjoy.mapper")
@EnableEurekaClient
@EnableDiscoveryClient //主程序发现服务
public class AppProvider3 {
    public static void main(String[] args) {
        SpringApplication.run(AppProvider3.class, args);
    }
}
