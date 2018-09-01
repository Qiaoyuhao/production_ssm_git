package com.cskaoyan.service.scheduleMonitor;

import com.cskaoyan.domain.scheduleMonitor.Custom;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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
}
