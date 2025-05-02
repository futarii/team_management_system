package com.yanshedui.backendmain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan(basePackages = {
		"com.yanshedui.backendmain",
		"com.yanshedui.backendteam",
		"com.yanshedui.backendcommon",
		"com.yanshedui.backendannouncement",
		"com.yanshedui.backendsystem"
})
@MapperScan(basePackages = {
		"com.yanshedui.backendteam.dao",
		"com.yanshedui.backendannouncement.dao",
		"com.yanshedui.backendsystem.dao"
})
public class BackendMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendMainApplication.class, args);
	}

}
