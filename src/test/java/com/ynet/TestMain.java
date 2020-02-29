package com.ynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages = "com.ynet.repository")
@EntityScan(basePackages={"com.ynet.pojo" })
@SpringBootApplication(scanBasePackages= {"com.ynet"}) //组合注解
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class TestMain {
	public static void main(String[] args) {
		SpringApplication.run(TestMain.class, args);
	}
}
