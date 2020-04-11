package com.neartack.stone.lessons;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTestClass {

   public static final Logger LOGGER = LoggerFactory.getLogger(MyTestClass.class);


    public static void main(String[] args) {
      //  DOMConfigurator.configure("./log4j.xml");
        System.out.println("111");




        LOGGER.info("Начало работы программы!!!");

        try {
            LOGGER.warn("Внимание! Программа пытается разделить одно число на другое");
            System.out.println(12 / 0);
        } catch (ArithmeticException x) {
           LOGGER.error("Ошибка! Произошло деление на ноль!", x);
        }
    }
}
