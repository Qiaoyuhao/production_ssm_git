package com.cskaoyan.mapper.technology;

import com.cskaoyan.domain.technology.Technology;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyMapper {

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectAll();

    Long count();

    List<Technology> selectTechnologysBytechnologyId(Integer id);

    Long countBytechnologyId(Integer id);

    List<Technology> selectTechnologysBytechnologyName(String searchValue);

    Long countBytechnologyName(String searchValue);
}