package com.zandooy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication这个注解，因其包含@EnableAutoConfiguration和@ComponentScan注解，可以自动扫描相关的自动配置类，从而实现自动配置功能的

@SpringBootApplication
@MapperScan("com.zandooy.blog.dao")
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
