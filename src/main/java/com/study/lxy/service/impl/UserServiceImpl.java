package com.study.lxy.service.impl;

import com.study.lxy.mapper.UserMapper;
import com.study.lxy.model.User;
import com.study.lxy.model.UserExample;
import com.study.lxy.model.UserExample.Criteria;
import com.study.lxy.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Harry on 17/10/30.
 */

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public List<User> getUsers() {
    UserExample userExample = new UserExample();
    return userMapper.selectByExample(userExample);
  }

  @Override
  public User getUserById(Integer id) {
    return userMapper.selectByPrimaryKey(id);
  }
}
