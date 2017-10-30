package com.study.lxy.mapper;

import com.study.lxy.model.User;
import com.study.lxy.model.UserExample;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}