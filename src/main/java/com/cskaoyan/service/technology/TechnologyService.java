package com.cskaoyan.service.technology;


import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnologyService {

    EUDataGridResult getList(Integer page, Integer rows, Technology technology);

    List<Technology> find();

    boolean insertTechnology(Technology technology);

    boolean deleteTechnologyByIds(String[] ids) throws Exception;

    boolean updateTechnology(Technology technology);

    boolean updateTechnologySelective(Technology technology);

    EUDataGridResult search_technology_by_technologyId(Integer page, Integer rows, Integer searchValue);

    EUDataGridResult search_technology_by_technologyName(Integer page, Integer rows, String searchValue);

    boolean findTechonlogyById(String technologyId);

    Technology findTechonlogy(String technologyId);
}
