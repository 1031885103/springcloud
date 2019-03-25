package cn.enjoy;

import cn.rabbon.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by zzy on 2019/3/17.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("cn.enjoy.service")
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class)
public class AppConsumerFeign {
    public static void main(String[] args) {
        SpringApplication.run(AppConsumerFeign.class, args);
    }
}
