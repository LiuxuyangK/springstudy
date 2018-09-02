package com.study.lxy.java8.stream;

import java.util.stream.IntStream;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/6/6
 */
public class StreamTest1 {
    public static void main(String[] args) {

        //IntStream.range(1, 100)
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        System.out.println(evenNumbers.count());
    }

    public static void bidagelasi() {

    }
}
