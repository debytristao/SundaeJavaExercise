package com.nbcc.icecream.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago
 */
public class Topping implements Serializable {
    
    public int id;
    public String name;
    public double price;
    private ArrayList<Topping> mockUpData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
     
    public Topping() {
        
    }

    public Topping(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public ArrayList<Topping> getToppings(){
        buildMockData();
        return mockUpData;
    }
    
    public Topping getTopping(int id){
        buildMockData();
        
        List<Topping> query = mockUpData.stream()
                .filter(m -> m.getId() == id)
                .collect(Collectors.toList());

        if (query.size() > 0) {
            return query.get(0);
        } else {
            return null;
        }
        
    }
    
    private void buildMockData(){
        this.mockUpData.add(new Topping(mockUpData.size() + 1, "Bananas", 0.99));
        this.mockUpData.add(new Topping(mockUpData.size() + 1, "Strawberries", 1.09));
        this.mockUpData.add(new Topping(mockUpData.size() + 1, "Syrup", 1.99));
        this.mockUpData.add(new Topping(mockUpData.size() + 1, "Chopped Nuts", 1.59));
        this.mockUpData.add(new Topping(mockUpData.size() + 1, "Tuna", 1.29));
        this.mockUpData.add(new Topping(mockUpData.size() + 1, "Pizza Sauce", 1.39));
    }
    
}
