package com.cskaoyan.controller.schedule;

import com.cskaoyan.domain.schedule.VO.WorkVO;
import com.cskaoyan.domain.schedule.Work;
import com.cskaoyan.service.schedule.WorkService;
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
 * @Date: Created in 16:20 2018/9/3
 * @Modified By:
 */

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;
    /**
     * @Author: QiaoYuhao
     * @Description: /find 转向work_list页面 /list 返回查询到的数据信息
     *               todo 分页 所有显示页面的分页
     * @return:  "work_list" list页面
     * @return:  workList 查询到的list信息
     */
    @RequestMapping("/find")
    public String findWork(){
        return "work_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap getWorkList(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<WorkVO> workList = workService.findWork();
        HashMap map = new HashMap();
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(workList);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /add_judge 添加前的判断 和 /add 添加窗口的打开 以及 /insert 添加操作
     *               todo add_judge需要做用户权限的判断
     * @param:  work 表单获取的work对象
     * @return: map 返回map对象
     */
    @RequestMapping("/add_judge")
    public String judgeBeforeAddWork(){
        return "work_list" ;
    }

    @RequestMapping("/add")
    public String addWorkAfterJudge(){
        return "work_add" ;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertWork(Work work){
        boolean ret = workService.addWork(work);
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
     * @return: workList 返回查询后的list
     */
    @RequestMapping(value = {"/search_work_by_workId","/search_work_by_workProduct","/search_work_by_workProcess","/search_work_by_workDevice"})
    @ResponseBody
    public HashMap getWorkListByConditon(@RequestParam String searchValue, HttpServletRequest request, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        //获取当前请求的uri
        String requestURI = request.getRequestURI();

        HashMap map = new HashMap();

        //判断请求来自哪个uri，分支处理
        if (requestURI.contains("workId")) {
            map.put("workId", searchValue);
        } else if (requestURI.contains("workProduct")) {
            map.put("productName", searchValue);
        }else if(requestURI.contains("workDevice")){
            map.put("deviceName", searchValue);
        }else if(requestURI.contains("workProcess")){
            map.put("processId", searchValue);
        }
        HashMap retrunMap = new HashMap();
        List<WorkVO> workList = workService.findWorkByCondition(map);
        System.out.println("workList = "+workList);
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(workList);
        retrunMap.put("total", pageInfo.getTotal());
        retrunMap.put("rows", pageInfo.getList());
        return retrunMap;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: /edit_judge 修改前的判断   /edit 修改窗口的打开
     *               /update_all 修改全部信息操作  /update_note修改客户介绍操作
     *               todo edit_judge需要做用户权限的判断
     * @param:  work 表单获取的work对象
     * @return: map 返回map对象
     */
    @RequestMapping("/edit_judge")
    public String judgeWorkBeforeEdit(){
        return "work_list" ;
    }

    @RequestMapping("/edit")
    public String editWorkAfterJudge(){
        return "work_edit" ;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateWork(Work work){
        boolean ret = workService.updateWork(work);
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
     * @param:  work 表单获取的work对象
     * @return: map 返回map对象
     */

    @RequestMapping("/delete_judge")
    public String judgeWorkBeforeDelete(){
        return "work_list" ;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteWorks(String[] ids){
        boolean ret = false;
        try {
            ret = workService.deleteWorks(ids);
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

    @RequestMapping("/get/{workId}")
    @ResponseBody
    public Work getWorkForOthers(@PathVariable String workId){
        //获取并返回work对象
        Work work = workService.findWorkById(workId);
        return work;
    }



    @RequestMapping("/get_data")
    @ResponseBody
    public List<WorkVO> getWorkData(){
        List<WorkVO> work = workService.findWork();

        return work;

    }



}
