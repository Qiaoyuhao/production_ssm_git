package com.cskaoyan.service.device.impl;

import com.cskaoyan.domain.device.DeviceCheck;
import com.cskaoyan.mapper.device.DeviceCheckMapper;
import com.cskaoyan.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public List<DeviceCheck> getList(DeviceCheck deviceCheck) {

        List<DeviceCheck> list = deviceCheckMapper.getList(deviceCheck);

        return list;
    }

    @Override
    public boolean addDeviceCheck(DeviceCheck deviceCheck) {

        int i = deviceCheckMapper.insertSelective(deviceCheck);

        return i!=0;
    }

    @Override
    public boolean deleteBatch(String[] ids) {

        int i = deviceCheckMapper.deleteBatch(ids);
        if(i>=0){
            return true;
        } else {
            return false;
        }
    }
}
