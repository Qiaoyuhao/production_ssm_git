package com.cskaoyan.service.device;

import com.cskaoyan.domain.device.DeviceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceTypeService {
    List<DeviceType> getList(DeviceType deviceType);

    List<DeviceType> find();

    boolean addDeviceType(DeviceType deviceType);

    boolean deleteBatch(String[] ids);

    boolean update(DeviceType deviceType);
}
