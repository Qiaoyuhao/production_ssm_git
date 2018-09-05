package com.cskaoyan.controller.schedule;

import com.alibaba.druid.support.json.JSONUtils;
import com.cskaoyan.service.schedule.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 22:24 2018/9/2
 * @Modified By:
 */

@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile){

        HashMap resultMap =  pictureService.uploadPic(uploadFile);
        String jsonString = JSONUtils.toJSONString(resultMap);
        return jsonString;

    }


    @RequestMapping("/delete")
    @ResponseBody
    public String picDelete(@RequestParam String picName){
        boolean b = pictureService.deletePic(picName);
        HashMap resultMap = new HashMap();
        resultMap.put("data","success");
        String jsonString = JSONUtils.toJSONString(resultMap);
        return jsonString;

    }


}
