package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceMaintain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    List<DeviceMaintain> getList(DeviceMaintain deviceMaintain);

}