/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

import java.util.Scanner;

/**
 *
 * @author Tameka
 */
public class Attraction {
    private String User_Name; 
    private String Name;
    private String City;
    private String State;
    private String Description;
    private String Tag ;
    private double Score;
    private String Status;

    

    Attraction(String string, String string0, String string1, String string2, String string3, String string4, double aDouble,String string5) {
       User_Name = string;
       Name = string0;
       City = string1;
       State = string2;
       Description = string3;
       Tag = string4;
       Score = aDouble;
       Status = string5;
      
    }

   

    public String getUser_Name() {
        return User_Name;
    }

    public String getName() {
        return Name;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getDescription() {
        return Description;
    }

    public String getTag() {
        return Tag;
    }

    public double getScore() {
        return Score;
    }

    public String getStatus() {
        return Status;
    }

   

    public Attraction(String User_Name){
        this.User_Name = User_Name;
        
    }
    
}
