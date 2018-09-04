package com.cskaoyan.service.device;

import com.cskaoyan.domain.device.DeviceCheck;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceCheckService {
    List<DeviceCheck> getList(DeviceCheck deviceCheck);
}
