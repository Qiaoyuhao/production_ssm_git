package com.cskaoyan.service.schedule;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 22:27 2018/9/2
 * @Modified By:
 */

public interface PictureService {

    HashMap uploadPic(MultipartFile uploadFile);
}
