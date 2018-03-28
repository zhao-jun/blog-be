package com.zandooy.blog.config;

import com.zandooy.blog.interceptor.MybatisCodeInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

// 暂时不使用
//@Configuration
@EnableTransactionManagement
public class MybatisConfig{

    @Autowired
    private DataSource dataSource;

    private String typeAliasesPackage;

    private String mapperPath;

    private final static String DEFAULT_MAPPER_PATH = "classpath*:mappers/*.xml";

    /**
     * 设置mybatis
     * */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

        bean.setDataSource(dataSource);//插入数据连接池
        bean.setTypeAliasesPackage(typeAliasesPackage);//扫描java的pojo实体类

        //改写mybatis的配置,待考虑要改什么参数
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(true);
        bean.setConfiguration(configuration);

        //添加插件...
        bean.setPlugins(new Interceptor[]{new MybatisCodeInterceptor()});

        //设置mapper.xml文件的位置,默认位置DEFAULT_MAPPER_PATH
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            if(mapperPath == null) mapperPath = DEFAULT_MAPPER_PATH;
            bean.setMapperLocations(resolver.getResources(mapperPath));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setLogPrefix("dao.");
            }
        };
    }
    /**
     * 添加事务控制
     * */
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}