package com.study.lxy.transaction;

import com.study.lxy.mapper.UserMapper;
import com.study.lxy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述：
 * <p>
 * <p>
 * harryliu
 * 2018/8/6
 */
@Service
public class TransactionSevice {
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void test1() {
        User user = new User();
        user.setAge(342);
        userMapper.insertSelective(user);

        System.out.println("-----");

        int a = 0;

//        int b = 100/a;

    }
}
