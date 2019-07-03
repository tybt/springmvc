package com.web.user;


import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import com.entity.User;
import com.web.publicMethods.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class userController {
    BaseController baseController=new BaseController();
    @Autowired
    private UserDao userDao;
    @RequestMapping("changeImg")
    public void changeImg(HttpServletRequest request, HttpServletResponse response)
    throws IOException{
        String userid=request.getParameter("userid");
        String user_photo=request.getParameter("user_photo");
        long longUserid=Long.parseLong(userid);
        int result=userDao.changeImg(longUserid,user_photo);
        response.setCharacterEncoding("utf-8");
        PrintWriter write=response.getWriter();
        JSONObject resData=new JSONObject();

        if(result==1){
            resData.put("code",1);
        }
        else{
            resData.put("code",0);
        }
        write.write(resData.toString());
    }

    @RequestMapping(value = "/addAcount")
    public void addAcount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");//中文乱码问题
        response.setContentType("text/html; charset=utf-8");
        JSONObject resData=new JSONObject();

        PrintWriter write= response.getWriter();
        String account=request.getParameter("account");
        String password=request.getParameter("password");


        if(StringUtils.isEmpty(account)){
            resData.put("err","账号不对");
            resData.put("code",-1);
        }
        else if (StringUtils.isEmpty(password)){
            resData.put("err","密码不能为空");
            resData.put("code",-1);
        }
        else{
            List<User> test=userDao.queryUser(account);
            if(test.size()!=0){
                resData.put("msg","该账号已经注册");
                resData.put("code",-1);
            }
            else{
                try{
                    userDao.addCount(account,password);
                    Map userList= userDao.selectUserinfoByAccount(account);
                    resData.put("msg","添加账户成功");
                    resData.put("code",1);
                    resData.put("data",userList);
                    HttpSession session= request.getSession();
                    session.setAttribute("user",account);

                }catch (Exception e){
                    System.out.println(e);
                }
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
        String account=request.getParameter("account");
        String password=request.getParameter("password");

        if(StringUtils.isEmpty(account)){
            resData.put("msg","手机号码不对");
            resData.put("code",-1);
        }
        else if (StringUtils.isEmpty(password)){
            resData.put("msg","密码不能为空");
            resData.put("code",-1);
        }
        else{
            List<User> realPassword=userDao.selecPasswordByAccount(account);
            if(realPassword.size()==0){
                resData.put("msg","账号不存在");
                resData.put("code",-1);
            }
            else{
                if(!realPassword.get(0).password.equals(password)){
                    resData.put("msg","密码不正确");
                    resData.put("code",-1);
                }
                else{
                    HttpSession session=request.getSession();
                    session.setAttribute("user",realPassword.get(0).name);
                    session.setAttribute("userid",realPassword.get(0).userid);
                    resData.put("msg","登录成功");
                    resData.put("code",1);
                    resData.put("user",realPassword);
                }
            }


        }
        baseController.resJson(response,resData);


    }

}
