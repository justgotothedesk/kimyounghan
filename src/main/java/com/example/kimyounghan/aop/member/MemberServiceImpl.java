package com.example.kimyounghan.aop.member;

import com.example.kimyounghan.aop.member.annotation.ClassAOP;
import com.example.kimyounghan.aop.member.annotation.MethodAOP;
import org.springframework.stereotype.Component;

@ClassAOP
@Component
public class MemberServiceImpl implements MemberService{
    @Override
    @MethodAOP("test value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param) {
        return "ok";
    }
}
