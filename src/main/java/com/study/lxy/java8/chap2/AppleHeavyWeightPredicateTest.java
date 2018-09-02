package com.study.lxy.java8.chap2;

import com.study.lxy.java8.entity.Apple;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AppleHeavyWeightPredicateTest {
    public static void main(String[] args) {
        List<Apple> apples = initApples();
        System.out.println("---start filter ----");
        List<Apple> apples1 = filterApples(apples, new AppleHeavyWeightPredicate());

        System.out.println("--- filter 2 --- ");
        Predicate<Apple> predicate = apple -> apple.getId() > 5;
        List<Apple> apples2 = filterApples2(apples, predicate);

        //大概刚刚的原因是没办法推测出来我写的lambda到底是哪种参数的。
        System.out.println("--- filter 3 --- ");
        List<Apple> apples3 = filterApples2(apples,apple -> apple.getId() > 5 );



    }

    public static List<Apple> initApples() {
        return Stream.generate(new AppleSupplier()).limit(10).peek(apple -> System.out.println(apple)).collect(Collectors.toList());
    }

    public static List<Apple> filterApples(List<Apple> list,ApplePredict applePredict) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        return list.stream().filter(apple -> applePredict.predict(apple)).collect(Collectors.toList());
    }

    public static List<Apple> filterApples2(List<Apple> list, Predicate<Apple> predicate) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

}

class AppleSupplier implements Supplier<Apple> {

    private int index = 0;
    private Random random = new Random();

    @Override
    public Apple get() {
        return new Apple(new Long(index++), "color" + random.nextInt(), random.nextInt(), new BigDecimal(random.nextDouble()));
    }
}

interface ApplePredict {
    boolean predict(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredict{
    public boolean predict(Apple apple) {
        return apple.getWeight() > 150;
    }
}