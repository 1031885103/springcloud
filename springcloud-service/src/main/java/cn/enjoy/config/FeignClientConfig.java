package cn.enjoy.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zzy on 2019/3/24.
 */
@Configuration
public class FeignClientConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthenticationInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "enjoy");
    }

    @Bean
    public Logger.Level setLevel() {
        return Logger.Level.FULL;
    }


}
