package com.cskaoyan.mapper.schedule;

import com.cskaoyan.domain.schedule.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Fri Aug 31 17:09:32 CST 2018
     */
    int deleteByPrimaryKey(String productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Fri Aug 31 17:09:32 CST 2018
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Fri Aug 31 17:09:32 CST 2018
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Fri Aug 31 17:09:32 CST 2018
     */
    Product selectByPrimaryKey(String productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Fri Aug 31 17:09:32 CST 2018
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Fri Aug 31 17:09:32 CST 2018
     */
    int updateByPrimaryKey(Product record);

    List<Product> selectAll();

    List<Product> selectByCondition(HashMap map);
}