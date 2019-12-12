package com.neartack.stone.lessons.task1.message;

import com.neartack.stone.lessons.task1.message.producers.DataMessageProducer;
import com.neartack.stone.lessons.task1.message.producers.HardcodedMessageProducer;
import com.neartack.stone.lessons.task1.message.producers.RandomHardcodedMessageProducer;

import java.util.*;

public class MessageProducerStorage {
    private List<MessageProducer> messageProducers = new ArrayList<>();

    public MessageProducerStorage() {
        messageProducers.add(new HardcodedMessageProducer());
        messageProducers.add(new RandomHardcodedMessageProducer());
        messageProducers.add(new DataMessageProducer());
        Collections.shuffle(messageProducers);
    }


    public List<MessageProducer> getMessageProducers() {
        return Collections.unmodifiableList(messageProducers);
    }

    public void printMessages() {
        ArrayList<String> sortedMessages = new ArrayList<>();
        for (MessageProducer producer : messageProducers) {
            sortedMessages.add(producer.produce());
        }

        sort(sortedMessages);

        System.out.println("Messages:");
        System.out.println("-------------------------------------------------");


        int i = 0;
        for (String message : sortedMessages) {
            i++;
            System.out.println(i + ") " + message);
        }
    }

    private void sort(ArrayList<String> sortedMessages) {


        for (int i = sortedMessages.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedMessages.get(j).length() <= sortedMessages.get(j + 1).length()) {
                    String J = sortedMessages.get(j);
                    String J1 = sortedMessages.get(j + 1);
                    sortedMessages.set(j, J1);
                    sortedMessages.set(j + 1, J);
                }
            }
        }

    }
}
