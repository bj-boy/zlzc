package com.zlzc.common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zlzc.common.annotation.RespTime;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Order(1)
@Component
@Lazy(false)
@Slf4j
public class TimeAspect {

	@Pointcut("@annotation(com.zlzc.common.annotation.RespTime)")
	public void timePointCut() {
	}

	@Around("timePointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Method method = ((MethodSignature) point.getSignature()).getMethod();
		RespTime time = method.getAnnotation(RespTime.class);
		long beginTime = System.currentTimeMillis();
		Object object = point.proceed();
		log.info(time.value() + " ==============> 接口响应时间 totalTime: " + (System.currentTimeMillis() - beginTime) + "ms");
		return object;
	}
}
