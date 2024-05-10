package com.example.kimyounghan.aop;

import com.example.kimyounghan.aop.order.OrderRepository;
import com.example.kimyounghan.aop.order.OrderService;
import com.example.kimyounghan.aop.order.aop.AspectV1;
import com.example.kimyounghan.aop.order.aop.AspectV2;
import com.example.kimyounghan.aop.order.aop.AspectV3;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
// @Import(AspectV1.class)
// @Import(AspectV2.class)
@Import(AspectV3.class)
public class AopTest {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public AopTest(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Test
    void aopInfo() {
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success() {
        orderService.orderItem("itemA");
    }

    @Test
    void exception() {
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }
}
