package com.cskaoyan.service.technology.impl;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Process;
import com.cskaoyan.mapper.technology.ProcessMapper;
import com.cskaoyan.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;


    @Override
    public EUDataGridResult getList(Integer page, Integer rows, Process process) {
        List<Process> list = processMapper.selectAll();
        Long total = processMapper.count();

        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public boolean findprocessById(String id) {
        return processMapper.selectByPrimaryKey(id) != null;
    }

    @Override
    public boolean insertProcess(Process process) {
        return processMapper.insertSelective(process) == 1;
    }

    @Override
    public boolean deleteProcessByIds(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id:ids) {
            i = processMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
        }
        return count == ids.length;
    }

    @Override
    public Process getProcessById(String processId) {
        return processMapper.selectByPrimaryKey(processId);
    }

    @Override
    public List<Process> findProcesses() {
        return processMapper.selectAll();
    }

    @Override
    public EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String searchValue) {
        List<Process> list = processMapper.selectProcessesByProcessId(searchValue);
        Long total = processMapper.countByProcessId(searchValue);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue) {
        List<Process> list = processMapper.selectProcessesBytechnologyPlanId(searchValue);
        Long total = processMapper.countBytechnologyPlanId(searchValue);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(total);
        //取记录总条数

        return result;
    }

    @Override
    public boolean updateProcess(Process process) {
        return processMapper.updateByPrimaryKeySelective(process) == 1;
    }
}
