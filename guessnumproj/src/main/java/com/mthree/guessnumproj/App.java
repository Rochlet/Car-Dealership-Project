package com.mthree.guessnumproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author ArmandoGonzalez & Eric
 */

@SpringBootApplication
@ComponentScan({"com.mthree.guessnumproj"})
public class App {
    public static void main(String[] args) {
       SpringApplication.run(App.class, args);
    }
}
