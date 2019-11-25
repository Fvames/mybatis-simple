package dev.lishengjie.mybatis1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {

    private final SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //if (method.getDeclaringClass().getName().equals())

        String sql = "SELECT * FROM BLOG WHERE ID = %d ";
        return sqlSession.selectOne(sql, args[0]);
    }
}
