package com.hh.aop;

/**
 * Created by Administrator on 15-9-30.
 * 基本的切点定义
 */
import org.apache.log4j.Logger;
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
     Logger logger = Logger.getLogger(TestAspect.class);
    //切点为com.hh.controller包下任意入参，任意返回类型的方法
    @Pointcut("execution(* com.hh.controller..*(..))")
    public void recordLog(){}//使用类的方法名作为切点  同时方法的修饰符还控制了切点的使用范围

    //@Before("execution(* com.hh.controller..*(..))")等同下面的方法
    @Before("recordLog()")//如果是其他类使用该切点，则要在前面加上类名"TestAspect.recordLog()"
    public void before() {
        System.out.println("已经记录下操作日志@Before 方法执行前");
    }

   /*发现使用该切面后springmvc无法返回视图
   @Around("recordLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        this.printLog("已经记录下操作日志@Around 方法执行前");
        //pjp.proceed();
        this.printLog("已经记录下操作日志@Around 方法执行后");
    }*/

     @After("recordLog()")
    public void after() {
        this.printLog("已经记录下操作日志@After 方法执行后");
    }

    private void printLog(String str){
        logger.error(str);
    }

}
