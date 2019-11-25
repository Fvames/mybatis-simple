package dev.lishengjie.mybatis1;

import dev.lishengjie.beans.Blog;

import java.lang.reflect.Proxy;

/**
 * 获取 mapper 并调用执行
 */
public class SqlSession {

    private Executor executor = new Executor();


    public Blog selectOne(String statement, Object parameter) {
        return executor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz}, new MapperProxy(this, clazz));
    }
}
