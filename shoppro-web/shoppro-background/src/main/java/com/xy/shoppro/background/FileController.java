package com.xy.shoppro.background;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.xy.shoppro.common.pojo.ResultBean;
import com.xy.shoppro.common.pojo.WangEditorResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author SYQ
 * Created on 2019\8\7 0007 13:59
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FastFileStorageClient client;
    /**
     * 图片保存服务器地址
     */
    @Value("${image.server}")
    private String imageServer;

    @RequestMapping("upload")
    public ResultBean<String> fileupload(MultipartFile file){
        //先获取文件名
        String originalFilename = file.getOriginalFilename();
        //后缀名
        String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        try {
            StorePath storePath = client.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), extName, null);
            String imagePath=imageServer+storePath.getFullPath();
            return new ResultBean<>(200,imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultBean<>(500,"图片上传失败");
    }

    @RequestMapping("uploads")
    public WangEditorResultBean filesupload(MultipartFile[] files){
        String [] data=new String[files.length];
        for (int i = 0; i < files.length; i++) {
            MultipartFile file=files[i];
            //先获取文件名
            String originalFilename = file.getOriginalFilename();
            //后缀名
            String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            try {
                StorePath storePath = client.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), extName, null);
                String imagePath=imageServer+storePath.getFullPath();
                data[i]=imagePath;
            } catch (IOException e) {
                e.printStackTrace();
                return new WangEditorResultBean("-1",null);
            }
        }
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(data[i]);
//        }
        return new WangEditorResultBean("0",data);
    }
}
