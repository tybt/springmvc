package com.web.makeFriends;

import com.alibaba.fastjson.JSONObject;
import com.dao.MomentDao;
import com.web.publicMethods.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/writeMoment")
public class writeComment {
    @Autowired
    private MomentDao momentDao;

    BaseController baseController=new BaseController();
    //填写记录
    @RequestMapping(value = "/words")
    public void words (HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String content=request.getParameter("content");
        String userid=request.getParameter("userid");
        String imgs=request.getParameter("imgs");
        System.out.println(imgs);
        response.setCharacterEncoding("utf-8");
        PrintWriter write= response.getWriter();
        if(content==null){
            content="";
        }
        if(userid==null){
            userid="";
        }
        if(imgs==null){
            imgs="";
        }
        long long_userid=Long.parseLong(userid);
        //获取服务器时间
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(date);

        Date currentTime = new Date();
        long id=currentTime.getTime();
        int result=momentDao.inserContent(id,long_userid,content,date,imgs);
        if(result==1){

            JSONObject data=new JSONObject();
            data.put("code",1);
            data.put("success","发布成功");
            write.write(data.toString());

        }
        System.out.println(result);
    }


    //查询时刻的点赞数量
    @RequestMapping(value = "/getfavorites")
    public void getfavorites (HttpServletRequest request, HttpServletResponse response){

        String id=request.getParameter("moment_id");
        long id_long=Long.parseLong(id);
        //获取赞的数量
        int counts=momentDao.getFavorite(id_long);
        System.out.println(counts);

    }

    //获取动态
    @RequestMapping(value = "/getmoment")
    public void getmoment (HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        response.setCharacterEncoding("utf-8");
        PrintWriter writer=response.getWriter();
        String id=request.getParameter("userid");

        long id_long=Long.parseLong(id);
        try{

            List getMoment=momentDao.getMoment();
            JSONObject resData=new JSONObject();
            resData.put("code",1);
            resData.put("data",getMoment);
            writer.write(resData.toString());

        }
        catch (Exception e){
            System.out.println(e);
        }


    }

    //设置赞
    @RequestMapping(value = "/setFavor")
    public void setFavor (HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String moment_id=request.getParameter("moment_id");
        String favorite_user_id=request.getParameter("favorite_user_id");

        Date currentTime = new Date();
        long id=currentTime.getTime();


        long moment_id_long=Long.parseLong(moment_id);
        long favorite_user_id_long=Long.parseLong(favorite_user_id);
        int result=momentDao.setFavor(id,moment_id_long,favorite_user_id_long);

        JSONObject resData=new JSONObject();
        resData.put("code",1);
        resData.put("success","点赞成功");

        baseController.resJson(response,resData);


    }

    //删除赞
    @RequestMapping(value = "/deleteFavor")
    public void deleteFavor (HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String moment_id=request.getParameter("moment_id");
        String favorite_user_id=request.getParameter("favorite_user_id");



        long moment_id_long=Long.parseLong(moment_id);
        long favorite_user_id_long=Long.parseLong(favorite_user_id);
        int result=momentDao.deleteFavor(moment_id_long,favorite_user_id_long);

        JSONObject resData=new JSONObject();
        resData.put("code",1);
        resData.put("success","取消成功");

        baseController.resJson(response,resData);


    }

    //获取回复内容
    @RequestMapping(value = "/getReply")
    public void getReply (HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String momentId=request.getParameter("momentId");
        long id_long=Long.parseLong(momentId);
        List result=momentDao.getMoemntReply(id_long);

        JSONObject resData=new JSONObject();
        resData.put("code",1);
        resData.put("success","查找成功");
        resData.put("data",result);

        baseController.resJson(response,resData);


    }


}
