package com.web.publicMethods;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;


public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 输出JSON数据
     *
     * @paramresponse
     * @paramjsonStr
     */
    public void writeJson(HttpServletResponse response, String jsonStr) {
        response.setContentType("text/json;charset=utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(jsonStr);
            pw.flush();
        } catch (Exception e) {
            logger.info("输出JSON数据异常", e);
        }finally{
            if(pw!=null){
                pw.close();
            }
        }
    }
    /**
     *
     * 向页面响应json字符数组串流.
     *
     * @param response
     * @param jsonStr
     * @throws IOException
     * @return void
     * @author 蒋勇
     * @date 2015-1-14 下午4:18:33
     */
    public void writeJsonStr(HttpServletResponse response, String jsonStr) throws IOException {

        OutputStream outStream = null;
        try {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            outStream = response.getOutputStream();
            outStream.write(jsonStr.getBytes("UTF-8"));
            outStream.flush();
        } catch (IOException e) {
            logger.info("输出JSON数据异常(writeJsonStr)", e);
        } finally {
            if(outStream!=null){
                outStream.close();
            }
        }
    }

    public void writeJsonStr(HttpServletResponse response, InputStream in) throws IOException {

        if(null == in ){
            return ;
        }
        OutputStream outStream = null;
        try {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            outStream = response.getOutputStream();
            int len = 0;
            byte[] byt = new byte[1024];
            while ((len = in.read(byt)) != -1) {
                outStream.write(byt, 0, len);
            }
            outStream.flush();

        } catch (IOException e) {

            logger.info("输出JSON数据异常(writeJsonStr)", e);
        } finally {
            if(outStream!=null){
                outStream.close();
                in.close();
            }
        }
    }


    /**
     * 输出JSON数据
     *
     * @paramresponse
     * @paramjsonStr
     */
    public void writeJson(HttpServletResponse response, Object obj) {
        response.setContentType("text/json;charset=utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter pw = null;
        Gson gson = new Gson();
        try {
            pw = response.getWriter();
            pw.write(gson.toJson(obj));

            pw.flush();
        } catch (Exception e) {
            logger.info("输出JSON数据异常", e);
        }finally{
            if(pw!=null){
                pw.close();
            }
        }
    }




    public void writeHtml(HttpServletResponse response, String html) {
        response.setContentType("text/html;;charset=utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(html);
            pw.flush();
        } catch (Exception e) {
            logger.info("输出HTML数据异常", e);
        }finally{
            if(pw!=null){
                pw.close();
            }
        }
    }

    public void resJson(HttpServletResponse response, JSONObject object)
            throws IOException{
        response.setContentType("text/json;charset=utf-8");

        PrintWriter writer=response.getWriter();
        writer.write(object.toString());

    }

}
