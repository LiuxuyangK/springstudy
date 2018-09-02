package com.lxy.study.mq;

import com.study.lxy.transaction.TransactionSevice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/6
 */
public class TransactionTest extends BaseTest{
    @Autowired
    private TransactionSevice transactionSevice;

    @Test
    public void test() {
        transactionSevice.test1();
        System.out.println();
    }
}
