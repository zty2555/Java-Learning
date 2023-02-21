package com.atguigu.dao;

import com.atguigu.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Date:2021/8/2
 * Author:ybc
 * Description:抽象增删改查功能的父类
 */
public class BaseDao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 查询结果集为单行单列的数据
     * @param sql：要执行的sql语句
     * @param params：按照顺序为占位符所赋的值
     * @return
     */
    public Object getSingleData(String sql, Object... params){

        Connection connection = null;
        Object o = null;
        try {
            connection = JDBCUtil.getConnection();
            o = queryRunner.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return o;
    }

    /**
     * 查询多条数据为实体类集合
     * @param clazz：要转换的实体类类型的Class对象
     * @param sql：要执行的sql语句
     * @param params：按照顺序为占位符所赋的值
     * @return
     */
    public List<T> getBeanList(Class<T> clazz, String sql, Object... params){
        Connection connection = null;
        List<T> list = null;
        try {
            connection = JDBCUtil.getConnection();
            list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return list;
    }

    /**
     * 查询一条数据为一个实体类对象
     * @param clazz：要转换的实体类类型的Class对象
     * @param sql：要执行的sql语句
     * @param params：按照顺序为占位符所赋的值
     * @return
     */
    public T getBean(Class<T> clazz, String sql, Object... params){

        Connection connection = null;
        T t = null;
        try {
            connection = JDBCUtil.getConnection();
            t = queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return t;
    }

    /**
     * 实现增删改的功能
     * @param sql：要执行的sql语句
     * @param params：按照顺序为占位符所赋的值
     * @return：受影响的行数
     */
    public int update(String sql, Object... params){
        Connection connection = null;
        int result = 0;
        try {
            connection = JDBCUtil.getConnection();
            result = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    public int updateOld(String sql, Object... params){
        Connection connection = null;
        int result = 0;
        try {
            //通过JDBCUtil获取连接
            connection = JDBCUtil.getConnection();
            //获取预编译对象
            PreparedStatement ps = connection.prepareStatement(sql);
            //为sql中的占位符赋值
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            //执行sql语句
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
