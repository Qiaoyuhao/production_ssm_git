package com.cskaoyan.controller.schedule;

import com.cskaoyan.domain.schedule.COrder;
import com.cskaoyan.domain.schedule.VO.COrderVO;
import com.cskaoyan.service.schedule.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:24 2018/9/4
 * @Modified By:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    /**
     * @Author: QiaoYuhao
     * @Description: /find 转向order_list页面 /list 返回查询到的数据信息
     *               todo 分页 所有显示页面的分页
     * @return:  "order_list" list页面
     * @return:  orderList 查询到的list信息
     */
    @RequestMapping("/find")
    public String findOrder(){
        return "order_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap getOrderList(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<COrderVO> orderList = orderService.findOrder();
        HashMap map = new HashMap();
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(orderList);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /add_judge 添加前的判断 和 /add 添加窗口的打开 以及 /insert 添加操作
     *               todo add_judge需要做用户权限的判断
     * @param:  COrder 表单获取的order对象
     * @return: map 返回map对象
     */
    @RequestMapping("/add_judge")
    public String judgeBeforeAddOrder(){
        return "order_list" ;
    }

    @RequestMapping("/add")
    public String addOrderAfterJudge(){
        return "order_add" ;
    }

    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    @ResponseBody
    public HashMap insertOrder(COrder cOrder){
        boolean ret = orderService.addOrder(cOrder);
        HashMap map = new HashMap();
        if(ret){
            map.put("status",200);
            map.put("msg","ok");
            map.put("data",null);
        }else {
            String msg = "添加失败，请重试.";
            map.put("msg",msg);
        }
        return map;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: 模糊查询 分别是单条件查询，因为代码基本一样，因此合并处理
     * @param:  searchValue 查询的参数
     * @return: orderList 返回查询后的list
     */
    @RequestMapping(value = {"/search_order_by_orderId","/search_order_by_orderCustom","/search_order_by_orderProduct"})
    @ResponseBody
    public HashMap getOrderListByConditon(@RequestParam String searchValue, HttpServletRequest request, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        //获取当前请求的uri
        String requestURI = request.getRequestURI();

        HashMap map = new HashMap();

        //判断请求来自哪个uri，分支处理
        if (requestURI.contains("orderId")) {
            map.put("orderId", searchValue);
        } else if (requestURI.contains("orderCustom")) {
            map.put("customName", searchValue);
        }else if(requestURI.contains("orderProduct")){
            map.put("productName", searchValue);
        }
        HashMap retrunMap = new HashMap();
        List<COrderVO> orderList = orderService.findOrderByCondition(map);
        System.out.println("orderList = "+orderList);
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(orderList);
        retrunMap.put("total", pageInfo.getTotal());
        retrunMap.put("rows", pageInfo.getList());
        return retrunMap;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: /edit_judge 修改前的判断   /edit 修改窗口的打开
     *               /update_all 修改全部信息操作  /update_note修改客户介绍操作
     *               todo edit_judge需要做用户权限的判断
     * @param:  COrder 表单获取的order对象
     * @return: map 返回map对象
     */
    @RequestMapping("/edit_judge")
    public String judgeOrderBeforeEdit(){
        return "order_list" ;
    }

    @RequestMapping("/edit")
    public String editOrderAfterJudge(){
        return "order_edit" ;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateOrder(COrder cOrder){
        boolean ret = orderService.updateOrder(cOrder);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "修改产品信息失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }



    /**
     * @Author: QiaoYuhao
     * @Description: /delete_judge 修改前的判断 /delete_batch批量删除产品操作
     *               todo delete_judge需要做用户权限的判断
     * @param:  COrder 表单获取的order对象
     * @return: map 返回map对象
     */

    @RequestMapping("/delete_judge")
    public String judgeOrderBeforeDelete(){
        return "order_list" ;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteOrders(String[] ids){
        boolean ret = false;
        try {
            ret = orderService.deleteOrders(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap();

        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "删除失败，请重试。";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public COrderVO getOrderForOthers(@PathVariable String orderId){
        //获取并返回order对象
        COrderVO cOrder = orderService.findOrderById(orderId);
        return cOrder;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<COrderVO> getCOrderData(){
        List<COrderVO> cOrder = orderService.findOrder();
        return cOrder;
    }

    
}
