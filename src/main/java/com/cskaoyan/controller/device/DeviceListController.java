package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Device> getList(Device device){
        List<Device> list = deviceService.getList(device);
        return list;
    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public String addJudge(){
        // TODO 权限管理
        return "/deviceList_add";
    }

    @RequestMapping("/add")
    public String add(){
        return "deviceList_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap<String,Object> insert(Device device){
        System.out.println("device = " + device);

        boolean isAdd = deviceService.addDevice(device);

        HashMap<String,Object> map = new HashMap<>();

        if(isAdd){
            map.put("msg","OK");
            map.put("status",200);
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

        boolean deleteResult = deviceService.deleteBatch(ids);

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
        return "deviceList_edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public HashMap<String,Object> update(Device device){

        boolean updateResult = deviceService.update(device);

        HashMap<String,Object> map = new HashMap<>();

        if(updateResult){
            map.put("msg","OK");
            map.put("status",200);
            map.put("data",null);
        }
        return map;
    }


    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public List<Device> searchDeviceByDeviceId(String searchValue){
        List<Device> list = deviceService.searchDeviceByDeviceId(searchValue);
        return list;
    }


    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public List<Device> searchDeviceByDeviceName(String searchValue){
        List<Device> list = deviceService.searchDeviceByDeviceName(searchValue);
        return list;
    }


    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public List<Device> searchDeviceByDeviceTypeName(String searchValue){
        List<Device> list = deviceService.searchDeviceByDeviceTypeName(searchValue);
        return list;
    }














}
