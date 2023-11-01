package com.zxwcbj.ccyx.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置信息
 * 接口测试的配置类
 * @author a8480
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2Config {
    @Bean
    public Docket webApiConfig() {
        List<Parameter> parsers = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("userId")
                .description("用户token")
                //.defaultValue(JwtHelper.createToken(1L, "admin"))
                .defaultValue("1")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parsers.add(tokenPar.build());

        Docket webApi = new Docket(DocumentationType.SWAGGER_2)
                //进行分组，组的名称
                .groupName("webApi")
                //接口中的公共信息
                .apiInfo(webApiInfo())
               .select()
                //只显示api路径下的页面
               .apis(RequestHandlerSelectors.basePackage("com.zxwcbj.ccyx.common.controller"))
                //只显示api路径下的页面
               .paths(PathSelectors.regex("/api/.*"))
               .build()
                //加载全局的分组参数
               .globalOperationParameters(parsers);
        return webApi;
    }
    @Bean
    public Docket adminApiConfig(){
        List<Parameter> pars=new ArrayList<Parameter>();
        ParameterBuilder tokenPar=new ParameterBuilder();
        tokenPar.name("adminId")
                 .description("用户token")
                .defaultValue("1")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

          Docket adminApi = new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .apis(RequestHandlerSelectors.basePackage("com.zxwcbj.ccyx"))
                  /**
                 * 是一个路径筛选器，它使用正则表达式来限制包含在生成的Swagger文档中的API接口路径。
                 * 具体来说，这行代码指定了只包括那些路径匹配正则表达式/admin/.* 的API接口。
                 * 其他路径则被排除,只显示admin路径下的页面
                 * */
                .paths(PathSelectors.regex("/admin/.*"))
                .build()
                .globalOperationParameters(pars);
        return adminApi;
    }

    private ApiInfo adminApiInfo() {
        return new  ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了尚上优选后台系统服务接口定义")
                .version("1.0")
                .contact(new Contact("zxwcbj", "http://zxwcbj.com", "zxwcbj"))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了尚上优选网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("zxwcbj", "http://zxwcbj.com", "zxwcbj"))
                .build();
    }
}
