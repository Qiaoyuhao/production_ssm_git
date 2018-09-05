package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.domain.device.DeviceType;
import com.cskaoyan.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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





}
