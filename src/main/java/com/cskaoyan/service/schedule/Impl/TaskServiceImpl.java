package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.domain.schedule.Task;
import com.cskaoyan.domain.schedule.VO.TaskVO;
import com.cskaoyan.mapper.schedule.TaskMapper;
import com.cskaoyan.service.schedule.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:34 2018/8/31
 * @Modified By:
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<TaskVO> findTask() {

        List<TaskVO> taskVOS = taskMapper.selectAll();
        System.out.println(taskVOS);

        return taskVOS;
    }

    @Override
    public boolean addTask(Task task) {
        return taskMapper.insert(task)==1;
    }

    @Override
    public boolean deleteTask(Integer taskId) {
        return taskMapper.deleteByPrimaryKey(String.valueOf(taskId))==1;
    }

    @Override
    public boolean updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task)==1;
    }

    @Override
    public boolean updateTaskSelective(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task)==1;
    }

    @Override
    public List<TaskVO> findTaskByCondition(HashMap map) {

        return taskMapper.selectByCondition(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteTasks(String[] ids) throws Exception {
        int i;
        int count = 0;
        for (String id : ids) {
            i = taskMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
//            int a = 1 / 0;
        }
        return count==ids.length;
    }


    @Override
    public Task findTaskById(String taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

}
