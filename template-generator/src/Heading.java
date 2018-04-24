
import java.util.ArrayList;

/*
 * File: Heading.java
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
public class Heading {
    
    private String name;
    private ArrayList<Subheading> subheadings;
    private int shcount;
    
    public Heading(){
        subheadings = new ArrayList<>();
        shcount = 0;
    }
    
    public Heading(String name){
        subheadings = new ArrayList<>();
        this.name = name;
        shcount = 0;
    }
    
    public void add(Subheading sh){
        subheadings.add(shcount, sh);
        shcount++;
    }
    
    public void remove(int index){
        subheadings.remove(index);
        shcount--;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getCount(){
        return shcount;
    }
    
    public Subheading getSH(int index){
        return subheadings.get(index);
    }
    
    public void setSH(int index, Subheading sh){
        subheadings.set(index, sh);
    }
    
    
}
