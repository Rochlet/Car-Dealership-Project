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
public class Purchase {
    enum PURCHASE_TYPE {
        BANK_FINANCE, CASH, DEALER_FINANCE;
    }
    String id;
    String buyerName;
    String buyerPhone;
    String buyerStreet;
    String buyerCity;
    String buyerZipCode;
    PURCHASE_TYPE purchaseType;
    User dealer;
    Vehicle vehicle;
    BigDecimal purchasePrice;
    LocalDate purchaseDate;
    
    //constructor
    public Purchase(String id) {
        this.id = id;
    }
    
    //getters and setters
    public String getId() {
        return id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerStreet() {
        return buyerStreet;
    }

    public void setBuyerStreet(String buyerStreet) {
        this.buyerStreet = buyerStreet;
    }

    public String getBuyerCity() {
        return buyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }

    public String getBuyerZipCode() {
        return buyerZipCode;
    }

    public void setBuyerZipCode(String buyerZipCode) {
        this.buyerZipCode = buyerZipCode;
    }

    public PURCHASE_TYPE getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(PURCHASE_TYPE purchaseType) {
        this.purchaseType = purchaseType;
    }

    public User getDealer() {
        return dealer;
    }

    public void setDealer(User dealer) {
        this.dealer = dealer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    
}
