package dev.lishengjie.mybatis2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 * invoke 获取 storage 中的 MapperData，调用 sqlSession.selectOne 执行
 */
public class TwoMapperProxy<T> implements InvocationHandler {
    private TwoSqlSession sqlSession;
    private Class<T> mapperInterface;

    public TwoMapperProxy(TwoSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodKey = method.getDeclaringClass().getName() + "." + method.getName();
        MapperStorage.MapperData mapperData = sqlSession.getConfiguration().getMapperStorage().getMapperData(methodKey);

        if (mapperData != null) {

            System.out.println(String.format("SQL [%s], paramter: [%s]", mapperData.getSql(), args[0]));
            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }

        return method.invoke(proxy, args);
    }
}
