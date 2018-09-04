package com.cskaoyan.service.device.impl;

import com.cskaoyan.domain.device.DeviceType;
import com.cskaoyan.mapper.device.DeviceTypeMapper;
import com.cskaoyan.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public List<DeviceType> getList(DeviceType deviceType) {

        List<DeviceType> list = deviceTypeMapper.getList(deviceType);

        return list;
    }
}
