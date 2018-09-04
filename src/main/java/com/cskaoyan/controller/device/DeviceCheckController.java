package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceCheck;
import com.cskaoyan.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
