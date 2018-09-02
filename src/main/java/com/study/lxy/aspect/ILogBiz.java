package com.study.lxy.aspect;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/23
 */
public interface ILogBiz {
    public void test(String name1,int number1);

    //    public void test2(@ArgAnno(need = true) int age) {
//        System.out.println("==========test2=========");
//    }
//
    public void test3(ClientClass clientClass);

    void test4();
}
