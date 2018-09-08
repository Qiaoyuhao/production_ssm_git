package com.cskaoyan.service.material.impl;

import com.cskaoyan.domain.material.MaterialConsume;
import com.cskaoyan.mapper.material.MaterialConsumeMapper;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialConsumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialConsumeMapper materialConsumeMapper;

    //分页显示所有消耗信息
    @Override
    public HashMap selectAllConsume(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);

        List<MaterialConsume> consumes = materialConsumeMapper.selectAllConsume();

        PageInfo<MaterialConsume> materialConsumePageInfo = new PageInfo<>(consumes);
        long total = materialConsumePageInfo.getTotal();

        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",consumes);

        return map;
    }

    //新增消耗信息
    @Override
    public HashMap insertConsume(MaterialConsume materialConsume) {

        HashMap<Object, Object> map = new HashMap<>();
        //        //判断要新增的consumeId是否已经存在
        String consumeId = materialConsume.getConsumeId();
        MaterialConsume ret = materialConsumeMapper.selectConsumeById(consumeId);
        if(ret!=null){
            map.put("msg","该物料消耗编号已经存在！");
        }else{
            materialConsumeMapper.insertConsume(materialConsume);
            map.put("status",200);
        }
        return map;
    }

    //编辑消耗
    @Override
    public HashMap editConsume(MaterialConsume materialConsume) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //执行编辑操作，判断是否执行成功
        int i = materialConsumeMapper.editConsume(materialConsume);
        if (i==1){
            //更新成功
            hashMap.put("status",200);
        }else{
            hashMap.put("msg","修改失败");
        }
        return hashMap;

    }

    //删除消耗
    @Transactional
    @Override
    public HashMap deleteConsume(String ids) {
        //分割字符串
        String[] split = ids.split(",");
        for (String id:split) {
            //执行删除操作
            materialConsumeMapper.deleteConsume(id);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status",200);

        return hashMap;
    }

    @Override
    public HashMap searchMaterialConsumeByConsumeId(String searchValue, Integer page, Integer rows) {
        searchValue = "%" + searchValue + "%";

        PageHelper.startPage(page, rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.searchMaterialConsumeByConsumeId(searchValue);
        HashMap hashMap = myPageHelper(materialConsumes);
        return hashMap;
    }

    /**
     * 根据作业编号模糊搜索
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @Override
    public HashMap searchMaterialConsumeByWorkId (String searchValue, Integer page, Integer rows){
        searchValue = "%" + searchValue + "%";

        PageHelper.startPage(page, rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.searchMaterialConsumeByWorkId(searchValue);
        HashMap hashMap = myPageHelper(materialConsumes);
        return hashMap;
    }

    /**
     * 根据物料编号模糊搜索
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @Override
    public HashMap searchMaterialConsumeByMaterialId (String searchValue, Integer page, Integer rows){
        searchValue = "%" + searchValue + "%";

        PageHelper.startPage(page, rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.searchMaterialConsumeByMaterialId(searchValue);
        HashMap hashMap = myPageHelper(materialConsumes);
        return hashMap;
    }


    /**
     * 更新备注
     * @param materialConsume
     * @return
     */
    @Override
    public HashMap updateMaterialConsumeNote(MaterialConsume materialConsume) {
        HashMap<String, Object> hashMap = new HashMap<>();

        if(materialConsume.getNote() !=null && !materialConsume.getNote().isEmpty()){
            int i=materialConsumeMapper.updateMaterialReceiveNote(materialConsume);
            if (i==1){
                hashMap.put("status",200);
            }else{
                hashMap.put("msg","更新备注失败");
            }
        }else{
            hashMap.put("msg","备注为空");
        }
        return hashMap;
    }

    /**
     * 提取分页
     */
    private static HashMap myPageHelper (List < MaterialConsume > list) {

        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    /**
     * 更新物料信息剩余数量
     */
    private void updateMaterialRemaining (Integer remaining, String materialId){

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("remaining", remaining);
        hashMap.put("materialId", materialId);
        materialMapper.updateMaterialAmount(hashMap);
    }


}
