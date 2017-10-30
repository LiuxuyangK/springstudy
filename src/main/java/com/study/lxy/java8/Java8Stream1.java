package com.study.lxy.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Harry on 17/9/17.
 */

public class Java8Stream1 {
    public static void main(String[] args) {

        String[] words = {"hello", "word"};

        List<String[]> list = Arrays.asList(words).stream().map(word -> word.split("")).collect(toList());


        Stream<String[]> stream = Arrays.asList(words).stream().map(word -> word.split(""));


        List<Stream<String>> list2 =
            Arrays.asList(words).stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(toList());


        Integer[] integers = {1, 2, 3, 4, 5};

        List<Integer> integerList = Arrays.stream(integers).map(i -> i * i).collect(toList());

        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {3, 4};

        List<Integer> integers1 = Arrays.asList(arr1);
        List<Integer> integers2 = Arrays.asList(arr2);

        List<Integer[]> finlaList = integers1.stream().flatMap(i -> {
            return integers2.stream().map(j -> new Integer[] {i, j});
        }).collect(toList());


        int[] numbers = {2, 3, 5, 7, 11, 13};

        int sum = Arrays.stream(numbers).sum();


        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
            .reduce(new ArrayList<Integer>(), new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                @Override
                public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {

                    acc.add(item);
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("BiFunction");
                    return acc;
                }
            }, new BinaryOperator<ArrayList<Integer>>() {
                @Override
                public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {

                    System.out.println("BinaryOperator");
                    acc.addAll(item);
                    System.out.println("item1: " + item);
                    System.out.println("acc1+ : " + acc);
                    System.out.println("--------");
                    return acc;
                }
            });
        System.out.println("accResult_: " + accResult_);
        // 结果打印

        Stream<Integer> streamTest = Arrays.asList(1, 2, 3, 4, 5, 6).stream();

        List<Integer> numbers2 = streamTest.reduce(
            new ArrayList<Integer>(),
            (List<Integer> ll, Integer e) -> {
                ll.add(e);
                return ll;
            },
            (List<Integer> l1, List<Integer> l2) -> {
            l1.addAll(l2);
            return l1;
        });

        Java8Stream1 java8Stream1 = new Java8Stream1();

    }


}
