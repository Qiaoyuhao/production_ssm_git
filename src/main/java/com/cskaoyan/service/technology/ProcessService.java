package com.cskaoyan.service.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Process;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProcessService {
    EUDataGridResult getList(Integer page, Integer rows, Process process);

    boolean findprocessById(String processId);

    boolean insertProcess(Process process);

    boolean deleteProcessByIds(String[] ids) throws Exception;

    Process getProcessById(String processId);

    List<Process> findProcesses();

    EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String searchValue);

    EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue);

    boolean updateProcess(Process process);
}
