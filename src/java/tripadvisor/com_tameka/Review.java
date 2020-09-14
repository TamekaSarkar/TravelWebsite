
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
public class Review {
    private int Review_Id; 
    private String User_Name;
    private String Name;
    private  double Score;
    private String Comments;
    private String Date_Time;

    public int getReview_Id() {
        return Review_Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public String getName() {
        return Name;
    }

    public double getScore() {
        return Score;
    }

    public String getComments() {
        return Comments;
    }

    public String getDate_Time() {
        return Date_Time;
    }

   

   
    
    public Review(String Name,String User_Name){
        
        this.User_Name = User_Name;
        this.Name = Name;
    }
    
   
    
}
