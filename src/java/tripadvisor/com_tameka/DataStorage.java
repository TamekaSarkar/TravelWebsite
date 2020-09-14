/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tameka
 */
public interface DataStorage {

    String CreateRegister(String User_Name, String Name, String Password, String Tag1, String Tag2) ;
      
 

     String Login(String User_Name, String Password) ;
   
    
   
    // void YouMayLike(Attraction a);

     String updatePassword(String User_Name, String newPsw1);

     String CreateNewAttraction(String User_Name, String Name, String City, String State, String Description, String Tag, double Score);
     
     ArrayList<Attraction>getattractionbycity(String City);

     ArrayList<Attraction> getattractionbyTag(String searchtag);

   String postReview(String User_Name, String attractionName, double rating, String comments, String date);

    String addFavourite(String User_Name, String favouriteAttraction);

     ArrayList<Favourite> getFavourite(String User_Name);

     ArrayList<Attraction> youMayLike(String User_Name);
     ArrayList<Attraction> ApproveAttraction();

     String approved(String selectedattraction);

     String rejected(String selectedattraction);

     ArrayList<Attraction> getAttractionByname(String searchattraction);
        
    
    
}
