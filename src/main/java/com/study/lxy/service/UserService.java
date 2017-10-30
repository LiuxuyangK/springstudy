package com.study.lxy.service;

import com.study.lxy.model.User;
import java.util.List;

/**
 * Created by Harry on 17/10/30.
 */


public interface UserService {
  List<User> getUsers();

  User getUserById(Integer id);
}
