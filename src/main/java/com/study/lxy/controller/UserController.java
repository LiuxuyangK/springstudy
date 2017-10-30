package com.study.lxy.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.lxy.model.User;
import com.study.lxy.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Harry on 17/10/30.
 */

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/getUsers")
  @ResponseBody
  public String getUsers() {
    List<User> userList = userService.getUsers();
    return JSONObject.toJSONString(userList);
  }

  @RequestMapping("/getUserById")
  @ResponseBody
  public User getUserById(Integer id) {
    User user = userService.getUserById(id);
    return user;
  }

}
