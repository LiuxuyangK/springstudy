package com.study.lxy.other;

import com.study.lxy.service.MessageService;
import com.study.lxy.service.impl.MessageServiceImpl;
import com.study.lxy.service.impl.OtherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Harry on 17/8/6.
 */

@Component
public class MessagePrinter {

    final private MessageService service = null;

    //        @Autowired
    //        @Qualifier("messageServiceImpl1")
    //    @Resource(name = "messageServiceImpl1")
    private MessageServiceImpl messageService;


    //    @Autowired
    //    public MessagePrinter(MessageService service) {
    //
    //        this.service = service;
    //    }

//    @Autowired
////    @Qualifier("messageServiceImpl1")
////    public void getService(MessageServiceImpl messageService) {
//    public void getService(OtherBean otherBean) {
////    public void getService(String abc) {
//
//        this.messageService  = null;
//        System.out.println("执行");
//
//        return ;
//    }

    public void printMessage() {

        System.out.println(this.messageService.getMessage("message"));
    }
}
