/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealershipproject.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
/**
 *
 * @author ArmandoGonzalez
 */
public class Special {
    int id;
    LocalDate startDate;
    LocalDate endDate;
    Vehicle vehcile;
    BigDecimal discount; //should be a fraction
    String title;
    String description;
    
    //constructor
    public Special(int id) {
        this.id = id;
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Vehicle getVehcile() {
        return vehcile;
    }

    public void setVehcile(Vehicle vehcile) {
        this.vehcile = vehcile;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
