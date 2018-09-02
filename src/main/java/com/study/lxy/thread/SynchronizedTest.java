package com.study.lxy.thread;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/6/6
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Sync sync = new Sync();
        Sync sync1 = new Sync();

        Thread thread = new Thread(() -> {
            sync.test1();
        });

        Thread thread1 = new Thread(() -> {
            sync1.test2();
        });

        thread.start();
        thread1.start();
    }
}

class Sync{
    public static synchronized void test1(){
        System.out.println("访问 test1： "+ System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束 test1： "+ System.currentTimeMillis());
    }

    public static synchronized void test2(){
        System.out.println("访问 test22222： "+ System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束 test22222： "+ System.currentTimeMillis());
    }
}

//访问 test1： 1528299468304
//结束 test1： 1528299471309
//访问 test22222： 1528299471310
//结束 test22222： 1528299473314
