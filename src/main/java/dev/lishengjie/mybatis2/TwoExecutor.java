package dev.lishengjie.mybatis2;

/**
 * 执行 sql
 */
public interface TwoExecutor {

    <T> T query(MapperStorage.MapperData mapperData, Object paramter);

}
