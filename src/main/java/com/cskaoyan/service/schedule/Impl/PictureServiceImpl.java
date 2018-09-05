package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.service.schedule.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 22:27 2018/9/2
 * @Modified By:
 */

@Service
public class PictureServiceImpl implements PictureService {

    @Override
    public HashMap uploadPic(MultipartFile uploadFile) {

        HashMap map = new HashMap();
        String newFileName = null;
        try {
            //获取原始文件名
            String originalFilename = uploadFile.getOriginalFilename();

            //UUID生成新文件名，并添加文件后缀
            String uuid = UUID.randomUUID().toString();
            newFileName = uuid + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件路径（在server.xml里映射 /pic/ 路径）
            String realPath = "E:\\upload\\temp\\pic\\";
//            String realPath = "d://upload/temp/img/"
            File newFile = new File(realPath+newFileName);

            //写入上传文件
            uploadFile.transferTo(newFile);

            map.put("url","/picture/"+newFileName);;
            map.put("error",0);

            return map;

        } catch (IOException e) {
            e.printStackTrace();
            map.put("message","文件上传出现问题");
            map.put("error",1);

            return map;
        }



    }

    @Override
    public boolean deletePic(String picName) {
        boolean flag = false;
        picName = picName.substring(picName.lastIndexOf("/" + 1));
        String realPath = "E:\\upload\\temp\\pic\\";
        File picFile = new File(realPath,picName);
        if(picFile.exists()){
            picFile.delete();
            flag = true;
        }
        return flag;
    }
}
