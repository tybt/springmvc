package com.web.login;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class account {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/addAcount")
    public void addAcount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");//中文乱码问题
        response.setContentType("text/html; charset=utf-8");
        JSONObject resData=new JSONObject();

        PrintWriter write= response.getWriter();
        String stringPhone=request.getParameter("phone");
        String password=request.getParameter("password");
        int phone=Integer.valueOf(stringPhone);

        if(StringUtils.isEmpty(stringPhone)){
            resData.put("err","手机号码不对");
            resData.put("code",-1);
        }
        else if (StringUtils.isEmpty(password)){
            resData.put("err","密码不能为空");
            resData.put("code",-1);
        }
        else{
            List<User> test=userDao.queryUser(phone);
            if(test.size()!=0){
                resData.put("err","该手机号已经注册");
                resData.put("code",-1);
            }
            else{
                Date currentTime = new Date();
                long userid=currentTime.getTime();
                userDao.addCount(userid,phone,password);
                resData.put("success","添加账户成功");
                resData.put("code",1);
            }

        }
        write.write(resData.toString());
    }


    @RequestMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");//中文乱码问题
        response.setContentType("text/html; charset=utf-8");
        JSONObject resData=new JSONObject();

        PrintWriter write= response.getWriter();
        String stringPhone=request.getParameter("phone");
        String password=request.getParameter("password");
        int phone=Integer.valueOf(stringPhone);

        if(StringUtils.isEmpty(stringPhone)){
            resData.put("err","手机号码不对");
            resData.put("code",-1);
        }
        else if (StringUtils.isEmpty(password)){
            resData.put("err","密码不能为空");
            resData.put("code",-1);
        }
        else{
            List<User> realPassword=userDao.selecPasswordByphone(phone);
            for(int i=0;i<realPassword.size();i++){
                if(realPassword!=null){
                    if(!realPassword.get(i).password.equals(password)){
                        resData.put("err","密码不正确");
                        resData.put("code",-1);
                    }
                    else{
                        resData.put("success","登录成功");
                        resData.put("code",1);
                    }
                }
                else{
                    resData.put("err","账号不存在");
                    resData.put("code",-1);
                }
            }

        }
        write.write(resData.toString());


    }

}
