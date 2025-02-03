package com.esercizioPomeriggio.pizzeria.menu;

import com.esercizioPomeriggio.pizzeria.bevande.Bevande;
import com.esercizioPomeriggio.pizzeria.pizze.Pizze;
import com.esercizioPomeriggio.pizzeria.toppings.Toppings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuConfig {
    @Bean
    public Pizze pizzeBean() {
        return new Pizze("Pizza Margherita", "tomato","cheese", 1104,4.99);
    }

    @Bean
    public Bevande bibiteBean() {
        return new Bevande("Coca Cola", "0.33l" , 128, 1.99);
    }

    @Bean
    public Toppings toppingsBean() {
        return new Toppings("Pepperoni", 128, 1.99);
    }




}
