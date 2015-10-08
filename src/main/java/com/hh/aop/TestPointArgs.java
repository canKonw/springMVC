package com.hh.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 15-10-9.
 */
@Component
@Aspect
public class TestPointArgs {
    Logger logger = Logger.getLogger(TestPointArgs.class);

     @Before("target(com.hh.controller.UserController) && args(arg1)")
     public void getArgs(int arg1){//该处的参数名必须与args(arg1)中的一致  参数的个数和类型将去匹配被切方法的入参  这表示入参是一个，且是int类型
        logger.error("-----------------TestPointArgs");
        logger.error("-----------------arg1:"+arg1);
     }

    @After("target(com.hh.controller.UserController) && args(arg1,arg2)")
    public void getArgs2(int arg1,String arg2){//该处的参数名必须与args(arg1)中的一致  参数的个数和类型将去匹配被切方法的入参  这表示入参是一个，且是int类型
        logger.error("-----------------TestPointArgs");
        logger.error("-----------------arg1:"+arg1);
        logger.error("-----------------arg1:"+arg2);
    }


}
