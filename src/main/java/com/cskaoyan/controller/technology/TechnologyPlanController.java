package com.cskaoyan.controller.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.TechnologyPlan;
import com.cskaoyan.domain.technology.TechnologyPlanVO;
import com.cskaoyan.service.technology.TechnologyPlanService;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    private TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public ModelAndView find (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technologyPlan_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult list(Integer page, Integer rows, TechnologyPlanVO technologyPlanVO) throws Exception {
        EUDataGridResult result = technologyPlanService.getList(page, rows, technologyPlanVO);
        return result;
    }

    @RequestMapping("/add_judge")
    public String addJudge() {
        return "technologyPlan_add";
    }

    @RequestMapping("/add")
    public String add() {
        return "technologyPlan_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertTechnologyPlan(TechnologyPlan technologyPlan) {
        HashMap map = new HashMap();
        boolean ret1 = technologyPlanService.findTechnologyPlanById(technologyPlan.getTechnologyPlanId());
        if(ret1) {
            String msg = "该工艺计划编号已存在，请更换公益计划编号！";
            map.put("msg",msg);
        } else {
            boolean ret2 = technologyPlanService.insertTechnologyPlan(technologyPlan);
            if(ret2) {
                String status = "200";
                map.put("status",status);
            } else {
                String msg = "添加工艺计划失败，请重试";
                map.put("msg",msg);
            }
        }
        return map;
    }

    @RequestMapping("/delete_judge")
    public String deleteJudge() {
        return "technologyPlan_list";
    }

    @RequestMapping(value = {"/delete_batch"})
    @ResponseBody
    public HashMap deleteTechnologyPlanByIds (String[] ids){
        boolean ret = false;
        try {
            ret = technologyPlanService.deleteTechnologyByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap map = new HashMap();
        if(ret) {
            String status = "200";
            map.put("status",status);
        } else {
            String msg = "删除计划失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/edit_judge")
    public String editTechnologyPlanById1() {
        return "technologyPlan_edit";
    }

    @RequestMapping("/edit")
    public String editTechnologyPlanById2() {
        return "technologyPlan_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateTechnology2(TechnologyPlan technologyPlan) {
        boolean ret = technologyPlanService.updateTechnologyPlan(technologyPlan);
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

    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public EUDataGridResult search_technologyPlan_by_technologyName(Integer page, Integer rows, String searchValue) throws Exception{
        EUDataGridResult result = technologyPlanService.search_technologyPlan_by_technologyName(page, rows, searchValue);
        return result;
    }

    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public EUDataGridResult search_technologyPlan_by_technologyPlanId(Integer page, Integer rows, String searchValue) throws Exception{
        EUDataGridResult result = technologyPlanService.search_technologyPlan_by_technologyPlanId(page, rows, searchValue);
        return result;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<TechnologyPlanVO> getData() throws Exception{
        List<TechnologyPlanVO> list = technologyPlanService.findtechnologyPlan();
        return list;
    }

    @RequestMapping("/get/{technologyPlanId}")
    @ResponseBody
    public TechnologyPlan getItemById(@PathVariable String technologyPlanId) throws Exception{
        TechnologyPlan technologyPlan = technologyPlanService.get(technologyPlanId);
        return technologyPlan;
    }


}
