package com.cskaoyan.controller.schedule;

import com.cskaoyan.domain.schedule.Manufacture;
import com.cskaoyan.domain.schedule.VO.ManufactureVO;
import com.cskaoyan.service.schedule.ManufactureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 10:34 2018/9/4
 * @Modified By:
 */

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;
    /**
     * @Author: QiaoYuhao
     * @Description: /find 转向manufacture_list页面 /list 返回查询到的数据信息
     *
     * @return:  "manufacture_list" list页面
     * @return:  manufactureList 查询到的list信息
     */
    @RequestMapping("/find")
    public String findManufacture(){
        return "manufacture_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap getManufactureList(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<ManufactureVO> manufactureList = manufactureService.findManufacture();
        HashMap map = new HashMap();
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(manufactureList);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /add_judge 添加前的判断 和 /add 添加窗口的打开 以及 /insert 添加操作
     *               todo add_judge需要做用户权限的判断
     * @param:  manufacture 表单获取的manufacture对象
     * @return: map 返回map对象
     */
    @RequestMapping("/add_judge")
    public String judgeBeforeAddManufacture(){
        return "manufacture_list" ;
    }

    @RequestMapping("/add")
    public String addManufactureAfterJudge(){
        return "manufacture_add" ;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertManufacture(Manufacture manufacture){
        boolean ret = manufactureService.addManufacture(manufacture);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
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
     * @return: manufactureList 返回查询后的list
     */
    @RequestMapping(value = {"/search_manufacture_by_manufactureSn","/search_manufacture_by_manufactureTechnologyName","/search_manufacture_by_manufactureOrderId"})
    @ResponseBody
    public HashMap getManufactureListByConditon(@RequestParam String searchValue, HttpServletRequest request, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        //获取当前请求的uri
        String requestURI = request.getRequestURI();

        HashMap map = new HashMap();

        //判断请求来自哪个uri，分支处理
        if (requestURI.contains("manufactureSn")) {
            map.put("manufactureSn", searchValue);
        } else if (requestURI.contains("manufactureTechnologyName")) {
            map.put("technologyName", searchValue);
        }else if(requestURI.contains("manufactureOrderId")){
            map.put("orderId", searchValue);
        }
        HashMap retrunMap = new HashMap();
        List<ManufactureVO> manufactureList = manufactureService.findManufactureByCondition(map);
        System.out.println("manufactureList = "+manufactureList);
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(manufactureList);
        retrunMap.put("total", pageInfo.getTotal());
        retrunMap.put("rows", pageInfo.getList());
        return retrunMap;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: /edit_judge 修改前的判断   /edit 修改窗口的打开
     *               /update_all 修改全部信息操作  /update_note修改客户介绍操作
     *               todo edit_judge需要做用户权限的判断
     * @param:  manufacture 表单获取的manufacture对象
     * @return: map 返回map对象
     */
    @RequestMapping("/edit_judge")
    public String judgeManufactureBeforeEdit(){
        return "manufacture_list" ;
    }

    @RequestMapping("/edit")
    public String editManufactureAfterJudge(){
        return "manufacture_edit" ;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateManufacture(Manufacture manufacture){
        boolean ret = manufactureService.updateManufacture(manufacture);
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
     * @param:  manufacture 表单获取的manufacture对象
     * @return: map 返回map对象
     */

    @RequestMapping("/delete_judge")
    public String judgeManufactureBeforeDelete(){
        return "manufacture_list" ;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteManufactures(String[] ids){
        boolean ret = false;
        try {
            ret = manufactureService.deleteManufactures(ids);
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

    @RequestMapping("/get/{manufactureSn}")
    @ResponseBody
    public Manufacture getManufactureForOthers(@PathVariable String manufactureSn){
        //获取并返回manufacture对象
        Manufacture manufacture = manufactureService.findManufactureById(manufactureSn);
        return manufacture;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<ManufactureVO> getManufactureData(){
        List<ManufactureVO> manufacture = manufactureService.findManufacture();
        return manufacture;
    }

}
