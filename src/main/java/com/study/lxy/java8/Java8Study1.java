package com.study.lxy.java8;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Study1 {



    public static void main(String[] args) {
        Java8Study1 study1 = new Java8Study1();
        List<Article> articles = study1.initArticles();

        //        study1.distinctTest();

        //        study1.reduceTest();

        //        study1.sortedTest();

        //        study1.generateTest();

//        study1.flatMapTest3();

        study1.predicateTest();
    }

    public void predicateTest() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        //true
        System.out.println(evenNumbers.test(1000));

        //false 这为啥就代表了装箱呢？
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println(oddNumbers.test(1000));
    }
    public void flatMapTest4() {
        Stream<int[]> stream = IntStream.rangeClosed(1, 100).filter(a1 -> a1 > 3).boxed().flatMap(
            a -> IntStream.range(a, 100)
                            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                            .mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}));

    }

    public void flatMapTest3(){
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
            "hello world welcome");

        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        //flatMap()好像要传入一个参数，然后包成一个Stream，但是它又会帮你把这个stream打开。变成零散的一个个元素。
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //用Arrays::stream() 来包装
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //输出：
//        java.util.stream.ReferencePipeline$Head@4e50df2e
//        java.util.stream.ReferencePipeline$Head@1d81eb93
//        java.util.stream.ReferencePipeline$Head@7291c18f
//        java.util.stream.ReferencePipeline$Head@34a245ab
//            ----------
//        hello
//        welcome
//        world
        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        //实际上返回的类似是不同的
        //map是返回一个stream
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

        //在flatMap中，用每个item去循环，然后在list3中进行map，返回一个stream
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

        System.out.println(list2Result2);
        //输出结果
        //[hello zhangsan, hello lisi, hello wangwu, hello zhaoliu, hi zhangsan, hi lisi, hi wangwu, hi zhaoliu, 你好 zhangsan, 你好 lisi, 你好 wangwu, 你好 zhaoliu]
    }

    public void flatMapTest2() {
        Stream<int[]> result = IntStream.rangeClosed(1, 100)
            .filter(a1-> a1>=3)
            .boxed() //转换为对象流,因为要存放数组对象呢,这个IntStream是不支持的

            //将流扁平化,因为每个a都是一个流,而最终需要的是数组流，a不是一个stream，只是需要把过程中的IntStream变成 Stream
            .flatMap(      a->

                //这个表达式的执行会返回一个stream，里边的a就是一个普通的int，但是经过了变化：
                //先是过滤了一下，然后执行了一个mapToObj，这个会返回一个Stream
                //然后外层的flatMap会把每个stream，再打开。
                IntStream.range(a, 100)
                    .filter(b->Math.sqrt(a*a+b*b)%1==0)

                    //转化为对象流  boxed()与mapToObj(xx)等价
                    .mapToObj(b-> new int[]{a,b,(int)Math.sqrt(a*a+b*b)})
            );

        result.forEach(s->System.out.println(s[0]+","+s[1]+","+s[2]));
    }

    public void flatMapTest() {

        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
            list.stream()
                .map(x -> x.getBook())      //Stream<Set<String>>
                .flatMap(x -> x.stream())   //Stream<String>
                .distinct()
                .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }

    public void generateTest() {

        //传入一个Supplier即可
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::print);

        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
            limit(10).forEach(System.out::print);

        //自己实现Supplier
        Stream.generate(new Supplier<Integer>() {

            @Override public Integer get() {

                return 2;
            }
        }).limit(10).forEach(System.out::print);
    }

    public void sortedTest() {
        //用默认自带的sort
        List<Integer> list = Stream.of(4, 5, 6, 1, 9, 0).sorted().collect(Collectors.toList());
        System.out.println(list);

        //new了一个Comparaotr的匿名类
        List<Integer> list2 = Stream.of(9898, 1, 4, 2, 88, 5).sorted(new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).collect(Collectors.toList());
        System.out.println(list2);

        //lambda表达式 的比较器
        List<Integer> list3 = Stream.of(9898, 1, 4, 2, 88, 5).sorted((o1, o2) -> o1 - o2)
            .collect(Collectors.toList());
        System.out.println(list3);

    }

    public List<Article> initArticles() {
        List<Article> articles = new ArrayList<>();

        Article article1 = new Article("title1", "author1", Arrays.asList("a", "b", "c"));
        Article article2 = new Article("title2", "author2", Arrays.asList("a", "b", "c"));
        Article article3 = new Article("title3", "author3", Arrays.asList("a", "b", "c"));
        Article article4 = new Article("title4", "author4", Arrays.asList("a", "b", "c"));
        Article article5 = new Article("title5", "author5", Arrays.asList("a", "b", "c2"));
        Article article6 = new Article("title6", "author6", Arrays.asList("a", "b", "c"));

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);

        return articles;
    }


    public Optional<Article> getFirstJavaArticle(List<Article> articles) {
        return articles.stream().filter(article -> article.getTags().contains("Java")).findFirst();
    }

    public List<Article> getArticleList(List<Article> articles) {
        return articles.stream().filter(article -> article.getTags().contains("c2"))
            .collect(Collectors.toList());
    }

    public Map<String, List<Article>> groupByArticles(List<Article> articles) {
        return articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
    }

    public int getSum(List<Article> articles) {
        return articles.stream().mapToInt(Article::getAge).sum();
    }

    public void getIntStream() {
        IntStream.of(2, 3, 4, 5, 6, 100, 0, -324234).forEach(System.out::println);
    }

    //去重
    public void distinctTest() {

        //尝试使用list.forEach
        Arrays.asList(3, 4, 5, 5, 6, 7, 8).stream().distinct().collect(Collectors.toList())
            .forEach(System.out::print);

        System.out.println();
        //尝试使用 stream.forEach
        Arrays.asList(3, 4, 5, 5, 6, 7, 8).stream().distinct().forEach(System.out::print);

        System.out.println();
        //尝试使用 toSet 去重
        Arrays.asList(3, 4, 5, 5, 6, 7, 8).stream().collect(Collectors.toSet())
            .forEach(System.out::print);
    }

    public void reduceTest() {

        //reduce求和，没有起始值.没有起始值的 reduce()，由于可能没有足够的元素，返回的是 Optional
        int sum = Stream.of(1, 3, 4, 5, 6).reduce(Integer::sum).get();
        System.out.println(sum);

        //reduce 求和，有起始值
        int sum2 = Stream.of(1, 3, 4, 5, 6).reduce(0, Integer::sum);
        System.out.println(sum2);

        //IntStream 的 sum（）hansu
        int sum3 = IntStream.of(1, 3, 4, 5, 6).sum();
        System.out.println(sum3);

        //reduce 求最小值
        int minVal = Stream.of(1, 3, 4, 5, 6).reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(minVal);

        //IntStream .reduce 求最小值，IntStream 中不能有1.1
        int minVal2 = IntStream.of(1, 3, 4, 5, 6).reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(minVal2);

        //连接字符串
        String str = Stream.of("a", ",world,", "hello").reduce("", String::concat);
        System.out.println(str);
    }

    class Article {

        private final String title;
        private final String author;
        private final List<String> tags;

        private int age = 4;

        private Article(String title, String author, List<String> tags) {
            this.title = title;
            this.author = author;
            this.tags = tags;
        }

        private Article(String title, String author, List<String> tags, int age) {
            this.title = title;
            this.author = author;
            this.tags = tags;
            this.age = age;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public List<String> getTags() {
            return tags;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    class Student {

        private String name;
        private Set<String> book;

        public void addBook(String book) {
            if (this.book == null) {
                this.book = new HashSet<>();
            }
            this.book.add(book);
        }
        //getters and setters


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<String> getBook() {
            return book;
        }

        public void setBook(Set<String> book) {
            this.book = book;
        }
    }
}


interface Defaultable {
    default void print() {
        System.out.println("this is default method");
    }
}
