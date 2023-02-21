package com.atguigu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Date:2021/8/21
 * Author:ybc
 * Description: 处理json和Java对象之间的转换
 */
public class JsonUtil {

    /**
     * 将json格式的请求参数转换为Java对象
     * @param request：表示当前请求报文的请求对象
     * @param clazz：json格式的请求参数要转换的Java对象的类型
     * @return
     */
    public static Object parseJsonToBean(HttpServletRequest request, Class clazz){
        Object o = null;
        BufferedReader reader = null;
        try {
            //通过request获取请求体信息
            reader = request.getReader();
            //创建一个StringBuilder，用于拼接请求体信息
            StringBuilder builder = new StringBuilder();
            //创建字符串buffer，表示从reader中读取的每一行信息
            String buffer = "";
            //读取reader中的数据
            while((buffer = reader.readLine()) != null){
                builder.append(buffer);
            }
            //将builder转换为字符串
            String data = builder.toString();
            //创建ObjectMapper对象
            ObjectMapper mapper = new ObjectMapper();
            //将请求头中json格式的请求参数转换为Java对象
            o = mapper.readValue(data, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }

    /**
     * 将Java对象转换为json并响应到浏览器
     */
    public static void writeResult(HttpServletResponse response, Object o){
        try {
            response.setContentType("text/html;charset=UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(o);
            response.getWriter().print(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
