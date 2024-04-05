package com.example.kimyounghan.trace.callback;

import com.example.kimyounghan.trace.TraceStatus;
import com.example.kimyounghan.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;

public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = callback.call(); // 반복되는 로직 추상화
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
