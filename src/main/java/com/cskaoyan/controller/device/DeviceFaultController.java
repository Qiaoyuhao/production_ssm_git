package com.cskaoyan.controller.device;

import com.cskaoyan.domain.device.DeviceFault;
import com.cskaoyan.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
