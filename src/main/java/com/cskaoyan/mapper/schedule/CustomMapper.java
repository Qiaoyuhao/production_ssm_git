package com.cskaoyan.mapper.schedule;

import com.cskaoyan.domain.schedule.Custom;

import java.util.HashMap;
import java.util.List;

public interface CustomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Thu Aug 30 22:50:51 CST 2018
     */
    int deleteByPrimaryKey(String customId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Thu Aug 30 22:50:51 CST 2018
     */
    int insert(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Thu Aug 30 22:50:51 CST 2018
     */
    int insertSelective(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Thu Aug 30 22:50:51 CST 2018
     */
    Custom selectByPrimaryKey(String customId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Thu Aug 30 22:50:51 CST 2018
     */
    int updateByPrimaryKeySelective(Custom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom
     *
     * @mbg.generated Thu Aug 30 22:50:51 CST 2018
     */
    int updateByPrimaryKey(Custom record);

    List<Custom> selectAll();

    List<Custom> selectByCondition(HashMap map);

}