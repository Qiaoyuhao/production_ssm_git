package com.cskaoyan.service.schedule;

import com.cskaoyan.domain.schedule.Task;
import com.cskaoyan.domain.schedule.VO.TaskVO;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:32 2018/8/31
 * @Modified By:
 */
public interface TaskService {

    List<TaskVO> findTask();

    boolean addTask(Task task);

    boolean deleteTask(Integer taskId);

    boolean updateTask(Task task);

    boolean updateTaskSelective(Task task);

    List<TaskVO> findTaskByCondition(HashMap map);

    boolean deleteTasks(String[] ids) throws Exception;

    Task findTaskById(String taskId);
}
