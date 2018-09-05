package com.cskaoyan.mapper.device;


import com.cskaoyan.domain.device.Device;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> find(Device device);

    int deleteBatch(String[] ids);

    List<Device> searchDeviceByDeviceId(String deviceId);

    List<Device> searchDeviceByDeviceName(String searchValue);

    List<Device> searchDeviceByDeviceTypeName(String searchValue);

    List<Device> getData();
}