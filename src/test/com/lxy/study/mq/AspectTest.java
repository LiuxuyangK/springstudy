package com.lxy.study.mq;

import com.study.lxy.aspect.ClientClass;
import com.study.lxy.aspect.ILogBiz;
import com.study.lxy.aspect.LogBiz;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/22
 */
public class AspectTest extends BaseTest{
    @Autowired
    private ILogBiz logBiz;

    @Test
    public void logTest() {
        logBiz.test("lxy",2);
    }

    //这个是不行的
//    @Test
//    public void argAnnoTest() {
//        logBiz.test2(2);
//    }

    @Test
    public void classAnnoTest() {
        logBiz.test3(new ClientClass());
    }

    @Test
    public void methodAnnoTest() {
        logBiz.test4();
    }
}
