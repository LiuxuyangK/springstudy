package com.study.lxy.java8.reduce;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/5/31
 */
public class ReduceLearnTest {

    public static void main(String[] args) {
        List<Transaction> transactions = init();

        //2011年的，按交易额排序
        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println();

        //交易员都在哪些不同的城市工作过
        Set<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader()).map(Trader::getCity).collect(Collectors.toSet());
        System.out.println(collect1);
        System.out.println();

        //交易员都在哪些不同的城市工作过，按照城市分组
        Map<String, List<Trader>> collect2 = transactions.stream().map(Transaction::getTrader).collect(Collectors.groupingBy(Trader::getCity));
        System.out.println(collect2);
        System.out.println();

        //查找所有来自于剑桥的交易员，并按姓名排序
        List<Transaction> cambridge = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).sorted(Comparator.comparing(transaction -> transaction.getTrader().getName())).collect(Collectors.toList());
        System.out.println(cambridge);
        System.out.println();

        //返回所有交易员的姓名字符串，按字母顺序排序
        List<String> collect3 = transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect3);
        System.out.println();

        //有没有交易员是在米兰工作的
        boolean milan = transactions.stream().map(Transaction::getTrader).anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(milan);
        System.out.println();

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Milan")).forEach(transaction -> System.out.print(transaction.getValue()));

    }

    public static List<Transaction> init() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        return transactions;
    }

    public static void testReduce() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 34, 5, 6, 88, -1);
        Integer count = integers.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(count);
    }
}


@Data
class Trader {
    private final String name;
    private final String city;
}

@Data
class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;
}
