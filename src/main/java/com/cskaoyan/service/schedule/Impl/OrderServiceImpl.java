package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.domain.schedule.COrder;
import com.cskaoyan.domain.schedule.VO.COrderVO;
import com.cskaoyan.mapper.schedule.OrderMapper;
import com.cskaoyan.service.schedule.OrderService;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<COrderVO> findOrder() {

        List<COrderVO> orderVOS = orderMapper.selectAll();
        System.out.println(orderVOS);

        return orderVOS;
    }

    @Override
    public boolean addOrder(COrder cOrder) {
        return orderMapper.insert(cOrder)==1;
    }

    @Override
    public boolean deleteOrder(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(String.valueOf(orderId))==1;
    }

    @Override
    public boolean updateOrder(COrder cOrder) {
        return orderMapper.updateByPrimaryKey(cOrder)==1;
    }

    @Override
    public boolean updateOrderSelective(COrder cOrder) {
        return orderMapper.updateByPrimaryKeySelective(cOrder)==1;
    }

    @Override
    public List<COrderVO> findOrderByCondition(HashMap map) {

        return orderMapper.selectByCondition(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOrders(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id : ids) {
            i = orderMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
//            int a = 1 / 0;
        }
        return count==ids.length;
    }


    @Override
    public COrderVO findOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
