/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

/**
 *
 * @author Tameka
 */
public class Favourite {
    private String User_Name;
    private String Name;

    Favourite(String string,String string0) {
      User_Name = string;
      Name = string0;
      
    }

   
    

    public String getUser_Name() {
        return User_Name;
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
    
    
}
