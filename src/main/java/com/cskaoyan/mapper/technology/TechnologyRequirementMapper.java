package com.cskaoyan.mapper.technology;

import com.cskaoyan.domain.technology.TechnologyRequirement;
import com.cskaoyan.domain.technology.TechnologyRequirementVO;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRequirementMapper {

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    String findtechnologyName();

    Long count();

    List<TechnologyRequirementVO> selectAll();

    List<TechnologyRequirement> selectTechnologysBytechnologyRequirementId(String searchValue);

    Long countBytechnologyRequirementId(String searchValue);
}