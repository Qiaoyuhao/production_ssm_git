package com.cskaoyan.controller.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Process;
import com.cskaoyan.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping("/find")
    public String find() {
        return "process_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows, Process process) throws Exception{
        EUDataGridResult result = processService.getList(page, rows, process);
        return result;
    }

    @RequestMapping(value = {"/add_judge"})
    public String add_judge (){
        return "process_add";
    }

    @RequestMapping(value = {"add"})
    public String add (){
        return "process_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertProcess(Process process) {
        HashMap map = new HashMap();
        boolean ret1 = processService.findprocessById(process.getProcessId());
        if(ret1) {
            String msg = "该工序编号已经存在，请更换工序编号！";
            map.put("msg",msg);
        } else {
            boolean ret = processService.insertProcess(process);
            if(ret) {
                String status = "200";
                map.put("status",status);
            } else {
                String msg = "添加工序失败，请重试";
                map.put("msg",msg);
            }
        }

        return map;
    }

    @RequestMapping(value = {"/delete_judge"})
    public String delete_judge (){
        return "process_list";
    }

    @RequestMapping(value = {"/delete_batch"})
    @ResponseBody
    public HashMap deleteProcessByIds (String[] ids){
        boolean ret = false;
        try {
            ret = processService.deleteProcessByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap map = new HashMap();
        if(ret) {
            String status = "200";
            map.put("status",status);
        } else {
            String msg = "删除工序失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String editTechnologyById1() {
        return "process_edit";
    }

    @RequestMapping("/edit")
    public String editTechnologyById2() {
        return "process_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateTechnology2(Process process) {
        boolean ret = processService.updateProcess(process);
        HashMap map = new HashMap();
        if(ret) {
            String status = "200";
            map.put("status",status);
        } else {
            String msg = "修改失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/get/{processId}")
    @ResponseBody
    public Process getItemById(@PathVariable String processId) throws Exception{
        Process process = processService.getProcessById(processId);
        return process;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Process> getData() throws Exception{
        List<Process> list = processService.findProcesses();
        return list;
    }

    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String searchValue) throws Exception{
        EUDataGridResult result = processService.searchProcessByProcessId(page, rows, searchValue);
        return result;
    }

    //根据工序计划id查找
    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue)
            throws Exception{
        EUDataGridResult result = processService.searchProcessByTechnologyPlanId(page, rows, searchValue);
        return result;
    }

}
