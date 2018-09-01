package com.cskaoyan.service.scheduleMonitor.Impl;

import com.cskaoyan.domain.scheduleMonitor.Custom;
import com.cskaoyan.mapper.scheduleMonitor.CustomMapper;
import com.cskaoyan.service.scheduleMonitor.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 10:46 2018/8/31
 * @Modified By:
 */

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;


    /**
     * @Author: QiaoYuhao
     * @Description: 无条件查询
     * @param:
     * @return: List<Custom> 查询的list
     */
    @Override
    public List<Custom> findCustom() {
        List<Custom> customs = customMapper.selectAll();
        return customs;

    }

    /**
     * @Author: QiaoYuhao
     * @Description: 添加客户操作，添加传入的客户对象的全部信息
     * @param: custom
     * @return: boolean
     */
    @Override
    public boolean addCustom(Custom custom) {

        return customMapper.insert(custom) == 1;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 删除单条信息
     * @param: customId
     * @return: boolean
     */
    @Override
    public boolean deleteCustom(Integer customId) {
        return customMapper.deleteByPrimaryKey(String.valueOf(customId)) == 1;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 更新单条数据的全部信息
     * @param: custom
     * @return: boolean
     */
    @Override
    public boolean updateCustom(Custom custom) {

        return customMapper.updateByPrimaryKey(custom) == 1;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 更新可选的信息(属性为null则不更新)
     * @param: custom
     * @return: boolean
     */
    @Override
    public boolean updateCustomSelective(Custom custom) {
        return customMapper.updateByPrimaryKeySelective(custom) == 1;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 多条件查询
     * @param: map
     * @return: List<Custom>
     */
    @Override
    public List<Custom> findCustomByCondition(HashMap map) {
        List<Custom> customs = customMapper.selectByCondition(map);
        return customs;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 批量删除操作，如果操作中出现失败则回滚
     * @param: ids 批量删除的对象的主键数组
     * @return: boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCustoms(String[] ids) throws Exception {

        int i;
        int count = 0;
        for (String id : ids) {
            i = customMapper.deleteByPrimaryKey(id);
            count += i;
            if (i == 0) {
                throw new Exception("删除失败,执行回滚");
            }
//            int a = 1 / 0;
        }
        return count==ids.length;
    }


}
