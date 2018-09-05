package com.cskaoyan.mapper.technology;

import com.cskaoyan.domain.technology.Process;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> selectAll();

    Long count();

    List<Process> selectProcessesByProcessId(String searchValue);

    Long countByProcessId(String searchValue);

    List<Process> selectProcessesBytechnologyPlanId(String searchValue);

    Long countBytechnologyPlanId(String searchValue);
}
