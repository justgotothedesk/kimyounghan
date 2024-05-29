package com.example.kimyounghan.aop.exam;

import com.example.kimyounghan.aop.exam.annotation.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    @Trace
    public void request(String itmeId) {
        examRepository.save(itmeId);
    }
}
