package com.cskaoyan.controller.scheduleMonitor;

import com.cskaoyan.domain.scheduleMonitor.Custom;
import com.cskaoyan.service.scheduleMonitor.CustomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 10:36 2018/8/31
 * @Modified By:
 */

@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    /**
     * @Author: QiaoYuhao
     * @Description: /find 转向custom_list页面 /list 返回查询到的数据信息
     *               todo 分页 所有显示页面的分页
     * @return:  "custom_list" list页面
     * @return:  customList 查询到的list信息
     */
    @RequestMapping("/find")
    public String findCustom(){
        return "custom_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Custom> getCustomList(){
        List<Custom> customList = customService.findCustom();
        return customList;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 模糊查询 分别是单条件查询，因为代码基本一样，因此合并处理
     * @param:  searchValue 查询的参数
     * @return: customList 返回查询后的list
     */
    @RequestMapping(value = {"/search_custom_by_customName","/search_custom_by_customId"})
    @ResponseBody
    public List<Custom> getCustomListByConditon(@RequestParam String searchValue, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        HashMap map = new HashMap();
        if(requestURI.contains("customName")){
            map.put("customName",searchValue);
        }else if(requestURI.contains("customId")){
            map.put("customId",searchValue);
        }
        List<Custom> customList = customService.findCustomByCondition(map);
        return customList;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /add_judge 添加前的判断 和 /add 添加窗口的打开 以及 /insert 添加操作
     *               todo add_judge需要做用户权限的判断
     * @param:  custom 表单获取的custom对象
     * @return: map 返回map对象
     */
    @RequestMapping("/add_judge")
    public String judgeBeforeAdd(){
        return "custom_list" ;
    }

    @RequestMapping("/add")
    public String afterJudge(){
        return "custom_add" ;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertCustom(Custom custom){
        boolean ret = customService.addCustom(custom);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "添加失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /edit_judge 修改前的判断   /edit 修改窗口的打开
     *               /update_all 修改全部信息操作  /update_note修改客户介绍操作
     *               todo edit_judge需要做用户权限的判断
     * @param:  custom 表单获取的custom对象
     * @return: map 返回map对象
     */
    @RequestMapping("/edit_judge")
    public String judgeBeforeEdit(){
        return "custom_list" ;
    }

    @RequestMapping("/edit")
    public String editAfterJudge(){
        return "custom_edit" ;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateCustom(Custom custom){
        boolean ret = customService.updateCustom(custom);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "修改客户信息失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public HashMap updateCustomNote(String customId,String note){
        Custom custom = new Custom();
        custom.setCustomId(customId);
        custom.setNote(note);
        boolean ret = customService.updateCustomSelective(custom);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "修改客户介绍失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /delete_judge 修改前的判断 /delete_batch批量删除客户操作
     *               todo delete_judge需要做用户权限的判断
     * @param:  custom 表单获取的custom对象
     * @return: map 返回map对象
     */

    @RequestMapping("/delete_judge")
    public String judgeBeforeDelete(){
        return "custom_list" ;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteCustoms(String[] ids){
        boolean ret = false;
        try {
            ret = customService.deleteCustoms(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap();

        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "删除失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }







//    @RequestMapping("/list")
//    @ResponseBody
//    public HashMap getCustomList(Integer page, Integer rows){
//        List<Custom> customList = customService.findCustom();
//        Integer pn = customList.size()/rows +1;
//        HashMap map = new HashMap();
//        PageHelper.startPage(pn,rows);
//        PageInfo pageInfo = new PageInfo<>(customList,rows);
//        System.out.println("pageInfo = "+ pageInfo);
//        map.put("customList",customList);
//        map.put("pageInfo",pageInfo);
//        System.out.println(map);
//        return map;
//    }



}
