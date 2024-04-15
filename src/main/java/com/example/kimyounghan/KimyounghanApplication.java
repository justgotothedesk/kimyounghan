package com.example.kimyounghan;

import com.example.kimyounghan.app.trace.logtrace.LogTrace;
import com.example.kimyounghan.app.trace.logtrace.ThreadLocalLogTrace;
import com.example.kimyounghan.proxy.config.AppV1Config;
import com.example.kimyounghan.proxy.config.AppV2Config;
import com.example.kimyounghan.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.example.kimyounghan.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.example.kimyounghan.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

// @Import({AppV1Config.class, AppV2Config.class})
// @Import(InterfaceProxyConfig.class)
// @Import(ConcreteProxyConfig.class)
@Import(DynamicProxyBasicConfig.class)
@SpringBootApplication (scanBasePackages = "com.example.kimyounghan.proxy")
public class KimyounghanApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimyounghanApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
