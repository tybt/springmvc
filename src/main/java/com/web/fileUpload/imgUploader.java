package com.web.fileUpload;

import com.entity.ResponseResult;
import com.web.publicMethods.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/uploader")
public class imgUploader {

    @RequestMapping("/imgs")
    public void imgs(@RequestParam(value="file",required=false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response){
        ResponseResult result = new ResponseResult();
        String dataList[]=null;
        File targetFile=null;
        String url="";//返回存储路径
        int code=1;


        if(files!=null&&files.length>0){
            dataList=new String[files.length];
            for(int i=0;i<files.length;i++){
                String fileName=files[i].getOriginalFilename();//获取文件名加后缀
                String returnUrl =  request.getContextPath() +"/upload/imgs/";//存储路径 request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
                String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
                fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

                //先判断文件是否存在
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String fileAdd = sdf.format(new Date());
                //获取文件夹路径
                File file1 =new File(path+"/"+fileAdd);
                //如果文件夹不存在则创建
                if(!file1.exists()  && !file1 .isDirectory()){
                    file1.mkdir();
                }
                //将图片存入文件夹
                targetFile = new File(file1, fileName);
                try {
                    //将上传的文件写到服务器上指定的文件。
                    files[i].transferTo(targetFile);
                    url=returnUrl+fileAdd+"/"+fileName;
                    dataList[i]= url;

                } catch (Exception e) {
                    e.printStackTrace();
                    result.setMessage("系统异常，图片上传失败");
                }

            }
        }
        code=1;

        result.setCode(code);
        result.setMessage("图片上传成功");


        result.setResult(dataList);
        BaseController baseController=new BaseController();

        baseController.writeJson(response, result);



    }


}
