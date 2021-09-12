/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealershipproject.dto;

import java.math.BigDecimal;
/**
 *
 * @author ArmandoGonzalez
 */
public class Vehicle {
    enum TRANSMISSION {
        AUTOMATIC, MANUAL;
    }
    enum COLOR {
        RED, BLUE, WHITE, BLACK, GRAY;
    }
    enum BODY_STYLE {
        CAR, SUV, TRUCK, VAN;
    }
    
    String vin;
    Manufacturer manufacturer;
    String photoLink;
    String description;
    int mileage;
    BigDecimal salesPrice;
    BigDecimal msrp;
    TRANSMISSION transimission;
    COLOR color;
    int year;
    BODY_STYLE bodyStyle;
    boolean isUsed;
    
    //constructor
    public Vehicle(String vin) {
        this.vin = vin;
    }
    
    
    //getters and setters
    public String getVin() {
        return vin;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    public TRANSMISSION getTransimission() {
        return transimission;
    }

    public void setTransimission(TRANSMISSION transimission) {
        this.transimission = transimission;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BODY_STYLE getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(BODY_STYLE bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
