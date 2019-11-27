package com.neartack.stone.lessons.task1.message.producers;

import com.neartack.stone.lessons.task1.message.MessageProducer;

import java.util.Date;

public class DataMessageProducer implements MessageProducer {
    @Override
    public String produce() {
        Date date = new Date();

        return "Сегодня " + date;
    }
}
