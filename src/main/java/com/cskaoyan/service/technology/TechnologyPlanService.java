package com.cskaoyan.service.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.TechnologyPlan;
import com.cskaoyan.domain.technology.TechnologyPlanVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnologyPlanService {
    EUDataGridResult getList(Integer page, Integer rows, TechnologyPlanVO technologyPlanVO);

    TechnologyPlan get(String technologyPlanId);

    boolean findTechnologyPlanById(String technologyPlanId);

    boolean insertTechnologyPlan(TechnologyPlan technologyPlan);

    boolean deleteTechnologyByIds(String[] ids) throws Exception;

    boolean updateTechnologyPlan(TechnologyPlan technologyPlan);

    EUDataGridResult search_technologyPlan_by_technologyName(Integer page, Integer rows, String searchValue);

    EUDataGridResult search_technologyPlan_by_technologyPlanId(Integer page, Integer rows, String searchValue);

    List<TechnologyPlanVO> findtechnologyPlan();

}
