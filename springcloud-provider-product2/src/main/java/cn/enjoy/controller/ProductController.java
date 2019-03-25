package cn.enjoy.controller;

import cn.enjoy.api.Product;
import cn.enjoy.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/3/17.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient client;//进行eureka 发现服务

    @RequestMapping("/list")
    public Object list() {
        List<Product> products = productService.selectAll();
        log.info("{}", products);
        return products;
    }

    @RequestMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") Integer productId) {
        boolean success = true;
        try {
            productService.delete(productId);
        } catch (Exception ex) {
            log.info("删除异常,{}", ex.getMessage());
            success = false;
        }
        return success;
    }

    @RequestMapping("/add")
    public boolean insert(@RequestBody Product product) {
        boolean success = true;
        try {
            productService.insert(product);
        } catch (Exception ex) {
            log.info("添加异常,{}", ex.getMessage());
            success = false;
        }
        return success;
    }

    @RequestMapping("/discover")
    public Object discover() {//发回发现服务的信息
        return this.client;
    }
}
