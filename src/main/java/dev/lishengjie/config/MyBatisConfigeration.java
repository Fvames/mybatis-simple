package dev.lishengjie.config;

import com.github.pagehelper.PageInterceptor;
import dev.lishengjie.plugins.QueryPlugin;
import dev.lishengjie.typeHandle.VarcharTypeHandler;
import org.apache.ibatis.executor.loader.cglib.CglibProxyFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by James on 2019/1/10.
 */
@Configuration
@MapperScan(basePackages = "dev.lishengjie.blog")
@EnableTransactionManagement(proxyTargetClass = true)
public class MyBatisConfigeration {
    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;


    @Lazy(false)
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory localSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{new VarcharTypeHandler()});
        //        sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{new TestTypeHandle()});
        //        sqlSessionFactoryBean.setTypeHandlersPackage("com.gupao.dal.typehandles");
        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{new QueryPlugin()});
        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor()});

        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
        //lazy loading switch
        factory.getConfiguration().setLazyLoadingEnabled(true);
        factory.getConfiguration().setAggressiveLazyLoading(false);
        factory.getConfiguration().setProxyFactory(new CglibProxyFactory());
        return factory;
    }

    private PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.put("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Primary
    @Lazy(false)
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(localSessionFactoryBean(), ExecutorType.SIMPLE);
    }

    @Lazy(false)
    @Bean(name = "batchSst")
    public SqlSessionTemplate batchSst() throws Exception {
        return new SqlSessionTemplate(localSessionFactoryBean(), ExecutorType.BATCH);
    }

    @Bean(name = "txManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
