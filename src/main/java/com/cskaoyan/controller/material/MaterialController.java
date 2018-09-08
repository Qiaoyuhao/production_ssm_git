package com.cskaoyan.controller.material;

import com.cskaoyan.domain.material.Material;
import com.cskaoyan.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/material")
public class MaterialController {


    @Autowired
    private MaterialService materialService;

    //跳转到物料信息页面
    @RequestMapping("/find")
    public ModelAndView findMaterial(ModelAndView modelAndView){
        modelAndView.setViewName("material_list");
        return modelAndView;
    }
    //分页查询所有物料信息记录
    @RequestMapping("/list")
    @ResponseBody
    public HashMap selectAllMaterial(Integer page, Integer rows){
        PageHelper.startPage(page, rows);
        List<Material> materials = materialService.selectAllMaterial();
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        long total = pageInfo.getTotal();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",materials);

        return hashMap;
    }


    //新增
    //跳转到增加页面
    @RequestMapping(value = {"/add_judge", "/add"})
    public ModelAndView addJudge(ModelAndView modelAndView){
        modelAndView.setViewName("material_add");
        return modelAndView;
    }
    //进行增加操作
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertMaterial(Material material){
        HashMap hashMap = materialService.insertMaterial(material);
        return hashMap;
    }


    //跳转到物料信息编辑页面
    @RequestMapping( value = {"/edit_judge","/edit"})
    public ModelAndView findMaterialEdit(ModelAndView modelAndView){
        modelAndView.setViewName("material_edit");
        return modelAndView;
    }
    //编辑更新物料信息
    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap editMaterial(Material material){
        HashMap hashMap = materialService.editMaterial(material);
        return hashMap;
    }


    // 判断身份权限，管理员跳转到删除物料信息操作
    @RequestMapping("/delete_judge")
    public ModelAndView deleteJudge(ModelAndView modelAndView){
       modelAndView.setViewName("material_list");
        return modelAndView;
    }
    //执行删除操作
    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteMaterial(String ids){
        HashMap hashMap = materialService.deleteMaterial(ids);
        return hashMap;
    }





}
