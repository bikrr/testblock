package main.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"main.webapp"})
@PropertySources(value = {@PropertySource("classpath:/application.properties")})

@SpringBootApplication
public class WebConfig {

    public static void main(String[] args) {
        SpringApplication.run(WebConfig.class, args);
    }
}
