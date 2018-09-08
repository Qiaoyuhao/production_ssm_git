package com.cskaoyan.mapper.material;



import com.cskaoyan.domain.material.Material;

import java.util.HashMap;
import java.util.List;


public interface MaterialMapper {

    //分页显示所有物料信息
    List<Material> selectAllMaterial();

    //根据id查询该物料详情
    Material selectMaterialById(String materialId);
    //添加操作
    void insertMaterial(Material material);
    //编辑
    int editMaterial(Material material);
    //删除
    void deleteMaterial(String id);

    int selectMaterialAmount(String materialId);

    void updateMaterialAmount(HashMap<String, Object> map);


}