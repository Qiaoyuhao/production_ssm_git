package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceType;
import com.cskaoyan.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public List<DeviceType> getTypeList(DeviceType deviceType){

        List<DeviceType> list = deviceTypeService.getList(deviceType);

        return list;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> getData(){
        List<DeviceType> list = deviceTypeService.find();
        return list;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return null;
    }

    @RequestMapping("/add")
    public String add(){
        return "deviceType_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap<String,Object> insert(DeviceType deviceType){
        boolean isAdd = deviceTypeService.addDeviceType(deviceType);
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
        boolean deleteResult = deviceTypeService.deleteBatch(ids);

        HashMap<String,Object> map = new HashMap<>();

        if(deleteResult){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }
        return map;
    }


    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return null;
    }

    @RequestMapping("/edit")
    public String edit(){
        return "deviceType_edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public HashMap<String,Object> update(DeviceType deviceType){

        boolean updateResult = deviceTypeService.update(deviceType);

        HashMap<String,Object> map = new HashMap<>();

        if(updateResult){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }
        return map;
    }






}
