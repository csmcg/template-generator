/*
 * File: Subheading.java
 * Author: Malik Midani mikex535@uab.edu
 * Assignment: Template Generator - EE333 Spring 2018
 * Vers: 1.0.0 04/20/2018 MM - initial coding
 *
 * 
 */

/**
 * Class to store subheadings that will be nested underneath top-level heading
 * objects (Heading.java).
 * 
 * @author Malik Midani mikex535@uab.edu
 */
public class Subheading {
    private String name; // name of section
    
    /**
     * Constructs a subheading object.
     */
    public Subheading(){
        name = "";
    }
        
    /**
     * Constructs a subheading, passing a name to it.
     * 
     * @param name name of section to be constructed
     */
    public Subheading(String name){
        this.name = name;
    }
    
    /**
     * Returns the name of the section
     * @return name of section
     */ 
    public String getName(){
        return name;
    }
    
    /**
     * Change the name of a section
     * 
     * @param name name to change section to
     */
    public void setName(String name){
        this.name = name;
    }

}
