package com.example.kimyounghan.proxy.config.v1_proxy.concrete_proxy;

import com.example.kimyounghan.app.trace.TraceStatus;
import com.example.kimyounghan.app.trace.logtrace.LogTrace;
import com.example.kimyounghan.proxy.app.v2.OrderControllerV2;

public class OrderControllerConcreteProxy extends OrderControllerV2 {
    private final OrderControllerV2 orderControllerV2;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 orderControllerV2, LogTrace logTrace) {
        super(null);
        this.orderControllerV2 = orderControllerV2;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            String result = orderControllerV2.request(itemId);
            logTrace.end(status);

            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return orderControllerV2.noLog();
    }
}
