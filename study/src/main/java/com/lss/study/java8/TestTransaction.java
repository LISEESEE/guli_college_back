package com.lss.study.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TestTransaction {
    List<Transaction> transactions = new ArrayList<>();

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions =
                Arrays.asList(
                        new Transaction(brian, 2011, 300),
                        new Transaction(raoul, 2012, 1000),
                        new Transaction(raoul, 2011, 400),
                        new Transaction(mario, 2012, 710),
                        new Transaction(mario, 2012, 700),
                        new Transaction(alan, 2012, 950));
    }

    //1、找出2011年发生的所有交易，并按交易额排序（从低到高）
    @Test
    public void test1() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().forEach(System.out::println);
    }

    @Test
    public void test3() {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getCity())).distinct()
                .forEach(System.out::println);
    }
  @Test
  public void test4() {
    transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .sorted()
            .forEach(System.out::println);
    String reduce = transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .sorted()
            .reduce("", String::concat);
    System.out.println(reduce);

  }
  @Test
  public void test5() {
    boolean b1 = transactions.stream()
            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    System.out.println(b1);
  }
  @Test
  public void test6() {
    Optional<Integer> sum = transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .reduce(Integer::sum);
    System.out.println(sum.get());
  }
  @Test
  public void test7() {
    Optional<Integer> max = transactions.stream()
            .map(Transaction::getValue)
            .max(Integer::compare);
    System.out.println(max.get());
  }
  @Test
  public void test8() {
    Optional<Transaction> min = transactions.stream()
            .min(Comparator.comparingInt(Transaction::getValue));
    System.out.println(min.get());
  }
}