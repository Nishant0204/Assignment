package com.demo.gen1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.org.gen5")
public class Config {

    @Bean
    public Employee manager() {
        return new Manager();
    }

    @Bean
    public Employee accounts() {
        return new Accounts();
    }
    
    @Bean
    public Employee cashier() {
        return new Cashier();
    }
    
    @Bean
    public Employee security() {
        return new Security();
    }
    
    @Bean
    public Employee admin() {
        return new Admin();
    }

}