/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tameka
 */
@ManagedBean
@SessionScoped
public class Login  implements Serializable{
    private String User_Name;
    private String Password;
    private onlineAccount theLoginAccount;
    private admin adm;
    //get set methods

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public admin getAdm() {
        return adm;
    }

    public void setAdm(admin adm) {
        this.adm = adm;
    }
    

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public onlineAccount getTheLoginAccount() {
        return theLoginAccount;
    }

    public void setTheLoginAccount(onlineAccount theLoginAccount) {
        this.theLoginAccount = theLoginAccount;
    }
    public String Login(){
        //load the Driver
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("internalError");
        }
        DataStorage data = new SQL_Database();
        String fileName = data.Login(User_Name, Password);
        
        if(User_Name.equals("admin") && Password.equals("admin")){
            adm = new admin();
        return "admin";
        
        
    }
        
          if(fileName.equals("welcome"))
        {
            theLoginAccount = new onlineAccount(User_Name, Password);
           
            return "welcome";
        }
        else
        {
            return fileName;
        }
          
    }
    
}
