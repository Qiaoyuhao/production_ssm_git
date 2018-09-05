package com.cskaoyan.service.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.TechnologyRequirement;
import com.cskaoyan.domain.technology.TechnologyRequirementVO;
import org.springframework.stereotype.Service;

@Service
public interface TechnologyRequirementService {
    EUDataGridResult getList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementVO);

    boolean findTechnologyRequirementById(String technologyRequirementId);

    boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean deleteTechnologyByIds(String[] ids) throws Exception;

    boolean updateTechnologyPlan(TechnologyRequirement technologyRequirement);

    EUDataGridResult searchTechnologyRequirementById(Integer page, Integer rows, String searchValue);
}
