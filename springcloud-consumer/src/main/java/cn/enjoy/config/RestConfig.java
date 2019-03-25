package cn.enjoy.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by zzy on 2019/3/14.
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();//定义http请求头
        String auth = "root:enjoy";//认证的原始信息
        byte[] encode = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encode);
        httpHeaders.set("Authorization", authHeader);
        return httpHeaders;
    }

}
