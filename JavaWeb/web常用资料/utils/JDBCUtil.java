package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Date:2021/8/2
 * Author:ybc
 * Description:封装创建连接和释放连接的过程
 */
public class JDBCUtil {

    private static DataSource dataSource;

    static {
        try {
            //创建Properties对象
            Properties prop = new Properties();
            //获取要读取的文件jdbc.properties的输入流
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //读取jdbc.properties文件的内容
            prop.load(is);
            //通过prop创建数据源
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回druid数据源所提供的连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放连接
     * @param connection
     */
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
