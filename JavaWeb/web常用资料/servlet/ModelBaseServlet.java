package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Date:2021/8/17
 * Author:ybc
 * Description:
 */
public class ModelBaseServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //设置编码
            request.setCharacterEncoding("UTF-8");
            //获取请求参数method的值
            String methodName = request.getParameter("method");
            //将methodName作为方法名，获取相对应的方法对象
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //忽略method所对应方法的访问权限
            method.setAccessible(true);
            //调用method所对应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
