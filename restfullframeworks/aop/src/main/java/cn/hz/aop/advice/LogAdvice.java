package cn.hz.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//@Aspect
public class LogAdvice {
	
//	@Around("execution(* cn.hz.aop.Man.*(..))")
	public Object processAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("point cut");
		return pjp.proceed();
	}

}
