package com.cskaoyan.service.schedule;

import com.cskaoyan.domain.schedule.Custom;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 10:48 2018/8/31
 * @Modified By:
 */
public interface CustomService {

    List<Custom> findCustom();

    boolean addCustom(Custom custom);

    boolean deleteCustom(Integer customId);

    boolean updateCustom(Custom custom);

    boolean updateCustomSelective(Custom custom);

    List<Custom> findCustomByCondition(HashMap map);

    boolean deleteCustoms(String[] ids) throws Exception;

    Custom findCustomById(String customId);
}
