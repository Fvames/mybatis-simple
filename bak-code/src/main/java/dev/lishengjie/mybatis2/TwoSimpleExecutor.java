package dev.lishengjie.mybatis2;

/**
 * 处理方式，可缓存，或者 typeHandle 等处理
 */
public class TwoSimpleExecutor implements TwoExecutor {
    private TwoConfiguration configuration;

    public TwoSimpleExecutor(TwoConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> E query(MapperStorage.MapperData mapperData, Object paramter) {
        TwoStatementHandle handle = new TwoStatementHandle(configuration);

        return handle.query(mapperData, paramter);
    }

    public TwoConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TwoConfiguration configuration) {
        this.configuration = configuration;
    }
}
