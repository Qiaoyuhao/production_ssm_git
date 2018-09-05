package com.cskaoyan.service.device.impl;

import com.cskaoyan.domain.device.DeviceFault;
import com.cskaoyan.mapper.device.DeviceFaultMapper;
import com.cskaoyan.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public List<DeviceFault> getList(DeviceFault deviceFault) {
        return deviceFaultMapper.getList(deviceFault);
    }

    @Override
    public boolean addDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.insertSelective(deviceFault);

        return i!=0;
    }

    @Override
    public boolean deleteBatch(String[] ids) {

        int i = deviceFaultMapper.deleteBatch(ids);
        if(i>=0){
            return true;
        } else {
            return false;
        }
    }
}
