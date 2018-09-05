package com.cskaoyan.service.technology.impl;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.TechnologyRequirement;
import com.cskaoyan.domain.technology.TechnologyRequirementVO;
import com.cskaoyan.mapper.technology.TechnologyMapper;
import com.cskaoyan.mapper.technology.TechnologyRequirementMapper;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
public class TechnologyRequirementImpl implements TechnologyRequirementService{

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public EUDataGridResult getList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementVO) {
        List<TechnologyRequirementVO> list = technologyRequirementMapper.selectAll();
        Long total = technologyRequirementMapper.count();

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public boolean findTechnologyRequirementById(String id) {
        return technologyRequirementMapper.selectByPrimaryKey(id) != null;
    }

    @Override
    public boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.insert(technologyRequirement) == 1;
    }

    @Override
    public boolean deleteTechnologyByIds(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id:ids) {
            i = technologyRequirementMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
        }
        return count == ids.length;
    }

    @Override
    public boolean updateTechnologyPlan(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement) == 1;
    }

    @Override
    public EUDataGridResult searchTechnologyRequirementById(Integer page, Integer rows, String searchValue) {
        List<TechnologyRequirement> list = technologyRequirementMapper.selectTechnologysBytechnologyRequirementId(searchValue);
        Long total = technologyRequirementMapper.countBytechnologyRequirementId(searchValue);

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }
}
