package com.cskaoyan.service.device;

import com.cskaoyan.domain.device.DeviceMaintain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMaintainService {


    List<DeviceMaintain> getList(DeviceMaintain deviceMaintain);
}
