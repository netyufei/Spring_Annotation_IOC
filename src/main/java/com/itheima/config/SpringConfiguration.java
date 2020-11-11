package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
* 该类是一个配置类，他的 作用是和bean.xml一样的
* Spring中的新注解
* Configuration
*           作用：当前类是一个配置类
*ComponentScan
*           作用：用于Spring 在创建容器时要扫描的包
*           属性value/basePackages：两者的功能都是一样的 <context:component-scan base-package="com.itheima"></context:component-scan>
*Bean
*   作用：用于把当前方法的返回值作为bean对象存入Spring的IOC容器中
*   属性：
*           name:用于指定bean的id 默认值：不写时默认值当前方法的名称
*           细节：当我们使用注解配置方法时。如果方法有参数，spring框架会去容器查找
*           又名没有可以使用的bean对象，查找的方式和Autowired的方法是一样的
*           */
@Configuration
@ComponentScan(basePackages = "com.itheima")
public class SpringConfiguration {
    //创建一个QueryRunner对象
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean(name ="dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC&useSSL=false&useUnicode=true &characterEncoding=UTF-8");
        ds.setUser("root");
        ds.setPassword("123456");
        return ds;
    }
}
