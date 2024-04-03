package com.example.kimyounghan.trace.hellotrace;

import com.example.kimyounghan.trace.TraceId;
import com.example.kimyounghan.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV2 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        
        return new TraceStatus(traceId, startTimeMs, message);
    }

    public TraceStatus beginSync(TraceId beforeTraceId, String message) {
        TraceId nextId = beforeTraceId.createNextId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", nextId.getId(), addSpace(START_PREFIX, nextId.getLevel()), message);

        return new TraceStatus(nextId, startTimeMs, message);
    }

    private Object addSpace(String startPrefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < level; i++) {
            sb.append((i == level-1) ? "|" + startPrefix : "|  ");
        }

        return sb.toString();
    }

    public void end(TraceStatus status) {
        complete(status, null);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs-status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if(e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), resultTimeMs, e);
        }
    }

    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }
}
