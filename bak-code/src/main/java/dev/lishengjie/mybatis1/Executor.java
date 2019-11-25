package dev.lishengjie.mybatis1;

import dev.lishengjie.beans.Blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 执行
 */
public class Executor {

    public Blog query(String sql, Object paramter) {
        // 获取链接
        Connection connection = getConnection();

        // 预备语句
        try {
            PreparedStatement statement = connection.prepareStatement(String.format(sql, Integer.parseInt(String.valueOf(paramter))));
            // 执行
            ResultSet resultSet = statement.executeQuery();
            Blog blog = new Blog();
            // 封装结果
            while (resultSet.next()) {
                blog.setId(resultSet.getInt(1));
                blog.setTitle(resultSet.getString(2));
                blog.setContent(resultSet.getString(3));
                blog.setCreateTime(resultSet.getTime(4));
            }

            return blog;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放链接
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private Connection getConnection() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String user = "root";
        String password = "root";

        Connection connection = null;
        // 加载
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
