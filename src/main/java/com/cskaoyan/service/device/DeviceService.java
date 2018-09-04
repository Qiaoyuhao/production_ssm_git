package com.cskaoyan.service.device;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.device.Device;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceService {

    List<Device> getList(Device device);

    boolean addDevice(Device device);

    boolean deleteBatch(String[] ids);

    boolean update(Device device);

    List<Device> searchDeviceByDeviceId(String searchValue);

    List<Device> searchDeviceByDeviceName(String searchValue);

    List<Device> searchDeviceByDeviceTypeName(String searchValue);
}
