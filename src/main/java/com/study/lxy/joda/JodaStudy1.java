package com.study.lxy.joda;

import org.joda.time.DateTime;

public class JodaStudy1 {
    public static void main(String[] args) {
        DateTime dt = new DateTime();
        DateTime lastday = dt.dayOfMonth().withMaximumValue();

        System.out.println(lastday);
    }
}
