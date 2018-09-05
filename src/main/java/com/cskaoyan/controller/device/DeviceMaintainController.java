package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceMaintain;
import com.cskaoyan.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/list")
    @ResponseBody
    public List<DeviceMaintain> getList(DeviceMaintain deviceMaintain){
        List<DeviceMaintain> list = deviceMaintainService.getList(deviceMaintain);
        return list;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return null;
    }

    @RequestMapping("/add")
    public String add(){
        return "deviceMaintain_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap<String,Object> insert(DeviceMaintain deviceMaintain){
        boolean isAdd = deviceMaintainService.addDeviceMaintain(deviceMaintain);
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
        boolean deleteResult = deviceMaintainService.deleteBatch(ids);

        HashMap<String,Object> map = new HashMap<>();

        if(deleteResult){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }
        return map;
    }
}
