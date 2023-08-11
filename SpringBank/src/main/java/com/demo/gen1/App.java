package com.demo.gen1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Employee manager = context.getBean("manager", Employee.class);
        manager.doWork();

        Employee accounts = context.getBean("accounts", Employee.class);
        accounts.doWork();
        
        Employee cashier = context.getBean("cashier", Employee.class);
        cashier.doWork();
        
        Employee security = context.getBean("security", Employee.class);
        security.doWork();
        
        Employee admin = context.getBean("admin", Employee.class);
        admin.doWork();
    }
}