package com.cskaoyan.service.technology.impl;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Technology;
import com.cskaoyan.mapper.technology.TechnologyMapper;
import com.cskaoyan.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
public class TechnologyServiceImpl implements TechnologyService{

    @Autowired
    private TechnologyMapper technologyMapper;


    @Override
    @Transactional
    public EUDataGridResult getList(Integer page, Integer rows, Technology technology) {

        List<Technology> list = technologyMapper.selectAll();
        Long total = technologyMapper.count();

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }


    @Override
    public List<Technology> find() {
        List<Technology> list = technologyMapper.selectAll();
        return list;
    }

    @Override
    public boolean insertTechnology(Technology technology) {
        return technologyMapper.insert(technology)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteTechnologyByIds (String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id:ids) {
            i = technologyMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
        }
       return count == ids.length;
    }

    @Override
    public boolean updateTechnology(Technology technology) {
        return technologyMapper.updateByPrimaryKey(technology)==1;
    }

    @Override
    public boolean updateTechnologySelective(Technology technology) {
        return technologyMapper.updateByPrimaryKeySelective(technology)==1;
    }

    @Override
    public EUDataGridResult search_technology_by_technologyId(Integer page, Integer rows, Integer searchValue) {
        List<Technology> list = technologyMapper.selectTechnologysBytechnologyId(searchValue);
        Long total = technologyMapper.countBytechnologyId(searchValue);

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public EUDataGridResult search_technology_by_technologyName(Integer page, Integer rows, String searchValue) {
        List<Technology> list = technologyMapper.selectTechnologysBytechnologyName(searchValue);
        Long total = technologyMapper.countBytechnologyName(searchValue);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public boolean findTechonlogyById(String id) {
        return technologyMapper.selectByPrimaryKey(id) != null;
    }

    @Override
    public Technology findTechonlogy(String id) {
        return technologyMapper.selectByPrimaryKey(id);
    }

}
