package cn.enjoy;

import cn.rabbon.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by zzy on 2019/3/17.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class)
public class AppConsumer {
    public static void main(String[] args) {
        SpringApplication.run(AppConsumer.class, args);
    }
}
