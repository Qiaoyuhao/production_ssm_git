package com.cskaoyan.service.device.impl;

import com.cskaoyan.domain.device.DeviceMaintain;
import com.cskaoyan.mapper.device.DeviceMaintainMapper;
import com.cskaoyan.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public List<DeviceMaintain> getList(DeviceMaintain deviceMaintain) {
        List<DeviceMaintain> list = deviceMaintainMapper.getList(deviceMaintain);
        return list;
    }
}
