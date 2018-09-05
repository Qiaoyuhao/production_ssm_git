package com.cskaoyan.controller.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Technology;
import com.cskaoyan.domain.technology.TechnologyRequirement;
import com.cskaoyan.domain.technology.TechnologyRequirementVO;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import com.cskaoyan.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    private TechnologyRequirementService technologyRequirementService;

    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/find")
    public String find(){
        return "technologyRequirement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementVO)
            throws Exception {
        EUDataGridResult result = technologyRequirementService.getList(page, rows, technologyRequirementVO);
        return result;
    }

    @RequestMapping("/add_judge")
    public String addJudge() {
        return "technologyRequirement_add";
    }

    @RequestMapping("/add")
    public String add() {
        return "technologyRequirement_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        HashMap map = new HashMap();
        boolean ret1 = technologyRequirementService.findTechnologyRequirementById(technologyRequirement.getTechnologyRequirementId());
        if(ret1) {
            String msg = "该工艺计划编号已存在，请更换公益计划编号！";
            map.put("msg",msg);
        } else {
            boolean ret2 = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
            if(ret2) {
                String status = "200";
                map.put("status",status);
            } else {
                String msg = "添加失败，请重试";
                map.put("msg",msg);
            }
        }
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getData() throws Exception{
        List<Technology> list = technologyService.find();
        return list;
    }

    @RequestMapping("/delete_judge")
    public String deleteJudge() {
        return "technologyRequirement_list";
    }

    @RequestMapping(value = {"/delete_batch"})
    @ResponseBody
    public HashMap deleteTechnologyPlanByIds (String[] ids){
        boolean ret = false;
        try {
            ret = technologyRequirementService.deleteTechnologyByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap map = new HashMap();
        if(ret) {
            String status = "200";
            map.put("status",status);
        } else {
            String msg = "删除失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String editTechnologyRequirementById1() {
        return "technologyRequirement_edit";
    }

    @RequestMapping("/edit")
    public String editTechnologyRequirementById2() {
        return "technologyRequirement_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        boolean ret = technologyRequirementService.updateTechnologyPlan(technologyRequirement);
        HashMap map = new HashMap();
        if(ret) {
            String status = "200";
            map.put("status",status);
        } else {
            String msg = "修改客户失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    //根据工艺要求id查找
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows, String searchValue) throws Exception{
        EUDataGridResult result = technologyRequirementService
                .searchTechnologyRequirementById(page, rows, searchValue);
        return result;
    }

}
