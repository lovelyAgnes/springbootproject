package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket openApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                //只有加了ApiOperation 注解的才对外暴露
                //requestHandler -> requestHandler.isAnnotatedWith((Class<? extends Annotation>) ApiOperation.class)
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目开发接口文档")
                .description("此文档仅供开发人员使用")
                .version("1.0")
                .build();
    }

}
