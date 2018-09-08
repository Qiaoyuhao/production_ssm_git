package com.cskaoyan.service.material.impl;

import com.cskaoyan.domain.material.Material;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    //分页显示所有物料信息
    @Override
    public List<Material> selectAllMaterial() {
        List<Material> materials = materialMapper.selectAllMaterial();
        return materials;
    }

    //新增物料
    @Override
    public HashMap insertMaterial(Material material) {
       HashMap<String, Object> hashMap = new HashMap<>();
       //根据id查询该物料编号是否已经存在
        String materialId = material.getMaterialId();
        Material ret = materialMapper.selectMaterialById(materialId);
       if (ret !=null){
           //物料信息编号已经存在，提示信息
           hashMap.put("msg","物料编号已经已经存在");
       }else{
          //物料信息编号不存在，执行添加操作
           materialMapper.insertMaterial(material);
           hashMap.put("status",200);
       }
        return hashMap;
    }


    //编辑物料信息
    @Override
    public HashMap editMaterial(Material material) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //修改成功返回为true
       int i = materialMapper.editMaterial(material);
       if (i ==1){
           hashMap.put("status",200);
       }else{
           hashMap.put("msg","更新失败");
       }
        return hashMap;
    }


    //删除操作
    @Override
    public HashMap deleteMaterial(String ids) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //因为删除是根据id来删除的，所以在jsp中传进来的是批量的多个id，但是在实际进行操作的时候，要进行分割
        String[] split = ids.split(",");
        for (String id:split){
            materialMapper.deleteMaterial(id);
            hashMap.put("status",200);
        }
        return hashMap;
    }

    /**
     * 从收入页面打开物料信息框
     * @param materialId
     * @return
     */
    @Transactional(readOnly=true)
    @Override
    public Material selectMaterialById(String materialId) {
        Material material = materialMapper.selectMaterialById(materialId);
        return material;
    }



}
