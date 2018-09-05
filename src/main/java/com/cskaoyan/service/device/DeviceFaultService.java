package com.cskaoyan.service.device;

import com.cskaoyan.domain.device.DeviceFault;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceFaultService {
    List<DeviceFault> getList(DeviceFault deviceFault);

    boolean addDeviceFault(DeviceFault deviceFault);

    boolean deleteBatch(String[] ids);

}
