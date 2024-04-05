package com.example.kimyounghan.app.v5;

import com.example.kimyounghan.trace.callback.TraceCallback;
import com.example.kimyounghan.trace.callback.TraceTemplate;
import com.example.kimyounghan.trace.logtrace.LogTrace;
import com.example.kimyounghan.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
