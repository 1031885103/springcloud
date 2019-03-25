package cn.enjoy.test;

import cn.enjoy.AppProvider3;
import cn.enjoy.api.Product;
import cn.enjoy.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/3/17.
 */
@SpringBootTest(classes = AppProvider3.class)
@RunWith(SpringRunner.class)
public class ProductTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void select() {
        List<Product> products = productMapper.selectAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
