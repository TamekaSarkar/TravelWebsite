/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tameka
 */
public class onlineAccount {
    private int Id;
    private String User_Name;
    private String Password;
    private String Tag1;
    private String Tag2;
    private String oldPsw;
    private String newPsw1;
    private String newPsw2;
    private String Name;
    private String City;
    private String State;
    private String Description;
    private String searchcity;  
    private String Tag;
    private double Score;
    private String searchtag;
   private String attractionName;
   private double rating;
   private String comments;
   private String date;
   private String favouriteAttraction;
   private String searchattraction;
   public DateAndTime dateTime;
    
    
 private ArrayList<Attraction> attraction
            = new ArrayList<Attraction>();
 private ArrayList<Favourite>favourite = new ArrayList<Favourite>();
  
   

    public onlineAccount(String User_Name, String Password) {
        this.User_Name=User_Name;
        this.Password = Password;
    }

    public String setSearchattraction(String searchattraction) {
        this.searchattraction = searchattraction;
        return ("attractionByName");
    }

    public String getFavouriteAttraction() {
        return favouriteAttraction;
    }

    public String setFavAttraction(String favouriteAttraction) {
        this.favouriteAttraction = favouriteAttraction;
        return("addAttractionFavourite");
    }
    
    
    public void setFavouriteAttraction(String favouriteAttraction) {
        this.favouriteAttraction = favouriteAttraction;
        
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
     }
    
    public String setReviewAttractionName(String attractionName) {
        this.attractionName = attractionName;
        return("postreview");
        
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
    

    public String getSearchtag() {
        return searchtag;
    }

    public void setSearchtag(String searchtag) {
        this.searchtag = searchtag;
    }
    

    public String getSearchcity() {
        return searchcity;
    }

    public void setSearchcity(String searchcity) {
        this.searchcity = searchcity;
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
    

    public String getOldPsw() {
        return oldPsw;
    }

    public void setOldPsw(String oldPsw) {
        this.oldPsw = oldPsw;
    }

    public String getNewPsw1() {
        return newPsw1;
    }

    public void setNewPsw1(String newPsw1) {
        this.newPsw1 = newPsw1;
    }

    public String getNewPsw2() {
        return newPsw2;
    }

    public void setNewPsw2(String newPsw2) {
        this.newPsw2 = newPsw2;
    }
    

    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTag1() {
        return Tag1;
    }

    public void setTag1(String Tag1) {
        this.Tag1 = Tag1;
    }

    public String getTag2() {
        return Tag2;
    }

    public void setTag2(String Tag2) {
        this.Tag2 = Tag2;
    }
   
     public String resetPassword()
    {
        boolean newPswOK = false; 
        boolean matchOldPsw = false;
        
        
        
        if(newPsw1.equals(newPsw2))
        {
            newPswOK = true;
        }
        
        if(oldPsw.equals(Password))
        {
            matchOldPsw = true;
        }
        
        if(!newPswOK)
        {
            return ("confirmationResetWrong.xhtml");
        }
        else if(!matchOldPsw)
        {   
            return ("confirmationResetWrong.xhtml");   
        }
        else
        {
            DataStorage data = new SQL_Database();
            return data.updatePassword(User_Name, newPsw1);
        }
        
    }
     public String createattraction(){
       System.out.println(User_Name);
         System.out.println(Name);
           System.out.println(City);
             System.out.println(State);
       DataStorage data = new SQL_Database();
       return  data.CreateNewAttraction(User_Name,Name,City,State,Description,Tag,Score);
         
         
     }
     public String postReview(){
      String date = dateTime.DateTime();
       DataStorage data = new SQL_Database();
       return  data.postReview(User_Name,attractionName,rating,comments,date);
         
         
     }
     public List<Favourite> goToMyFavourite(){
         
       DataStorage data = new SQL_Database();
       favourite =  data.getFavourite(User_Name);
       return favourite;
     }
     public String addFavourite(){
         DataStorage data = new SQL_Database();
       return  data.addFavourite(User_Name,favouriteAttraction);
     }
     public List<Attraction> getAttractionByname()
    {
          DataStorage data = new SQL_Database();
        attraction = data.getAttractionByname(searchattraction);
        return attraction;
    }
     
     public List<Attraction> getAttraction()
    {
          DataStorage data = new SQL_Database();
        attraction = data.getattractionbycity(searchcity);
        return attraction;
    }
     public List<Attraction> youMayLike()
    {
          DataStorage data = new SQL_Database();
         attraction = data.youMayLike(User_Name);
        return attraction;
    }
      public List<Attraction> getAttractionTag()
    {
          DataStorage data = new SQL_Database();
        attraction = data.getattractionbyTag(searchtag);
        return attraction;
    }
     public String signOut()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";

        
    }
    
}
