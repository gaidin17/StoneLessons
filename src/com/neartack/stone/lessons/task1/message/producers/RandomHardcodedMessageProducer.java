package com.neartack.stone.lessons.task1.message.producers;

import com.neartack.stone.lessons.task1.message.MessageProducer;

import java.util.Random;

public class RandomHardcodedMessageProducer implements MessageProducer {
    private String[] messages = {"go to Hell", "Good boy!", "Time to eat!", "fuck off!", "Do not forget to create a pull request!"};

    @Override
    public String produce() {
        Random random = new Random();
        int messageIndex = random.nextInt(messages.length);
        return messages[messageIndex];
    }
}
