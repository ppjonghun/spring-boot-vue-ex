package com.example.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication // == @Configuration + @EnableAutoConfiguration(★) + @ComponentScan
					   // @Configuration : 어노테이션기반 환경구성을 도움
					   // @EnableAutoConfiguration : spring.factories 안에 들어있는 수많은 자동 설정들이
					   // 	조건에 따라 적용이 되어 수 많은 Bean들이 생성되고, 스프링 부트 어플리케이션이 실행
					   // @ComponentScan : 해당 패키지에서 @Component 어노테이션을 가진 Bean들을 스캔해서 등록
					   // 	(@Configuration, @Repository, @Service, @Controller, @RestController 포함)
@MapperScan(basePackages = "com.example.admin")
public class AdminVueApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AdminVueApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources((AdminVueApplication.class));
	}
	
	// SpringBootServletInitializer : war 로 배포하기 위해 상속받음

}
