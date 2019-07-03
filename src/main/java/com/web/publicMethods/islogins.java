package com.web.publicMethods;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.web.publicMethods.BaseController;

public class islogins implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //获取HttpSession对象，判断是否登陆
        HttpServletRequest req =  (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        JSONObject resdata=new JSONObject();

        if(session.getAttribute("user")==null){
            resdata.put("code","-1");
            resdata.put("msg","请先登录");
            BaseController baseController=new BaseController();
            baseController.resJson2(response,resdata);
        }else{
            // 如果有下一个过滤器则跳转到下一个过滤器否则目标页面
            chain.doFilter(request, response);
        }
    }

}
