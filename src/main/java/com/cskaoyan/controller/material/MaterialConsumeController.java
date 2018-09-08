package com.cskaoyan.controller.material;


import com.cskaoyan.domain.material.MaterialConsume;
import com.cskaoyan.service.material.MaterialConsumeService;
import com.cskaoyan.service.material.MaterialService;
import com.cskaoyan.service.schedule.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;

@Controller
public class MaterialConsumeController {

    @Autowired
    private MaterialConsumeService materialConsumeService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private WorkService workService;

    //跳转到物料消耗页面
    @RequestMapping("materialConsume/find")
    public ModelAndView findRConsume(ModelAndView modelAndView){
        modelAndView.setViewName("materialConsume_list");
        return modelAndView;
    }
    //分页显示所有消耗信息
    @RequestMapping("materialConsume/list")
    @ResponseBody
    public HashMap selectAllConsume(Integer page,Integer rows){
        System.out.println("contr list");
        HashMap hashMap = materialConsumeService.selectAllConsume(page,rows);
        return hashMap;
    }

   /* //点击 所属作业  来打开  工作表对话框
    @RequestMapping("/work/get/{workId}")
    @ResponseBody
    public Work selectWorkById (Work work){
        String workId = work.getWorkId();
        return workService.findWorkById(workId);
    }*/
    /*//点击 物料 来打开  物料信息对话框
    @RequestMapping("material/get/{materialId}")
    @ResponseBody
    public Material selectMaterialById(Material material){
        String materialId = material.getMaterialId();
        //让materialService来进行查询
        Material material1 = materialService.selectMaterialById(materialId);
        return material1;
    }
*/

    //判断新增 并 跳转到 新增对话框
    @RequestMapping(value = {"materialConsume/add_judge","materialConsume/add"})
    public ModelAndView addJudge(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("materialConsume_add");
        return modelAndView;
    }
    //进行新增操作
    @RequestMapping("materialConsume/insert")
    @ResponseBody
    public HashMap insertConsume (MaterialConsume materialConsume,String materialConsumeParams){
        System.out.println("contr insert");
        materialConsume.setConsumeDate(new Date());
        HashMap hashMap = materialConsumeService.insertConsume(materialConsume);
        return hashMap;
    }

    //判断编辑 并跳转到 编辑对话框
    @RequestMapping(value = {"materialConsume/edit_judge","materialConsume/edit"})
    public ModelAndView editJudge(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("materialConsume_edit");
        return modelAndView;
    }
    //进行编辑操作
    @RequestMapping("materialConsume/update_all")
    @ResponseBody
    public HashMap editConsume(MaterialConsume materialConsume){
        HashMap hashMap = materialConsumeService.editConsume(materialConsume);
        return hashMap;
    }

    //判断是否可以进行删除
    @RequestMapping("materialConsume/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "materialConsume_list";
    }
    //删除
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public HashMap deleteConsume(String ids){
        HashMap hashMap = materialConsumeService.deleteConsume(ids);
        return hashMap;
    }

    /**
     * 根据作业编号模糊搜索
     */
    @RequestMapping("materialConsume/search_materialConsume_by_workId")
    @ResponseBody
    public HashMap searchMaterialConsumeByWorkId(String searchValue,Integer page,Integer rows){
        return  materialConsumeService.searchMaterialConsumeByWorkId(searchValue,page,rows);
    }

    /**
     * 根据物料编号模糊搜索
     */
    @RequestMapping("materialConsume/search_materialConsume_by_materialId")
    @ResponseBody
    public HashMap searchMaterialConsumeByMaterialId(String searchValue,Integer page,Integer rows){
        return materialConsumeService.searchMaterialConsumeByMaterialId(searchValue,page,rows);
    }

    /**
     * 更新备注
     */
    @RequestMapping("materialConsume/update_note")
    @ResponseBody
    public HashMap updateMaterialConsumeNote(MaterialConsume materialConsume){
        return materialConsumeService.updateMaterialConsumeNote(materialConsume);
    }





}
