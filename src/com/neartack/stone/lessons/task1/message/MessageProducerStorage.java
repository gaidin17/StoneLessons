package com.neartack.stone.lessons.task1.message;

import com.neartack.stone.lessons.task1.message.producers.HardcodedMessageProducer;
import com.neartack.stone.lessons.task1.message.producers.RandomHardcodedMessageProducer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageProducerStorage {
    private final List<MessageProducer> messageProducers = new ArrayList<>();

    public MessageProducerStorage() {
        messageProducers.add(new HardcodedMessageProducer());
        messageProducers.add(new RandomHardcodedMessageProducer());
        Collections.shuffle(messageProducers);
    }


    public List<MessageProducer> getMessageProducers() {
        return Collections.unmodifiableList(messageProducers);
    }

    public void printMessages() {
        System.out.println("Messages:");
        System.out.println("-------------------------------------------------");
        for(MessageProducer producer: messageProducers) {
            System.out.println(producer.produce());
        }
    }

}
