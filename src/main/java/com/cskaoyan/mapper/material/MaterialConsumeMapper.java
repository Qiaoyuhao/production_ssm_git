package com.cskaoyan.mapper.material;


import com.cskaoyan.domain.material.MaterialConsume;

import java.util.List;

public interface MaterialConsumeMapper {

    //分页显示所有消耗信息
    List<MaterialConsume> selectAllConsume();

    //查找通过 编号 查询 物料消耗信息
    MaterialConsume selectConsumeById(String consumeId);
    //进行新增操作
    void insertConsume(MaterialConsume materialConsume);
    //编辑操作
    int editConsume(MaterialConsume materialConsume);
    //删除操作
    void deleteConsume(String id);

    List<MaterialConsume> searchMaterialConsumeByConsumeId(String searchValue);

    List<MaterialConsume> searchMaterialConsumeByWorkId(String searchValue);

    List<MaterialConsume> searchMaterialConsumeByMaterialId(String searchValue);

    int updateMaterialReceiveNote(MaterialConsume materialConsume);
}