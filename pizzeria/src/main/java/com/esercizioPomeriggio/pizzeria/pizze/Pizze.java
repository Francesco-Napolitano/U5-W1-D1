package com.esercizioPomeriggio.pizzeria.pizze;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizze {

    private Long id;
    private String pizzaMargherita;
    private String tomato;
    private List <Pizze> ingredienti;
    private String cheese;
    private int i;
    private double v;

    public Pizze(String pizzaMargherita, String tomato, String cheese, int i, double v) {
        this.pizzaMargherita = pizzaMargherita;
        this.tomato = tomato;
        this.cheese = cheese;
        this.i = i;
        this.v = v;
        this.ingredienti = new ArrayList<>();
    }

    public Pizze addIngredients(Pizze ingredienti){
        this.ingredienti.add(ingredienti);
        return this;
    }

    public void printPizze() {
        System.out.println(pizzaMargherita);
        System.out.println(tomato);
        System.out.println(cheese);
        System.out.println(i);
        System.out.println(v);
    }
}
