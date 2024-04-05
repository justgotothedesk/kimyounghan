package com.example.kimyounghan.app.trace.template;

import com.example.kimyounghan.app.trace.logtrace.LogTrace;
import com.example.kimyounghan.app.trace.TraceStatus;

public abstract class AbstractTemplate<T> {
    private final LogTrace trace;

    protected AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = call(); // 반복되는 로직 추상화
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
