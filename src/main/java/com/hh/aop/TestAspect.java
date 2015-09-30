package com.hh.aop;

/**
 * Created by Administrator on 15-9-30.
 */
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
    @Pointcut("execution(* com.hh.controller.*(..))")
    public void recordLog(){}

    @Before("recordLog()")
    public void before() {
        System.out.println("已经记录下操作日志@Before 方法执行前");
    }

    @Around("recordLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        this.printLog("已经记录下操作日志@Around 方法执行前");
        pjp.proceed();
        this.printLog("已经记录下操作日志@Around 方法执行后");
    }

    @After("recordLog()")
    public void after() {
        this.printLog("已经记录下操作日志@After 方法执行后");
    }

    private void printLog(String str){
        System.out.println(str);
    }

}
