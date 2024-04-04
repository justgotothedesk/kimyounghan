package com.example.kimyounghan;

import com.example.kimyounghan.trace.logtrace.FieldLogTrace;
import com.example.kimyounghan.trace.logtrace.LogTrace;
import com.example.kimyounghan.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
