package dev.lishengjie.mybatis2;

import dev.lishengjie.beans.Blog;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存 mapper
 * key: namespace.method
 * value: MapperData{sql, ResultType/Entity}
 */
public class MapperStorage {
    private Map<String, MapperData> mapperMap = new HashMap<>();

    public void putMapper(String method, String sql, Class T) {
        mapperMap.put(method, new MapperData(sql, Blog.class));
    }

    public MapperData getMapperData(String method) {
        return mapperMap.get(method);
    }


    public static class MapperData<T> {
        private String sql;
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }
    }
}
