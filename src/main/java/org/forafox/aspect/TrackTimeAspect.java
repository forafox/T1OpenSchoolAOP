package org.forafox.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.forafox.domain.MethodData;
import org.forafox.service.MethodDataService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class TrackTimeAspect {
    private final MethodDataService methodDataService;

    @Around("@annotation(org.forafox.annotation.TrackTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature().toShortString()+ " executed in " + executionTime + "ms");
        var methodData = new MethodData();
        methodData.setMethodName(joinPoint.getSignature().toShortString());
        methodData.setExecuteTime(executionTime);
        methodData.setExecuteDate(new Date());
        methodDataService.save(methodData);
        return proceed;
    }


}
