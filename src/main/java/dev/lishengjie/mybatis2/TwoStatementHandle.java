package dev.lishengjie.mybatis2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 连接 JDBC 执行
 */
public class TwoStatementHandle {
    // 获取数据库连接
    private TwoConfiguration configuration;
    // 结果映射处理
    private TwoResultSetHandle resultSetHandle;

    public TwoStatementHandle(TwoConfiguration configuration) {
        this.configuration = configuration;
        this.resultSetHandle = new TwoResultSetHandle();
    }

    public <E> E query(MapperStorage.MapperData mapperData, Object paramter) {

        // 获取连接
        Connection connection = getConnection();
        try {
            // 预备语句
            PreparedStatement statement = connection.prepareStatement(
                    String.format(mapperData.getSql(),
                            Integer.parseInt(String.valueOf(paramter))));
            // 执行
            statement.execute();

            // resultSetHandle 处理返回结果

            return resultSetHandle.handle(statement, mapperData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConnection() {

        // 加载
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        try {
            Class.forName(driver);
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
            String userName = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
