package net.thjang.blog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("student.xml");

        MainController mainController = applicationContext.getBean(MainController.class);
        mainController.control();

    }
}
