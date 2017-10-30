package com.study.lxy.java8;

import java.util.Date;

/**
 * Created by Harry on 17/9/17.
 */
public class InnerClassTest2 {
    public static void main(String[] args) {

        int counter = 0;

        final int[]counter1 = new int[1];

        Date[] dates = new Date[100];

//        for (int i = 0; i < dates.length; i++) {
//            dates[i] = new Date(){
//                @Override
//                public int compareTo(Date anotherDate) {
//
//                    counter ++ ;    //error
//
//                    counter1[0] ++;
//                    return super.compareTo(anotherDate);
//                }
//            };
//        }
    }
}
