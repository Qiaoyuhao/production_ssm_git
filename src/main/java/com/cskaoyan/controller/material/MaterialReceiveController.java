package com.cskaoyan.controller.material;


import com.cskaoyan.domain.material.Material;
import com.cskaoyan.domain.material.MaterialReceive;
import com.cskaoyan.service.material.MaterialReceiveService;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;


@Controller
public class MaterialReceiveController {

    //自动注入service对象
    @Autowired
    private MaterialReceiveService materialReceiveService;

    @Autowired
    private MaterialService materialService;

    //跳转物料收入信息页面
    @RequestMapping("materialReceive/find")
    public ModelAndView findReceive(ModelAndView modelAndView){
        modelAndView.setViewName("materialReceive_list");
        return modelAndView;
    }
    //分页显示所有物料收入信息
    @RequestMapping("materialReceive/list")
    @ResponseBody
    public HashMap selectAllReceive(Integer page,Integer rows){
        HashMap hashMap = materialReceiveService.selectAllReceive(page,rows);
        return hashMap;
    }
    //通过点击物料编号来打开物料信息框
    @RequestMapping("material/get/{materialId}")
    @ResponseBody
    public Material selectMaterialById(Material material){
        String materialId = material.getMaterialId();
        //让materialService来进行查询
        Material material1 = materialService.selectMaterialById(materialId);
        return material1;
    }


    //新增编辑物料收入时的 选择物料编号 下拉列表，返回的是所有物料
    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> getMaterialData(){
        List<Material> materialList = materialService.selectAllMaterial();
        return materialList;
    }


    //判断是否可以执行新增操作
    @RequestMapping("materialReceive/add_judge")
    @ResponseBody
    public String addJudge(){
        return "materialReceive_list";
    }
    // 跳转到add.jsp 进行新增
    @RequestMapping("materialReceive/add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("materialReceive_add");
        return modelAndView;
    }
    //执行新增操作
    @RequestMapping("materialReceive/insert")
    @ResponseBody
    public HashMap insertReceive(MaterialReceive materialReceive){
        HashMap hashMap = materialReceiveService.insertReceive(materialReceive);
        return hashMap;
    }



    //判断是否可以编辑
    @RequestMapping("materialReceive/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "materialReceive_list";
    }
    //跳转编辑页面
    @RequestMapping("materialReceive/edit")
    public ModelAndView edit(ModelAndView modelAndView){
        modelAndView.setViewName("materialReceive_edit");
        return modelAndView;
    }
    //编辑物料收入
    @RequestMapping("materialReceive/update_all")
    @ResponseBody
    public HashMap editReceive(MaterialReceive materialReceive){
        HashMap hashMap = materialReceiveService.editReceive(materialReceive);
        return hashMap;
    }


    //判断是否可以进行删除
    @RequestMapping("materialReceive/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "materialReceive_list";
    }
    //删除
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public HashMap deleteReceive(String ids){
        HashMap hashMap = materialReceiveService.deleteReceive(ids);
        return hashMap;
    }
}
