package com.cskaoyan.service.material.impl;

import com.cskaoyan.domain.material.MaterialReceive;
import com.cskaoyan.mapper.material.MaterialReceiveMapper;
import com.cskaoyan.service.material.MaterialReceiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    //自动注入dao层对象
    @Autowired
    private MaterialReceiveMapper materialReceiveMapper;

    //分页查询所有收入信息
    @Override
    public HashMap selectAllReceive(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectAllReceive();

        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(materialReceives);
        long total = pageInfo.getTotal();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",materialReceives);

        return hashMap;
    }

    //新增收入
    @Override
    public HashMap insertReceive(MaterialReceive materialReceive) {

       HashMap<String, Object> hashMap = new HashMap<>();
        String receiveId = materialReceive.getReceiveId();
        //判断要加入的收入编号是否已经存在
        MaterialReceive ret = materialReceiveMapper.selectReceiveById(receiveId);
       if (ret != null){
           //收入编号已经存在，则输出错误信息
           hashMap.put("msg","物料收入编号已存在！");
       }else{
           //物料收入编号不存在，执行新增操作
           materialReceiveMapper.insertReceive(materialReceive);
           hashMap.put("status",200);
       }
       return hashMap;
    }

    //编辑物料信息
    @Override
    public HashMap editReceive(MaterialReceive materialReceive) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //执行编辑操作，判断是否执行成功
        int i = materialReceiveMapper.editReceive(materialReceive);
        if (i==1){
            //更新成功
            hashMap.put("status",200);
        }else{
            hashMap.put("msg","修改失败");
        }
        return hashMap;
    }

    //删除收入
    @Transactional
    @Override
    public HashMap deleteReceive(String ids) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //分割字符串
        String[] split = ids.split(",");
        for (String id:split) {
            //执行删除操作
             materialReceiveMapper.deleteReceive(id);
             hashMap.put("status",200);
        }
        return hashMap;
    }


}
