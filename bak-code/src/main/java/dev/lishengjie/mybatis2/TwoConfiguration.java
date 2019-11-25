package dev.lishengjie.mybatis2;

import dev.lishengjie.beans.Blog;

/**
 * 配置类
 * 根据路径扫描 mapper 文件，然后存入 MapperStorage
 */
public class TwoConfiguration {

    private String scanPath;
    private MapperStorage mapperStorage = new MapperStorage();

    public TwoConfiguration setScanPath(String scanPath) {
        this.scanPath = scanPath;
        return this;
    }

    public void build() {
        // 非空判断
        // 扫描获取key，value
        // 存储key value
        String method = "dev.lishengjie.mybatis2.TwoBlogMapper.selectByPrimaryKey";
        String sql = "SELECT * FROM blog Where id = %d";
        mapperStorage.putMapper(method, sql, Blog.class);
    }

    public MapperStorage getMapperStorage() {
        return mapperStorage;
    }
}
