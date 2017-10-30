package com.study.lxy.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * Created by Harry on 17/9/16.
 */


class MyConparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        return 0;
    }
}


interface MyInterface {
    void print();

    void print2(int a);
}


abstract class MyInterface2 {
    public void print2(int a) {

        System.out.println("print22222");
    }
}


class MyObj extends MyInterface2 implements MyInterface {
    @Override
    public void print() {

    }
}


class Apple {
    private String color;
    private Double price;

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }
}


public class Java8Learn1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");



        //        List<String> newList =
        //            list.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(toList());


        Supplier supplier = Apple::new;
        Apple apple = (Apple) supplier.get();

        apple.setColor("red");
        apple.setPrice(1.0);

        Supplier<Apple> supplierApple = Apple::new;
        Apple apple2 = supplierApple.get();

        apple2.setColor("green");
        apple2.setPrice(2.0);

        Apple apple3 = supplierApple.get();
        apple3.setPrice(3.0);
        apple3.setColor("yellow");

        Apple apple4 = supplierApple.get();
        apple4.setPrice(5.0);
        apple4.setColor("blue");

        List<Apple> appleList = new ArrayList<>();

        appleList.add(apple);
        appleList.add(apple4);
        appleList.add(apple2);
        appleList.add(apple3);

        appleList.stream().sorted(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {

                System.out.println(o1.getPrice() + "-" + o2.getPrice());
                return 0;
            }
        }).filter(eachApple -> {
            System.out.println("each:" + eachApple.getPrice());

            return eachApple.getColor() == "red";
        }).collect(toList());


        //        MyInterface2 myInterface = () -> {
        //            System.out.println("print");
        //        };

//        Predicate<Apple> predicate = apple1 -> apple1.getColor().equals("red");
//
//        System.out.println(predicate.test(apple));
//        System.out.println(predicate.test(apple2));
//
//
//        Predicate<Apple> notRedPredicate = predicate.negate();
//
//        System.out.println(notRedPredicate.test(apple));
//        System.out.println(notRedPredicate.test(apple2));
    }
}
