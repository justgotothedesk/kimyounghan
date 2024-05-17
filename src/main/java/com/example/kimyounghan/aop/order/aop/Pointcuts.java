package com.example.kimyounghan.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.example.kimyounghan.aop.order..*(..))")
    public void allOrder(){}

    @Pointcut("execution(* com.example.kimyounghan.aop.order..*(..))")
    public void allService(){}

    @Pointcut("allOrder() && allService()")
    public void orderAndService() {}
}
