package com.cskaoyan.controller.schedule;

import com.alibaba.druid.support.json.JSONUtils;
import com.cskaoyan.service.schedule.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:36 2018/9/5
 * @Modified By:
 */

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/upload", method=RequestMethod.POST)
    @ResponseBody
    public String FileUpload(MultipartHttpServletRequest request){
        Iterator<String> iterator = request.getFileNames();
        String jsonString = null;
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            HashMap<String,Object> result = fileService.fileUpload(multipartFile);
            jsonString = JSONUtils.toJSONString(result);
        }
        return jsonString;

    }


    @RequestMapping("/delete")
    @ResponseBody
    public String FileDelete(@RequestParam String fileName){
        boolean b = fileService.deleteFile(fileName);
        System.out.println("b ="+b);
        HashMap resultMap = new HashMap();
        resultMap.put("data","success");
        String jsonString = JSONUtils.toJSONString(resultMap);
        return jsonString;

    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> DownloadFile(@RequestParam String fileName, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //  接受的是UTF-8
        req.setCharacterEncoding("utf-8");
        //获取文件名
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        //获取文件目录
        String path = "E:\\upload\\temp\\file\\" ;


        File file = new File(path+fileName);
//        file.createNewFile();
        HttpHeaders headers = null;
        try {
            //请求头
            headers = new HttpHeaders();
            String fileNameForBytes = new String(fileName.getBytes("UTF-8"), "iso-8859-1");//解决文件名乱码
            //通知浏览器以attachment（下载方式）打开文件
            headers.setContentDispositionFormData("attachment", fileNameForBytes);
            //application/octet-stream二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);

    }
}
