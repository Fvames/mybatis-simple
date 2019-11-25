package dev.lishengjie.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 加载 xml 配置文件
 * Created by James on 2019/1/10.
 */
public class UserService {

    private static SqlSessionFactory sessionFactory;

    public static void getSession() {
        String resouces = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resouces);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) {
        getSession();
        SqlSession sqlSession = sessionFactory.openSession();
        try {

            User user = sqlSession.selectOne("dev.lishengjie.demo.UserMapper.selectUser", 26);
            System.out.println("user: "+user);
        }finally {
            sqlSession.close();
        }
    }

}
