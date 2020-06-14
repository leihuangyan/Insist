package com.lhy.insist.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @name: SwaggerConfiguration
 * @author： LHY
 * @classPath: com.lhy.insist.config.SwaggerConfiguration
 * @date: 2020/6/14 17:34
 * @Version: 1.0
 * @description: swagger-bootstrap-ui 默认访问路径->:http://${host}:${port}/doc.html
 *
 * Springfox-swagger默认提供了两个Swagger接口,需要开发者放开权限(如果使用shiro权限控制框架等)，
 * 如果使用SwaggerBootstrapUi的增强功能,还需放开增强接口地址,
 * 所以，放开的权限接口包括3个，分别是：
 *
 * /swagger-resources:Swagger的分组接口
 * /v2/api-docs?group=groupName:Swagger的具体分组实例接口,返回该分组下所有接口相关的Swagger信息
 * /v2/api-docs-ext?group=groupName:该接口是SwaggerBootstrapUi提供的增强接口地址,如不使用UI增强,则可以忽略该接口
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描包
                .apis(RequestHandlerSelectors.basePackage("com.lhy.insist"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("这是一个API文档")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:80/")
                .contact(new Contact("lhy","www.baidu.con","15897476550@163.com"))
                .version("1.0")
                .build();
    }
}
