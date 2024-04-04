package com.example.kimyounghan.trace.logtrace;

import com.example.kimyounghan.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
