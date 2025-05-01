package com.yanshedui.backendmain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {
		"com.yanshedui.backendmain",
		"com.yanshedui.backendteam",
		"com.yanshedui.backendcommon"
})
@MapperScan(basePackages = {
		"com.yanshedui.backendteam.dao"
})
public class BackendMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendMainApplication.class, args);
	}

}
