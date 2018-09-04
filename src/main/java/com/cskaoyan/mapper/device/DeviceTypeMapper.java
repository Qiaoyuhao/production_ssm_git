package com.cskaoyan.mapper.device;


import com.cskaoyan.domain.device.DeviceType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> getList(DeviceType deviceType);
}