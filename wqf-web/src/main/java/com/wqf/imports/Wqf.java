package com.wqf.imports;

import com.wqf.imports.web.common.datasources.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
class Wqf extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(Wqf.class, args);
        init(context);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Wqf.class);
    }


    public static void init(ConfigurableApplicationContext context){
		/*启动谷歌浏览器*/
//        			ProcessBuilder proc = new ProcessBuilder( "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
//                    "127.0.0.1:8080/imports");
//
//			proc.start();


    }
}
