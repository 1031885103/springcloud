package cn.enjoy.controller;

import cn.enjoy.api.Product;
import cn.enjoy.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zzy on 2019/3/17.
 */
@RestController
@RequestMapping("/consumer/product")
public class ProductController {

    //private static final String SELECTALL = "http://SPRINGCLOUD-PROVIDER-PRODUCT/product/list/";
    //private static final String DELETE = "http://SPRINGCLOUD-PROVIDER-PRODUCT/product/delete/";
    //private static final String INSERT = "http://PRINGCLOUD-PROVIDER-PRODUCT/product/add/";


    @Resource
    private ProductService productService;

    @RequestMapping("/list")
    public Object selectAll() {
        return productService.selectAll();

    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam("productId") Integer productId) {
        return productService.delete(productId);

    }

    @RequestMapping("/add")
    public boolean insert(Product product) {
        return productService.insert(product);
    }

}
