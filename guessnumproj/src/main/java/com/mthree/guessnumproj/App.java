/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj;
import com.mthree.guessnumproj.controller.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 *
 * @author ArmandoGonzalez
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.mthree.guessnumproj");
        appContext.refresh();

        Controller controller = appContext.getBean("Controller", Controller.class);
        //controller.run();
    }
}
