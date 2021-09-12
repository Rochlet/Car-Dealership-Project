/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealershipproject.dto;

/**
 *
 * @author ArmandoGonzalez
 */
public class Manufacturer {
    String make;
    String model;
    
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Manufacturer(String make, String model) {
        this.make = make;
        this.model = model;
    }  
}
