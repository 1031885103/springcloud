package cn.enjoy.controller;

import cn.enjoy.api.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/3/17.
 */
@RestController
@RequestMapping("/consumer/product")
public class ProductController {

    private static final String SELECTALL = "http://SPRINGCLOUD-PROVIDER-PRODUCT/product/list/";
    private static final String DELETE = "http://SPRINGCLOUD-PROVIDER-PRODUCT/product/delete/";
    private static final String INSERT = "http://PRINGCLOUD-PROVIDER-PRODUCT/product/add/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/list")
    public Object selectAll() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("SPRINGCLOUD-PROVIDER-PRODUCT");
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());

        List<Product> list = restTemplate.exchange(SELECTALL, HttpMethod.GET,
                new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return list;
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam("productId") Integer productId) {
        boolean success = true;
        try {
            success = restTemplate.exchange(DELETE + productId, HttpMethod.DELETE,
                    new HttpEntity<Object>(httpHeaders), Boolean.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    @RequestMapping("/add")
    public boolean insert(Product product) {
        return restTemplate.exchange(INSERT, HttpMethod.POST,
                new HttpEntity<Object>(product, httpHeaders), Boolean.class).getBody();
    }

}
