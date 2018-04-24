/*
 * File: Subheading.java
 * Author: Malik Midani mikex535@uab.edu
 * Assignment:  SEDproject - EE333 Spring 2018
 * Vers: 1.0.0 04/20/2018 MM - initial coding
 *
 * Credits:  (if any for sections of code)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malik Midani mikex535@uab.edu
 */
public class Subheading {
    private String name;
    
    public Subheading(){
        
    }
        
    public Subheading(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

}
