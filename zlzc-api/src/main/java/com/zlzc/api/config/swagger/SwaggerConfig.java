package com.zlzc.api.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket createRestApi(TypeResolver resolver) {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //加了ApiOperation注解的类，生成接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，生成接口文档
            //.apis(RequestHandlerSelectors.basePackage("com.zlzc.modules.job.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("中联众呈")
            .description("zlzc-admin文档")
            .termsOfServiceUrl("https://www.zlzc.com")
            .version("v1.0")
            .build();
    }

}