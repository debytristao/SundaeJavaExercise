package com.nbcc.icecream.models;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago
 */
public class Sundae implements Serializable {
    
    public static final double SALES_TAX_RATE = 0.13;
    public int id;
    public double subtotal;  
    public double tax;
    
    public ArrayList<Topping> toppings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        tax = getSubtotal() * SALES_TAX_RATE;
        return tax;
    }
    
    public Sundae() {
    }
    
    public double calculateTotal(){
        double toppingtotal =0;
        for(Topping top : toppings){
            toppingtotal += top.price;
        }
        
        setSubtotal(getSubtotal() + toppingtotal);
        
        return getSubtotal() + getTax();
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }
    
    
    
}
