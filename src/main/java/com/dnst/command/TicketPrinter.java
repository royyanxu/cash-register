package com.dnst.command;

import com.dnst.controller.OrderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Finley
 */
public class TicketPrinter {
    private final static Logger logger = LoggerFactory.getLogger(TicketPrinter.class);
    private final static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "applicationContext.xml");


    private static final String test1 = "['ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000003-2','ITEM000005','ITEM000005','ITEM000005']";


    public static void main(String[] args) {
        OrderController orderController = applicationContext.getBean(OrderController.class);
        try {
            orderController.generateAndPrintOrder(test1);
        } catch (Exception ex) {
            logger.error("When call the generate and print order error occur.", ex);
            System.out.println("The system error occur.");
        }
    }
}
