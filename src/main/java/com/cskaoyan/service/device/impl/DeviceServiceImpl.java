package com.cskaoyan.service.device.impl;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.mapper.device.DeviceMapper;
import com.cskaoyan.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> getList(Device device) {
        List<Device> list = deviceMapper.find(device);

        return list;
    }

    @Override
    public boolean addDevice(Device device) {

        int i = deviceMapper.insertSelective(device);

        return i!=0;
    }

    @Override
    public boolean deleteBatch(String[] ids) {

        int i = deviceMapper.deleteBatch(ids);
        if(i>=0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Device device) {

        int i = deviceMapper.updateByPrimaryKeySelective(device);

        if(i>=0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Device> searchDeviceByDeviceId(String deviceId) {

        List<Device> list = deviceMapper.searchDeviceByDeviceId(deviceId);

        return list;
    }

    @Override
    public List<Device> searchDeviceByDeviceName(String searchValue) {

        List<Device> list = deviceMapper.searchDeviceByDeviceName(searchValue);

        return list;
    }

    @Override
    public List<Device> searchDeviceByDeviceTypeName(String searchValue) {

        List<Device> list = deviceMapper.searchDeviceByDeviceTypeName(searchValue);

        return list;
    }

    @Override
    public List<Device> find() {
        List<Device> deviceList = deviceMapper.getData();
        return deviceList;
    }
}
