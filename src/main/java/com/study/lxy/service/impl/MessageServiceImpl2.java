package com.study.lxy.service.impl;

import com.study.lxy.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * Created by Harry on 17/8/6.
 */

@Service("messageServiceImpl2")
public class MessageServiceImpl2 implements MessageService{
    public String getMessage(String param) {

        return "message 2";
    }
}
