package com.hh.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 获得连接点的信息   获得方法传入参数的信息
 * Created by Administrator on 15-10-8.
 */
@Component
@Aspect
public class TestJoinPoint {
    Logger logger = Logger.getLogger(TestJoinPoint.class);
    @Pointcut("execution(* com.hh.controller..*(..))")
    public void point(){}

    @Around("point()")//只能使用环绕通知
    public void getArgs(ProceedingJoinPoint pjp) throws Throwable{
        logger.error("获得方法中的参数如下：");
        logger.error("参数数量："+pjp.getArgs().length);
        for(int i = 0;i<pjp.getArgs().length;i++){
            logger.error("----------------------");
            logger.error("参数名："+pjp.getArgs()[i]);
            logger.error("调用类："+pjp.getTarget().getClass()) ;
        }
        pjp.proceed();//方法继续向下执行  比天际此举将影响被切入的方法的运行
    }
}
