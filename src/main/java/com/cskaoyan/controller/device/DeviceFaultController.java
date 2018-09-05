package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceFault;
import com.cskaoyan.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/list")
    @ResponseBody
    public List<DeviceFault> getList(DeviceFault deviceFault){
        List<DeviceFault> list = deviceFaultService.getList(deviceFault);
        return list;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return null;
    }

    @RequestMapping("/add")
    public String add(){
        return "deviceFault_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap<String,Object> insert(DeviceFault deviceFault){
        boolean isAdd = deviceFaultService.addDeviceFault(deviceFault);
        HashMap<String,Object> map = new HashMap<>();

        if(isAdd){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }

        return map;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return null;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap<String,Object> deleteBatch(String[] ids){
        boolean deleteResult = deviceFaultService.deleteBatch(ids);

        HashMap<String,Object> map = new HashMap<>();

        if(deleteResult){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }
        return map;
    }



}
