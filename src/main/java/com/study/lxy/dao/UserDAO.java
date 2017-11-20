package com.study.lxy.dao;

import com.study.lxy.model.User;

/**
 * Created by Harry on 17/11/16.
 */
public interface UserDAO {



  public void saveUser(final User user);

  User getUser(final int id);
}
