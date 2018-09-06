package com.cskaoyan.service.schedule.Impl;

import com.cskaoyan.service.schedule.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:23 2018/9/5
 * @Modified By:
 */

@Service
public class FileServiceImpl implements FileService {

    @Override
    public HashMap fileUpload(MultipartFile uploadFile) {
        HashMap map = new HashMap();
        String newFileName = null;
        try {
            //获取原始文件名
            String originalFilename = uploadFile.getOriginalFilename();

            //UUID生成新文件名，并添加文件后缀
            String uuid = UUID.randomUUID().toString();
            newFileName = uuid + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件路径
            String realPath = "E:\\upload\\temp\\file\\";

            File newFile = new File(realPath+newFileName);

            //写入上传文件
            uploadFile.transferTo(newFile);

            map.put("url","/filetemp/"+newFileName);;
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
    public boolean deleteFile(String fileName) {
        boolean flag = false;
        fileName = fileName.substring(fileName.lastIndexOf("/" )+ 1);
        String realPath = "E:\\upload\\temp\\filetemp\\";
        File file = new File(realPath,fileName);
        if(file.exists()){
            file.delete();
            flag = true;
        }
        return flag;
    }


}
