package cn.enjoy.service;

import cn.enjoy.api.Product;

import java.util.List;

/**
 * Created by zzy on 2019/3/17.
 */
public interface ProductService {

    void insert(Product product);

    void delete(Integer productId);

    List<Product> selectAll();
}
