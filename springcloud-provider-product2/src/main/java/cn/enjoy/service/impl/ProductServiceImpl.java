package cn.enjoy.service.impl;

import cn.enjoy.api.Product;
import cn.enjoy.mapper.ProductMapper;
import cn.enjoy.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zzy on 2019/3/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public void insert(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void delete(Integer productId) {
        productMapper.delete(productId);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }
}
