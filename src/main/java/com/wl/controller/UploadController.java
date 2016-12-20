package com.wl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wl.base.exception.GlobalException;
import com.wl.entity.ModelBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by wangliang on 16-12-20.
 */

@Controller
@RequestMapping("/file")
public class UploadController {
    private static Logger logger = Logger.getLogger(UploadController.class);

    @RequestMapping("/upload")
    @ResponseBody
    public ModelBean upload(HttpServletRequest request) throws GlobalException {
        String filePath = request.getServletContext().getRealPath("/") + "files/";
        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdir();
        }

        JSONArray files = new JSONArray();
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession(true)
                .getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    logger.info("origin filename >> " + myFileName);

                    if (myFileName.trim() != "") {
                        //重命名上传后的文件名
                        String fileName = UUID.randomUUID().toString() + System.currentTimeMillis();
                        if (myFileName.contains(".")) {
                            String[] arr = myFileName.split("\\.");
                            fileName += ".";
                            fileName += arr[arr.length - 1];
                        }
                        //定义上传路径
                        String path = filePath + fileName;
                        logger.info("file save path >> " + path);
                        File localFile = new File(path);
                        try {
                            file.transferTo(localFile);
                        } catch (IOException e) {
                            logger.info("upload file io exception.");
                            e.printStackTrace();
                        }
                        files.add(path);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        JSONObject data = new JSONObject();
        data.put("files", files);
        return new ModelBean(data);
    }
}
