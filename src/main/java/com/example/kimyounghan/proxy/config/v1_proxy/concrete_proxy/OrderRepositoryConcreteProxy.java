package com.example.kimyounghan.proxy.config.v1_proxy.concrete_proxy;

import com.example.kimyounghan.app.trace.TraceStatus;
import com.example.kimyounghan.app.trace.logtrace.LogTrace;
import com.example.kimyounghan.proxy.app.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 orderRepositoryV2, LogTrace logTrace) {
        this.orderRepositoryV2 = orderRepositoryV2;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");
            orderRepositoryV2.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
