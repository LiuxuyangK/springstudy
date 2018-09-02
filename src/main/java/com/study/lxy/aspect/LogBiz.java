package com.study.lxy.aspect;

import org.springframework.stereotype.Component;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/22
 */
@Component
public class LogBiz implements ILogBiz{
    public void test(String name1,int number1){
        System.out.println("this is test");
    }

//    public void test2(@ArgAnno(need = true) int age) {
//        System.out.println("==========test2=========");
//    }
//
    public void test3(ClientClass clientClass) {
        System.out.println("==========test3(clientClass)=========");
    }

    @Override
    @MethodAnno
    public void test4() {
        System.out.println("==========test444(clientClass)=========");
    }
}
