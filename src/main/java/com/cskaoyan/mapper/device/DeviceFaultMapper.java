package com.cskaoyan.mapper.device;

import com.cskaoyan.domain.device.DeviceFault;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    List<DeviceFault> getList(DeviceFault deviceFault);
}