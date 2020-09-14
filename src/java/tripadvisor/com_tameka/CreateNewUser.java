/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

import java.io.Serializable;
import java.util.Map;


import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tripadvisor.com_tameka.DataStorage;
import tripadvisor.com_tameka.SQL_Database;

/**
 *
 * @author Tameka
 */
@ManagedBean(name = "createNewUser")
@RequestScoped
public class CreateNewUser implements Serializable{

  
   private String name;
   private String password;
   private String tag1;
   private String tag2;
   private String user_Name;
   
   
   
    

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }
    

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }
   
   public String user(){
        
       FacesContext fc = FacesContext.getCurrentInstance();
       Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String action = params.get("action");
        System.out.println(action);
         if(this.user_Name.equals(this.password)){
             return ("username and password cannot be same");
         }
         else{
       try{
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e){
           return("internal error");
       }
       DataStorage data = new SQL_Database();
       return  data.CreateRegister(user_Name, name, password, tag1, tag2);
   }
   }
   
  

   
   
    
}
