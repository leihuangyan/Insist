package com.lhy.insist.database.master.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: GeneratorServiceUtil
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.util.GeneratorServiceUtil
 * @date: 2020/7/13 21:28
 * @Version: 1.0
 * @description: MP生成代码
 */
public class GeneratorServiceUtil {

    private final static String modelPath = "/insist-database";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        projectPath += modelPath;
        System.out.println("当前项目路径:" + projectPath);
        String dbUrl = "jdbc:mysql://39.108.172.78:3306/study?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=true";
        String packageName = "com.lhy.insist.database.master.model";
        String modelName = "user";
        String[] tables = {"t_user"};
        generateByTables(dbUrl, projectPath, packageName, modelName, tables);
    }


    /**
     * 反向构建表
     *
     * @param dbUrl       url
     * @param projectPath 工程路径
     * @param packageName 包名
     * @param moduleName  模块名
     * @param tableNames  表名  支持多个表
     */
    private static void generateByTables(String dbUrl, String projectPath, String packageName, String moduleName, String... tableNames) {
        // =================================== [数据源配置] ===================================
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)
                .setUrl(dbUrl)
                .setDbType(DbType.MYSQL)
                .setUsername("root")
                .setPassword("1223")
                .setDriverName("com.mysql.cj.jdbc.Driver");


        // =================================== [策略配置] ===================================
        StrategyConfig strategyConfig = new StrategyConfig();
        // 生成lombok
        strategyConfig.setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                //表前缀
                .setTablePrefix("t_")
                //跳过视图
                .setSkipView(true)
                //包含表名
                .setInclude(tableNames)
                //逻辑删除字段
                .setLogicDeleteFieldName("state")
                //表填充字段
                .setTableFillList(null)
                //【实体】是否为构建者模型
                .setChainModel(true)
                //【实体】是否为lombok模型
                .setEntityLombokModel(true)
                //自定义继承的Entity类全称，带包名
                .setSuperEntityClass("com.lhy.insist.database.master.base.SuperEntity")
                //自定义基础的Entity类，公共字段
                .setSuperEntityColumns("createDate", "createCode", "updateDate", "updateCode", "state")
                //表填充字段
                //.setTableFillList("")
                //自定义继承的Mapper类全称，带包名
                .setSuperMapperClass("com.lhy.insist.database.master.base.SuperMapper")
                // 自定义继承的Service类全称，带包名
                .setSuperServiceClass("com.lhy.insist.database.master.base.SuperService")
                //自定义继承的ServiceImpl类全称，带包名
                //.setSuperServiceImplClass("")
                //自定义继承的Controller类全称，带包名
                .setSuperControllerClass("com.lhy.insist.database.master.base.SuperController")
                //生成 @RestController 控制器
                .setRestControllerStyle(true)
                //驼峰命名
                .setControllerMappingHyphenStyle(true)
                //生成实体时，生成字段注解
                .setEntityTableFieldAnnotationEnable(true)
                //Boolean类型字段是否移除is前缀（默认 false）
                .setEntityBooleanColumnRemoveIsPrefix(true);


        // =================================== [全局配置] ===================================
        GlobalConfig config = new GlobalConfig();

        //AR模式
        config.setActiveRecord(false)
                // Kotli 模式
                .setKotlin(false)
                .setActiveRecord(true)
                .setSwagger2(false)
                .setAuthor("lhy")
                //生成文件的输出目录
                .setOutputDir(projectPath + "/src/main/java")
                //开启二级缓存
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                //覆盖
                .setFileOverride(true)
                .setControllerName("%sController")
                .setServiceName("I%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("I%sDao")
                .setXmlName("%sDao")
                .setEntityName("%sPO");

        // =================================== [包配置] ===================================
        PackageConfig packageConfig = new PackageConfig();
        //包名
        packageConfig.setParent(packageName);
        //模块名
        packageConfig.setModuleName(moduleName);
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("dao");
        packageConfig.setEntity("entity");


        // =================================== [自定义配置] ===================================
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity  (mp 默认模板)
        String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        // =================================== [配置模板] ===================================
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);

        // =================================== [构建] ===================================
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setCfg(cfg)
                .setTemplate(templateConfig)
                .execute();
    }

}