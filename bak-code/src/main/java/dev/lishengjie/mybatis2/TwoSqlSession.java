package dev.lishengjie.mybatis2;

import java.lang.reflect.Proxy;

/**
 * 获取 Mapper
 * 执行语句
 */
public class TwoSqlSession {
    private TwoConfiguration configuration;
    private TwoExecutor executor;

    public TwoSqlSession(TwoConfiguration configuration, TwoExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz},
                new TwoMapperProxy(this, clazz));
    }

    public <T> T selectOne(MapperStorage.MapperData mapperData, Object paramter) {

        return executor.query(mapperData, paramter);
    }

    public TwoConfiguration getConfiguration() {
        return configuration;
    }
}
