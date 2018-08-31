package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 23:55 2018/8/30
 * @Modified By:
 */
@Controller
public class InitController {


    @RequestMapping("/")
    public String init() {
        return "home";
    }

}
