package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceCheck;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    List<DeviceCheck> getList(DeviceCheck deviceCheck);
}