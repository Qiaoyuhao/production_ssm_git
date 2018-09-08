package com.cskaoyan.service.material;



import com.cskaoyan.domain.material.Material;

import java.util.HashMap;
import java.util.List;

public interface MaterialService {

    //分页显示所有物料信息
    List<Material> selectAllMaterial();
    ////通过点击物料编号来打开物料信息框
    Material selectMaterialById(String materialId);

    //新增物料
    HashMap insertMaterial(Material material);

    //编辑
    HashMap editMaterial(Material material);
    //删除
    HashMap deleteMaterial(String ids);


}
