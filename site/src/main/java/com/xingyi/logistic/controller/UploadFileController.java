package com.xingyi.logistic.controller;

import com.xingyi.logistic.common.bean.JsonRet;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping("file")
public class UploadFileController extends BaseController{
    @Value("${xyl.upload.baseDir}")
    private String baseDir;

    @RequestMapping("/upfile")
    @ResponseBody
    public JsonRet<Object> upLoad(@RequestParam MultipartFile fileName, HttpServletRequest request) throws Exception {

        // 创建I流--图片文件myFile转化为流--读入程序!
        InputStream inputStream = fileName.getInputStream();
        // 改为uuid名!
        String newFileName = getNewName(fileName);
        // 查找即将上传到服务器中的真实路径!
        String realPath = request.getRealPath(this.baseDir);
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 程序 写出 上传服务器!
        FileOutputStream fileOutputStream = new FileOutputStream(realPath + "/" + newFileName);
        // 复制多功能文件(图片)以及关闭流
        IOUtils.copy(inputStream, fileOutputStream);

        inputStream.close();
        fileOutputStream.close();
        Map<String, Object> params = new HashMap<>();
        params.put("filePath","http://xingyi.nandasoft-its.com:8080/xyl/upload/"+newFileName);
        return JsonRet.getSuccessRet(params);
    }

    private String getNewName(MultipartFile fileName) {
        // 找到原始文件名
        String originalFilename = fileName.getOriginalFilename();
        // 找到后缀名.的位置
        int lastIndexOf = originalFilename.lastIndexOf(".");
        // 截取后缀名
        String substring = originalFilename.substring(lastIndexOf);
        // 生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String newName = uuid + substring;

        return newName;

    }


    @RequestMapping("filedownload")
    public void down(String fileName, HttpServletResponse response, HttpServletRequest request) throws Exception {

        // 设置响应头:内容处理方式 → attachment(附件,有为下载,没有为预览加载) →指定文件名
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        // 从服务器上下载图片,要找到图片在服务器中的真实位置
        String realPath = request.getRealPath(this.baseDir);
        // 从服务器上读入程序中
        InputStream fileInputStream = new FileInputStream(realPath + "/" + fileName);
        // 从程序中写出下载到客户端
        OutputStream outputStream = response.getOutputStream();
        // copy以及关闭流资源
        IOUtils.copy(fileInputStream, outputStream);
        outputStream.close();
        fileInputStream.close();

    }


}
