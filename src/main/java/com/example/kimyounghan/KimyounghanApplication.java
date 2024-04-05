package com.example.kimyounghan;

import com.example.kimyounghan.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication (scanBasePackages = "com.example.kimyounghan.proxy")
public class KimyounghanApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimyounghanApplication.class, args);
	}

}
