package com.study.lxy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/22
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut(value = "args(name,number,..)")
    public void argsPointCut(String name,int number) {

    }

    @Before("argsPointCut(name,number)")
    public void crossCodeCutting(String name,int number) {
        System.out.println("----bindJoinPointParams()----");
        System.out.println("name:" + name);
        System.out.println("number:" + number);
        System.out.println("----bindJoinPointParams()----");
    }

    //在参数上的anno暂时还没做到
//    @Pointcut(value = "@args(com.study.lxy.aspect.ArgAnno)")
//    public void argAnnoPointCut() {
//
//    }
//
//    @Before("argAnnoPointCut()")
//    public void argAnno() {
//        System.out.println("----argAnno()----");
//        System.out.println("----argAnno()----");
//    }

//
//    @Before("@args(com.study.lxy.aspect.ClassAnno)")
//    public void classAnno(JoinPoint jp) {
//        System.out.println("----classAnno()----");
//        System.out.println("Accepting beans with @Entity annotation: " + jp.getArgs()[0]);
//        System.out.println("----classAnno()----");
//    }

    @Before("@annotation(com.study.lxy.aspect.MethodAnno)")
    public void methodAnno(JoinPoint jp) {
        System.out.println("----methodAnno()----");
        System.out.println("Accepting beans with @Entity annotation: " + jp.getSignature());
        System.out.println("----methodAnno()----");
    }
}
