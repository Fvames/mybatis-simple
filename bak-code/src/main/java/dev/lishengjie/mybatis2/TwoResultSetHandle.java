package dev.lishengjie.mybatis2;

import com.google.common.base.CaseFormat;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 结果映射处理
 */
public class TwoResultSetHandle {

    public <E> E handle(PreparedStatement statement, MapperStorage.MapperData mapperData) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object resultObj = new DefaultObjectFactory().create(mapperData.getType());
        ResultSet resultset = statement.getResultSet();

        if (resultset.next()) {
            int i = 0;
            for (Field declaredField : resultObj.getClass().getDeclaredFields()) {
                //todo entity 参数多于column时有问题
                setValue(resultObj, declaredField, resultset, i);
            }
        }
        return (E) resultObj;
    }

    private void setValue(Object resultObj, Field declaredField, ResultSet resultset, int i) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        Method method = resultObj.getClass().getMethod(
                "set" + upperCapital(declaredField.getName()),
                declaredField.getType());
        method.invoke(resultObj, getResult(declaredField, resultset));
    }

    private Object getResult(Field declaredField, ResultSet resultSet) throws SQLException {
        // handles
        Class<?> type = declaredField.getType();
        String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, declaredField.getName());
        if (Integer.class == type) {
            return resultSet.getInt(name);
        }
        if (String.class == type) {
            return resultSet.getString(name);
        }
        if (Date.class == type) {
            return resultSet.getDate(name);
        }

        return resultSet.getString(name);
    }

    private String upperCapital(String name) {

        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
