package com.example.kimyounghan.proxy.config.v1_proxy.concrete_proxy;

import com.example.kimyounghan.app.trace.TraceStatus;
import com.example.kimyounghan.app.trace.logtrace.LogTrace;
import com.example.kimyounghan.proxy.app.v2.OrderRepositoryV2;
import com.example.kimyounghan.proxy.app.v2.OrderServiceV2;

public class OrderServiceConcreteProxy extends OrderServiceV2 {
    private final OrderServiceV2 orderServiceV2;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 orderServiceV2, LogTrace logTrace) {
        super(null); // 위의 기능을 사용하지 않을 예정이기에 super(null)
        this.orderServiceV2 = orderServiceV2;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            orderServiceV2.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
