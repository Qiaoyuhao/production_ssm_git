package com.cskaoyan.service.technology.impl;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.TechnologyPlan;
import com.cskaoyan.domain.technology.TechnologyPlanVO;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
import com.cskaoyan.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService{

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public EUDataGridResult getList(Integer page, Integer rows, TechnologyPlanVO technologyPlanVO) {
        List<TechnologyPlanVO> list = technologyPlanMapper.selectAll();
        Long total = technologyPlanMapper.count();

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public TechnologyPlan get(String technologyPlanId) {
        return technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
    }

    @Override
    public boolean findTechnologyPlanById(String id) {
        return technologyPlanMapper.selectByPrimaryKey(id) != null;
    }

    @Override
    public boolean insertTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.insert(technologyPlan)==1;
    }

    @Override
    public boolean deleteTechnologyByIds(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id:ids) {
            i = technologyPlanMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
        }
        return count == ids.length;
    }

    @Override
    public boolean updateTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.updateByPrimaryKey(technologyPlan)==1;
    }

    @Override
    public EUDataGridResult search_technologyPlan_by_technologyName(Integer page, Integer rows, String searchValue) {
        List<TechnologyPlanVO> list = technologyPlanMapper.selectTechnologyPlansBytechnologyPlanName(searchValue);
        Long total = technologyPlanMapper.countBytechnologyPlanName(searchValue);

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public EUDataGridResult search_technologyPlan_by_technologyPlanId(Integer page, Integer rows, String searchValue) {
        List<TechnologyPlanVO> list = technologyPlanMapper.selectTechnologyPlansBytechnologyPlanId(searchValue);
        Long total = technologyPlanMapper.countBytechnologyPlanId(searchValue);

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public List<TechnologyPlanVO> findtechnologyPlan() {
        return technologyPlanMapper.selectAll();
    }
}
