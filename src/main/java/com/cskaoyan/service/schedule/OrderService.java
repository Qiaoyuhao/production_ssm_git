package com.cskaoyan.service.schedule;

import com.cskaoyan.domain.schedule.COrder;
import com.cskaoyan.domain.schedule.VO.COrderVO;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:31 2018/8/31
 * @Modified By:
 */
public interface OrderService {

    List<COrderVO> findOrder();

    boolean addOrder(COrder cOrder);

    boolean deleteOrder(Integer orderId);

    boolean updateOrder(COrder cOrder);

    boolean updateOrderSelective(COrder cOrder);

    List<COrderVO> findOrderByCondition(HashMap map);

    boolean deleteOrders(String[] ids) throws Exception;

    COrder findOrderById(String orderId);
}
