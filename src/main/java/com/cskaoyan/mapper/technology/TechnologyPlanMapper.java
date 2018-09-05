package com.cskaoyan.mapper.technology;

import com.cskaoyan.domain.technology.TechnologyPlan;
import com.cskaoyan.domain.technology.TechnologyPlanVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    Long count();

    List<TechnologyPlanVO> selectAll();

    String findtechnologyName();

    List<TechnologyPlanVO> selectTechnologyPlansBytechnologyPlanName(String searchValue);

    Long countBytechnologyPlanName(String searchValue);

    List<TechnologyPlanVO> selectTechnologyPlansBytechnologyPlanId(String searchValue);

    Long countBytechnologyPlanId(String searchValue);
}