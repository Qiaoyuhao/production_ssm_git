package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.domain.schedule.Manufacture;
import com.cskaoyan.domain.schedule.VO.ManufactureVO;
import com.cskaoyan.mapper.schedule.ManufactureMapper;
import com.cskaoyan.service.schedule.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:33 2018/8/31
 * @Modified By:
 */

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public List<ManufactureVO> findManufacture() {

        List<ManufactureVO> manufactureList = manufactureMapper.selectAll();
        System.out.println(manufactureList);

        return manufactureList;
    }

    @Override
    public boolean addManufacture(Manufacture manufacture) {
        return manufactureMapper.insert(manufacture)==1;
    }

    @Override
    public boolean deleteManufacture(Integer manufactureSn) {
        return manufactureMapper.deleteByPrimaryKey(String.valueOf(manufactureSn))==1;
    }

    @Override
    public boolean updateManufacture(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKey(manufacture)==1;
    }

    @Override
    public boolean updateManufactureSelective(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKeySelective(manufacture)==1;
    }

    @Override
    public List<ManufactureVO> findManufactureByCondition(HashMap map) {

        return manufactureMapper.selectByCondition(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteManufactures(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id : ids) {
            i = manufactureMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
//            int a = 1 / 0;
        }
        return count==ids.length;
    }


    @Override
    public Manufacture findManufactureById(String manufactureSn) {
        return manufactureMapper.selectByPrimaryKey(manufactureSn);
    }

}
