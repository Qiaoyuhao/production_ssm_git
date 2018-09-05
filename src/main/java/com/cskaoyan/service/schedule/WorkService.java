package com.cskaoyan.service.schedule;

import com.cskaoyan.domain.schedule.VO.WorkVO;
import com.cskaoyan.domain.schedule.Work;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:33 2018/8/31
 * @Modified By:
 */
public interface WorkService {

    List<WorkVO> findWork();

    boolean addWork(Work work);

    boolean deleteWork(Integer workId);

    boolean updateWork(Work work);

    boolean updateWorkSelective(Work work);

    List<WorkVO> findWorkByCondition(HashMap map);

    boolean deleteWorks(String[] ids) throws Exception;

    Work findWorkById(String workId);

}
