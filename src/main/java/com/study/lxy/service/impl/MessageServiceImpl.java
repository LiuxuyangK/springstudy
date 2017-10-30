package com.study.lxy.service.impl;

import com.study.lxy.service.MessageService;
import com.study.lxy.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Harry on 17/8/6.
 */

@Service("messageServiceImpl1")
public class MessageServiceImpl implements MessageService {

    public String getMessage(String param) {

        if (StringUtils.isEmpty(param)) {
            return null;
        }

        return "getMessage:" + param;
    }
}
