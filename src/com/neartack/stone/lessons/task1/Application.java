package com.neartack.stone.lessons.task1;

import com.neartack.stone.lessons.task1.message.MessageProducerStorage;

public class Application {


    public static void main(String[] args) {
        MessageProducerStorage storage = new MessageProducerStorage();
        storage.printMessages();
        }
        }
