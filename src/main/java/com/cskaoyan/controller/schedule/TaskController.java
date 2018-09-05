package com.cskaoyan.controller.schedule;

import com.cskaoyan.domain.schedule.Task;
import com.cskaoyan.domain.schedule.VO.TaskVO;
import com.cskaoyan.service.schedule.TaskService;
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
 * @Date: Created in 16:15 2018/9/4
 * @Modified By:
 */

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;
    /**
     * @Author: QiaoYuhao
     * @Description: /find 转向task_list页面 /list 返回查询到的数据信息
     *               todo 分页 所有显示页面的分页
     * @return:  "task_list" list页面
     * @return:  taskList 查询到的list信息
     */
    @RequestMapping("/find")
    public String findTask(){
        return "task_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap getTaskList(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<TaskVO> taskList = taskService.findTask();
        HashMap map = new HashMap();
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(taskList);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /add_judge 添加前的判断 和 /add 添加窗口的打开 以及 /insert 添加操作
     *               todo add_judge需要做用户权限的判断
     * @param:  task 表单获取的task对象
     * @return: map 返回map对象
     */
    @RequestMapping("/add_judge")
    public String judgeBeforeAddTask(){
        return "task_list" ;
    }

    @RequestMapping("/add")
    public String addTaskAfterJudge(){
        return "task_add" ;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertTask(Task task){
        boolean ret = taskService.addTask(task);
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
     * @return: taskList 返回查询后的list
     */
    @RequestMapping(value = {"/search_task_by_taskId","/search_task_by_taskManufactureSn","/search_task_by_taskWorkId"})
    @ResponseBody
    public HashMap getTaskListByConditon(@RequestParam String searchValue, HttpServletRequest request, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        //获取当前请求的uri
        String requestURI = request.getRequestURI();

        HashMap map = new HashMap();

        //判断请求来自哪个uri，分支处理
        if (requestURI.contains("taskId")) {
            map.put("taskId", searchValue);
        } else if (requestURI.contains("taskManufactureSn")) {
            map.put("manufactureSn", searchValue);
        }else if(requestURI.contains("taskWorkId")){
            map.put("workId", searchValue);
        }
        HashMap retrunMap = new HashMap();
        List<TaskVO> taskList = taskService.findTaskByCondition(map);
        System.out.println("taskList = "+taskList);
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(taskList);
        retrunMap.put("total", pageInfo.getTotal());
        retrunMap.put("rows", pageInfo.getList());
        return retrunMap;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: /edit_judge 修改前的判断   /edit 修改窗口的打开
     *               /update_all 修改全部信息操作  /update_note修改客户介绍操作
     *               todo edit_judge需要做用户权限的判断
     * @param:  task 表单获取的task对象
     * @return: map 返回map对象
     */
    @RequestMapping("/edit_judge")
    public String judgeTaskBeforeEdit(){
        return "task_list" ;
    }

    @RequestMapping("/edit")
    public String editTaskAfterJudge(){
        return "task_edit" ;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateTask(Task task){
        boolean ret = taskService.updateTask(task);
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
     * @param:  task 表单获取的task对象
     * @return: map 返回map对象
     */

    @RequestMapping("/delete_judge")
    public String judgeTaskBeforeDelete(){
        return "task_list" ;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteTasks(String[] ids){
        boolean ret = false;
        try {
            ret = taskService.deleteTasks(ids);
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

    @RequestMapping("/get/{taskId}")
    @ResponseBody
    public Task getTaskForOthers(@PathVariable String taskId){
        //获取并返回task对象
        Task task = taskService.findTaskById(taskId);
        return task;
    }


    @RequestMapping("/get_data")
    @ResponseBody
    public List<TaskVO> getTaskData(){
        List<TaskVO> task = taskService.findTask();

        return task;

    }


}
