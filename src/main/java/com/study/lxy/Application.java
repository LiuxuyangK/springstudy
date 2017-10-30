package com.study.lxy;

import com.study.lxy.other.MessagePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Harry on 17/8/6.
 */

//@Configuration
//@ComponentScan
//public class Application {
//
////
////    @Bean("messageService2")
////    MessageService mockMessageService1() {
////        return new MessageService() {
////            public String getMessage(String param) {
////                return "aaaa";
////            }
////        };
////    }
//
//    public static void main(String[] args) {
//        ApplicationContext context =
//            new AnnotationConfigApplicationContext(Application.class);
//        MessagePrinter printer = context.getBean(MessagePrinter.class);
//        printer.printMessage();
//    }
//}
