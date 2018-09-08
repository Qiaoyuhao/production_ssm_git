package com.cskaoyan.service.material;


import com.cskaoyan.domain.material.MaterialConsume;

import java.util.HashMap;

public interface MaterialConsumeService {

    //分页查询所有消耗信息
    HashMap selectAllConsume(Integer page, Integer rows);

    //新增 消耗信息
    HashMap insertConsume(MaterialConsume materialConsume);

    //编辑
    HashMap editConsume(MaterialConsume materialConsume);

    //删除
    HashMap deleteConsume(String ids);

    HashMap searchMaterialConsumeByConsumeId(String searchValue, Integer page, Integer rows);

    HashMap searchMaterialConsumeByWorkId(String searchValue, Integer page, Integer rows);

    HashMap searchMaterialConsumeByMaterialId(String searchValue, Integer page, Integer rows);

    HashMap updateMaterialConsumeNote(MaterialConsume materialConsume);
}
