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

    @Override
    public List<DeviceType> find() {

        List<DeviceType> list = deviceTypeMapper.listType();
        return list;
    }

    @Override
    public boolean addDeviceType(DeviceType deviceType) {

        int i = deviceTypeMapper.insertSelective(deviceType);

        return i!=0;
    }

    @Override
    public boolean deleteBatch(String[] ids) {
        int i = deviceTypeMapper.deleteBatch(ids);
        if(i>=0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(DeviceType deviceType) {

        int i = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);

        if(i>=0){
            return true;
        } else {
            return false;
        }
    }
}
