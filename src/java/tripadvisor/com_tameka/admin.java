/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tameka
 */
public class admin {
    private String User_Name; 
    private String Name;
    private String City;
    private String State;
    private String Description;
    private String Tag ;
    private double Score;
    private String Status;
    private String selectedattraction;
private ArrayList<Attraction> attraction
            = new ArrayList<Attraction>();
    public String getUser_Name() {
        return User_Name;
    }

    public String getSelectedattraction() {
        return selectedattraction;
    }

    public void setSelectedattraction(String selectedattraction) {
        this.selectedattraction = selectedattraction;
    }
    

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
   public List<Attraction> ApproveAttraction()
    {
          DataStorage data = new SQL_Database();
        attraction = data.ApproveAttraction();
        return attraction;
    }
   public String approved(String name){
          DataStorage data = new SQL_Database();
         String s =  data.approved(name);
         return "admin";
       
       
   }
   public String rejected(String name){
          DataStorage data = new SQL_Database();
         String r =  data.rejected(name);
         return "admin";
       
       
   }
    
    
}
