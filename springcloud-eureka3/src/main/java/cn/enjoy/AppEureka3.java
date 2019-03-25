package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zzy on 2019/3/18.
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3 {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka3.class, args);
    }

}
