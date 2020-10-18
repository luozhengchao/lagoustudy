package com.lagou.step1.spring.server.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2 {
    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     **/
    @Bean
    public Docket createRestApi(@Value("${spring.profiles.active}") String env) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.lagou.step1.spring.server"))
                .paths("prd".equals(env) ? PathSelectors.none() : PathSelectors.any())
                .build()
                .groupName("第一阶段spring相关");
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("第一阶段spring相关")
                //创建人
                .contact(new Contact("罗正朝", "N/A", "289627502@qq.com"))
                //版本号
                .version("1.0.0")
                //描述
                .description("第一阶段spring相关")
                .build();
    }
}
