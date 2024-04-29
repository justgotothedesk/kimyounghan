package com.example.kimyounghan.proxy.cgclib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        Object result = proxy.invoke(target, args);
        // Object result = method.invoke(target, args); 위에 것이 더 빠르고 권장됨

        long endTime = System.currentTimeMillis();
        long resultTime = endTime-startTime;
        log.info("TimeProxy 종료 resultTime = {}", resultTime);

        return result;
    }
}
