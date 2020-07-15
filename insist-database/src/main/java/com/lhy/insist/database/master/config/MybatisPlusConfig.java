package com.lhy.insist.database.master.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: MybatisPlusConfig
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.config.MybatisPlusConfig
 * @date: 2020/7/13 21:24
 * @Version: 1.0
 * @description:  MybatisPlus 配置类
 */
@Configuration
@MapperScan("com.lhy.insist.database.master.**.mapper")
public class MybatisPlusConfig {


    /**
     * plus 的性能优化
     * @return PerformanceInterceptor
     *
     *
     @Bean
     public PerformanceInterceptor performanceInterceptor() {
         PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
         //SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长
         performanceInterceptor.setMaxTime(1000);
         //SQL是否格式化 默认false--
         performanceInterceptor.setFormat(true);
        return performanceInterceptor;
     }
     */




    /**
     * mybatis-plus分页插件
     * @return mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //paginationInterceptor.setDialectType("oracle");
        return paginationInterceptor;
    }

    /**
     * dynamic-datasource 不能使用多数据源事务 因此注释
     */
    ///**
    // * 配置数据源
    // * @return DruidDataSource
    // */
    //@Bean(name="dataSource")
    //@ConfigurationProperties(prefix="spring.datasource")
    //public DruidDataSource dataSource(){
    //    return new DruidDataSource();
    //}
    //
    ///**
    // *  配置事物管理器
    // * @return DataSourceTransactionManager
    // */
    //@Bean(name="transactionManager")
    //public DataSourceTransactionManager transactionManager(){
    //    return new DataSourceTransactionManager(dataSource());
    //}


}