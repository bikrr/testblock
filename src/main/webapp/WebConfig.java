package main.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"main.webapp"})
@PropertySources(value = {@PropertySource("classpath:/application.properties")})

@SpringBootApplication
public class WebConfig {
    static String DB_URL, DB_USER, DB_PASS;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebConfig.class, args);


        File propertyFile;
        Properties properties = new Properties();
        propertyFile = new File("src/main/resources/application.properties");
        properties.load(new FileReader(propertyFile));
        DB_URL = properties.getProperty("DB_URL");
        DB_USER = properties.getProperty("DB_USER");
        DB_PASS = properties.getProperty("DB_PASS");
        System.out.println("DB_URL:" + DB_URL);
    }
}
