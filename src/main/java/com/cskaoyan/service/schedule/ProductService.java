package com.cskaoyan.service.schedule;

import com.cskaoyan.domain.schedule.Product;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:31 2018/8/31
 * @Modified By:
 */


public interface ProductService {

    List<Product> findProduct();

    boolean addProduct(Product product);

    boolean deleteProduct(Integer productId);

    boolean updateProduct(Product product);

    boolean updateProductSelective(Product product);

    List<Product> findProductByCondition(HashMap map);

    boolean deleteProducts(String[] ids) throws Exception;

    Product findProductById(String productId);
}
