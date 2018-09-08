package com.cskaoyan.service.material;



import com.cskaoyan.domain.material.MaterialReceive;

import java.util.HashMap;


public interface MaterialReceiveService {

    //分页查询所有收入信息
    HashMap selectAllReceive(Integer page, Integer rows);

    //增加操作
    HashMap insertReceive(MaterialReceive materialReceive);

    //编辑
    HashMap editReceive(MaterialReceive materialReceive);

    //删除
    HashMap deleteReceive(String ids);
}
