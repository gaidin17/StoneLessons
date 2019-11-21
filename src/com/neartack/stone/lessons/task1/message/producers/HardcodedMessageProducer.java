package com.neartack.stone.lessons.task1.message.producers;

import com.neartack.stone.lessons.task1.message.MessageProducer;

public class HardcodedMessageProducer implements MessageProducer {

    @Override
    public String produce() {
        return "Hardcoded message";
    }
}
