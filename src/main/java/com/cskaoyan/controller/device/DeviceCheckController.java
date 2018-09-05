package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceCheck;
import com.cskaoyan.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public List<DeviceCheck> getList(DeviceCheck deviceCheck){
        List<DeviceCheck> list = deviceCheckService.getList(deviceCheck);
        return list;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return null;
    }

    @RequestMapping("/add")
    public String add(){
        return "deviceCheck_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap<String,Object> insert(DeviceCheck deviceCheck){
        boolean isAdd = deviceCheckService.addDeviceCheck(deviceCheck);
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
        boolean deleteResult = deviceCheckService.deleteBatch(ids);

        HashMap<String,Object> map = new HashMap<>();

        if(deleteResult){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }
        return map;
    }




}
