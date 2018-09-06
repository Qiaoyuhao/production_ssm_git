package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.domain.schedule.VO.WorkVO;
import com.cskaoyan.domain.schedule.Work;
import com.cskaoyan.mapper.schedule.WorkMapper;
import com.cskaoyan.service.schedule.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:35 2018/8/31
 * @Modified By:
 */

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

    @Override
    public List<WorkVO> findWork() {

        List<WorkVO> workVOS = workMapper.selectAll();
        System.out.println(workVOS);

        return workVOS;
    }

    @Override
    public boolean addWork(Work work) {
        return workMapper.insert(work)==1;
    }

    @Override
    public boolean deleteWork(Integer workId) {
        return workMapper.deleteByPrimaryKey(String.valueOf(workId))==1;
    }

    @Override
    public boolean updateWork(Work work) {
        return workMapper.updateByPrimaryKey(work)==1;
    }

    @Override
    public boolean updateWorkSelective(Work work) {
        return workMapper.updateByPrimaryKeySelective(work)==1;
    }

    @Override
    public List<WorkVO> findWorkByCondition(HashMap map) {

        return workMapper.selectByCondition(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWorks(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id : ids) {
            i = workMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
//            int a = 1 / 0;
        }
        return count==ids.length;
    }


    @Override
    public WorkVO findWorkById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }
}

