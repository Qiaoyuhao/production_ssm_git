package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceMaintain;
import com.cskaoyan.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
