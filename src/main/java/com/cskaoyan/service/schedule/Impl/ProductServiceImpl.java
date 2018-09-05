package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.domain.schedule.Product;
import com.cskaoyan.mapper.schedule.ProductMapper;
import com.cskaoyan.service.schedule.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:34 2018/8/31
 * @Modified By:
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public List<Product> findProduct() {
        return productMapper.selectAll();
    }

    @Override
    public boolean addProduct(Product product) {
        return productMapper.insert(product)==1;
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        return productMapper.deleteByPrimaryKey(String.valueOf(productId))==1;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product)==1;
    }

    @Override
    public boolean updateProductSelective(Product product) {
        return productMapper.updateByPrimaryKeySelective(product)==1;
    }

    @Override
    public List<Product> findProductByCondition(HashMap map) {
        return productMapper.selectByCondition(map);
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 批量删除操作，如果操作中出现失败则回滚
     * @param: ids 批量删除的对象的主键数组
     * @return: boolean
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProducts(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id : ids) {
            i = productMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
//            int a = 1 / 0;
        }
        return count==ids.length;
    }

    @Override
    public Product findProductById(String productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        System.out.println("product="+product);
        return product;
    }

}
