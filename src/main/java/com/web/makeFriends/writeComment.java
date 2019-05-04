package com.web.makeFriends;

import com.dao.MomentDao;
import com.dao.MomentFavariteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/writeMoment")
public class writeComment {
    @Autowired
    private MomentDao momentDao;
    @Autowired
    private MomentFavariteDao momentFavoriteDao;

    //填写记录
    @RequestMapping(value = "/words")
    public void words (HttpServletRequest request, HttpServletResponse response){
        String content=request.getParameter("content");
        String userid=request.getParameter("userid");
        if(content==null){
            content="";
        }
        if(userid==null){
            userid="";
        }
        long long_userid=Long.parseLong(userid);
        //获取服务器时间
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(date);

        Date currentTime = new Date();
        long id=currentTime.getTime();
        int result=momentDao.inserContent(id,long_userid,content,date);
        System.out.println(result);
    }
    //填写记录
    @RequestMapping(value = "/getfavorites")
    public void getfavorites (HttpServletRequest request, HttpServletResponse response){

        String id=request.getParameter("moment_id");
        long id_long=Long.parseLong(id);
        //获取赞的数量
        int counts=momentFavoriteDao.getFavorite(id_long);
        System.out.println(counts);

    }
}
