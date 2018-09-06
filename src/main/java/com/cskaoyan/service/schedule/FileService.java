package com.cskaoyan.service.schedule;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:22 2018/9/5
 * @Modified By:
 */
public interface FileService {

    HashMap fileUpload(MultipartFile uploadFile);

    boolean deleteFile(String fileName);

}
