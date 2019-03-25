package cn.enjoy.service;

import cn.enjoy.api.Product;
import cn.enjoy.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zzy on 2019/3/24.
 */
@FeignClient(name = "SPRINGCLOUD-PROVIDER-PRODUCT", configuration = FeignClientConfig.class)
public interface ProductService {

    @RequestMapping("/product/list")
    public Object selectAll();

    @RequestMapping("/product/delete")
    public boolean delete(@RequestParam("productId") Integer productId);

    @RequestMapping("/product/add")
    public boolean insert(Product product);
}
