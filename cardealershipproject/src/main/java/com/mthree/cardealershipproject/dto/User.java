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
public class User {
    enum ROLE {
        ADMIN, SALES, DISABLE;
    }
    String firstName;
    String lastName;
    String email; //should be unique
    String password;
    ROLE role;
    
    //constructor
    public User(String email) {
        this.email = email;
    }
    
    //getters and setters

    public String getEmail() {
        return email;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
    
}
