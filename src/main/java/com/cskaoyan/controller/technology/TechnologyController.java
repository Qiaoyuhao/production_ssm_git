package com.cskaoyan.controller.technology;

import com.cskaoyan.domain.EUDataGridResult;
import com.cskaoyan.domain.technology.Technology;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import com.cskaoyan.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/find")
    public ModelAndView find (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technology_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult list(Integer page, Integer rows, Technology technology) throws Exception{
        EUDataGridResult result = technologyService.getList(page, rows, technology);
        return result;
    }

    @RequestMapping(value = {"/add_judge"})
    public ModelAndView add_judge (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technology_add");
        return modelAndView;
    }

    @RequestMapping(value = {"add"})
    public ModelAndView add (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technology_add");
        return modelAndView;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertTechnology(Technology technology) {
        HashMap map = new HashMap();
        boolean ret1 = technologyService.findTechonlogyById(technology.getTechnologyId());
        if(ret1) {
            String msg = "该工艺编号已经存在，请更换工艺编号！";
            map.put("msg",msg);
        } else {
            boolean ret = technologyService.insertTechnology(technology);
            if(ret) {
                String status = "200";
                map.put("status",status);
            } else {
                String msg = "添加失败，请重试";
                map.put("msg",msg);
            }
        }

        return map;
    }

    @RequestMapping(value = {"/delete_judge"})
    public ModelAndView delete_judge (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("technology_list");
        return modelAndView;
    }

    @RequestMapping(value = {"/delete_batch"})
    @ResponseBody
    public HashMap deleteTechnologyByIds (String[] ids){
        boolean ret = false;
        try {
            ret = technologyService.deleteTechnologyByIds(ids);
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
    public String editTechnologyById1() {
        return "technology_edit";
    }

    @RequestMapping("/edit")
    public String editTechnologyById2() {
        return "technology_edit";
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public HashMap updateTechnology1(Technology technology) {
        boolean ret = technologyService.updateTechnologySelective(technology);
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

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateTechnology2(Technology technology) {
        boolean ret = technologyService.updateTechnology(technology);
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

    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public EUDataGridResult search_technology_by_technologyId(Integer page, Integer rows, Integer searchValue) throws Exception{
        EUDataGridResult result = technologyService.search_technology_by_technologyId(page, rows, searchValue);
        return result;
    }

    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public EUDataGridResult search_technology_by_technologyName(Integer page, Integer rows, String searchValue) throws Exception{
        EUDataGridResult result = technologyService.search_technology_by_technologyName(page, rows, searchValue);
        return result;
    }

    @RequestMapping("/get/{technologyId}")
    @ResponseBody
    public Technology getItemById(@PathVariable String technologyId) throws Exception{
        Technology technology = technologyService.findTechonlogy(technologyId);
        return technology;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getDate() throws Exception{
        List<Technology> list = technologyService.find();
        return list;
    }
}
