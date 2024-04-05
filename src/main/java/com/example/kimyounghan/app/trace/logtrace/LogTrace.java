package com.example.kimyounghan.app.trace.logtrace;

import com.example.kimyounghan.app.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
