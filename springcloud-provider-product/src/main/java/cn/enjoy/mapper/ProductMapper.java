package cn.enjoy.mapper;

import cn.enjoy.api.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzy on 2019/3/16.
 */
public interface ProductMapper {

    void insert(@Param("product") Product product);

    void delete(@Param("productId") Integer productId);

    List<Product> selectAll();
}
