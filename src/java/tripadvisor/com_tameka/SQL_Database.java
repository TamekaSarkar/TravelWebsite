/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripadvisor.com_tameka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Tameka
 */
public class SQL_Database implements DataStorage{
     
    final String DATABASE_URL = 
                "jdbc:mysql://mis-sql.uhcl.edu/sarkart4522?useSSL=false";
    final String db_id = "sarkart4522";
    final String db_psw = "1853069";
        
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public String  CreateRegister(String User_Name, String Name, String Password, String Tag1, String Tag2) {
        //Complete the database part below
       
        final String DATABASE_URL = 
                "jdbc:mysql://mis-sql.uhcl.edu/sarkart4522?useSSL=false";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int Id = 0;
        
        try{
             //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
             //do a query
            resultSet = statement.executeQuery("Select max(Id) from User_TripAdvisor");
        
            
                while(resultSet.next())
                    {
                        Id = resultSet.getInt("max(Id)");
                        System.out.print(Id + " ");
                        Id++;
                        
                    }
                
            }
                    
             
            
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
        //create registration entry
        try
        {
            
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
             //do a query
            resultSet = statement.executeQuery("Select * from User_TripAdvisor where User_Name = '" + User_Name + "'");
              if(resultSet.next())
            {
                //either the ssn is used or the id is used
                System.out.println("user already exits");
                System.out.println();
            }
            else
            {
                //insert a record into onlineAccount
            int r = statement.executeUpdate("insert into User_TripAdvisor values"
                        + "('"+Id+ "', '" +User_Name + "', '" + Name + "', '" + Password + "', '"
                        + Tag1 + "', '" + Tag2 +"')");
               
                
            }
            connection.commit();
            connection.setAutoCommit(true);
           
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return("Something wrong during the Registration process!");
            
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
              return("Registration successful!");
        }
        
       
        
    }

    @Override
    public String Login(String User_Name, String Password) {
        try
        {
            
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from User_TripAdvisor "+ "where User_Name = '" + User_Name + "'");
            
            if(resultSet.next())
            {
                
                //the id is found, check the password
                if(Password.equals(resultSet.getString("Password")))
                {
                    //password is good
                    return"welcome";
                    //go to the welcome page 
                }
                else
                {
                    //password is not correct
                    return"loginNotOK";
                     
                }
            }
            else
            {
                return"loginNotOK";
            }
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return"internalError";
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
    }
    @Override
    public String CreateNewAttraction(String User_Name, String Name, String City, String State, String Description, String Tag, double Score) {
     
        //Complete the database part below
        final String DATABASE_URL = 
                "jdbc:mysql://mis-sql.uhcl.edu/sarkart4522?useSSL=false";
        
        Connection connection = null;
        Statement statement = null;
           try
        {
            
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
           //insert a record into onlineAccount
            int r = statement.executeUpdate("insert into Attraction_TripAdvisor values"
                        + "('" +User_Name+ "', '" +Name+ "', '" +City+ "', '"
                        +State+ "', '" +Description+ "', '" +Tag+ "', '" +Score
                    + "', '" +"pending" + "')");
                
            
            connection.commit();
            connection.setAutoCommit(true);
            
        }
        catch (SQLException e)
        {
            return("Something wrong ");
            
        }
        finally
        {
             //close the database
             try
             {
                
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
             return("Create Attraction Success");
        }
        
    }

   


    @Override
    public String updatePassword(String User_Name, String newPsw1) {
       try 
        {
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");

            //create a statement
            statement = connection.createStatement();

            int r = statement.executeUpdate("Update User_TripAdvisor set "
                    + "Password = '" +  newPsw1 + "' where User_Name= '" +User_Name  + "'");
            return("confirmationResetOK");

        }
        catch (SQLException e)
        {

            e.printStackTrace();
            return("internalError");
         }
         finally
         {
            try
            {
                statement.close();
                connection.close();

            }
            catch (Exception e)
            {                 
                e.printStackTrace();
            }
         }
             
    }

   

    @Override
    public ArrayList<Attraction> getattractionbycity(String City) {
        try
        {
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from attraction_tripadvisor "
                    + "where City = '" + City +  "' order by Score Desc");
            
            ArrayList<Attraction> aList = new ArrayList<Attraction>();
            
            while(resultSet.next())
            {
                 Attraction anAttraction = new Attraction(resultSet.getString(1), 
                 resultSet.getString(2), resultSet.getString(3), 
                 resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getString(8));
                 aList.add(anAttraction);
            }
            return aList;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
    }
     @Override
    public   ArrayList<Attraction> getAttractionByname(String searchattraction) {
        try
        {
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from attraction_tripadvisor "
                    + "where Name = '" +searchattraction+ "'");
            
            ArrayList<Attraction> aList = new ArrayList<Attraction>();
            
            while(resultSet.next())
            {
                 Attraction anAttraction = new Attraction(resultSet.getString(1), 
                 resultSet.getString(2), resultSet.getString(3), 
                 resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getString(8));
                 aList.add(anAttraction);
            }
            return aList;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
    }


    @Override
    public ArrayList<Attraction> getattractionbyTag(String searchtag) {
         try
        {
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from attraction_tripadvisor "
                    + "where Tag = '" + searchtag + "' order by Score Desc");
            
            ArrayList<Attraction> aList = new ArrayList<Attraction>();
            
            while(resultSet.next())
            {
                 Attraction anAttraction = new Attraction(resultSet.getString(1), 
                 resultSet.getString(2), resultSet.getString(3), 
                 resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getString(8));
                 aList.add(anAttraction);
            }
            return aList;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
       
    }

    @Override
    public String postReview(String User_Name, String attractionName, double rating, String comments, String date) {
         int Review_Id = 0;
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/sarkart4522?useSSL=false";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
         try{
             //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
             //do a query
            resultSet = statement.executeQuery("Select max(Review_Id) from Review_TripAdvisor");
        
            
                while(resultSet.next())
                    {
                        Review_Id = resultSet.getInt("max(Review_Id)");
                        System.out.print(Review_Id + " ");
                        Review_Id++;
                        
                    }
                
            }
                    
             
            
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
       
        try{
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            resultSet = null;
            //crate the statement
            statement = connection.createStatement();
                    
            //insert a record 
            int r = statement.executeUpdate("insert into Review_TripAdvisor values"
                        + "('" + Review_Id+ "', '" + User_Name+ "', '" + attractionName+ "', '" + rating + "', '"
                        + comments + "', '" + date+"')");
            
            Double a = null;
            resultSet = statement.executeQuery("Select Name,avg(Score)from Review_TripAdvisor group by Name having name ='"+attractionName+"'");
            while(resultSet.next())
                    {
                        a = resultSet.getDouble("avg(Score)");
                    }
            int k = statement.executeUpdate("Update Attraction_TripAdvisor set Score = " + a + " where Name = '"+ attractionName+"'" );    
            
           
            connection.commit();
            connection.setAutoCommit(true);    
        }
        catch (SQLException e)
        {
           
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                
                 statement.close();
                 connection.close();
                 resultSet.close();
                 
      
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
             
            
            return("Reviewcreated.xhtml");
        }
      
       
    }

    @Override
    public String addFavourite(String User_Name, String favouriteAttraction) {
        final String DATABASE_URL = 
                "jdbc:mysql://mis-sql.uhcl.edu/sarkart4522?useSSL=false";
        
        Connection connection = null;
        Statement statement = null;
       try
        {
            
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //crate the statement
            statement = connection.createStatement();
             //insert a record into onlineAccount
            int r = statement.executeUpdate("insert into Favourite_TripAdvisor values"
                        + "('"  + User_Name+ "', '" + favouriteAttraction +"')");
              
            connection.commit();
            connection.setAutoCommit(true);
            
        }
        catch (SQLException e)
        {
            System.out.println("Something wrong ");
            e.printStackTrace();
        }
        finally
        {
             //close the database
             try
             {
                
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
                 return "Added to my favourite destination!";
             }
        }

    @Override
    public ArrayList<Favourite> getFavourite(String User_Name) {
        try
        {
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from favourite_tripadvisor "
                    + "where User_Name = '" + User_Name + "'");
            
            ArrayList<Favourite> afavList = new ArrayList<Favourite>();
            
            while(resultSet.next())
            {
                 Favourite afav = new Favourite(resultSet.getString(1),resultSet.getString(2));
                 
                 afavList.add(afav);
            }
            return afavList;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
    }
    @Override
     public ArrayList<Attraction> youMayLike(String User_Name){
       final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/sarkart4522?useSSL=false";
      
      Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
 
   
      try
        {   //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from User_TripAdvisor "+ "where user_Name = '" + User_Name + "'");
            String tag1 = null;
            String tag2 = null;
            String tag_1=null;
            String tag_2 =null;
            
            while(resultSet.next()){
                tag_1 = resultSet.getString("Tag1");
                tag_2 = resultSet.getString("Tag2");
            }
            resultSet.close();
            
            switch(tag_1){
            case "History Buff": 
              tag1 = "Museum";
              break;
            case "Beach Goer": 
              tag1 = "Beach";   
              break;
            case "Museum": 
              tag1 = "Museum";
              break;
             case "Family Vacationer": 
              tag1 = "Mountain";
              break;
            case "Nature Lover": 
              tag1 = "Mountain";
              break;
            case "Urban Explorer": 
              tag1 = "Cities";
              break;
             case "Shopping Fanatic":
              tag1 = "Shopping Malls";
              break;
            }
            
            switch(tag_2){
            case "History Buff": 
              tag2 = "Museum";
              break;
            case "Beach Goer": 
              tag2 = "Beach";   
              break;
            case "Museum": 
              tag2 = "Museum";
              break;
             case "Family Vacationer": 
              tag2 = "Mountain";
              break;
            case "Nature Lover": 
              tag2 = "Mountain";
              break;
            case "Urban Explorer": 
              tag2 = "Cities";
              break;
             case "Shopping Fanatic":
              tag2 = "Shopping Malls";
              break;
            }
            
            
            resultSet = null;
            resultSet = statement.executeQuery("Select * from Attraction_TripAdvisor where Tag = '" + tag1 +"' or Tag ='"+tag2 +"' order by Score desc limit 3");
            //resultSet = statement.executeQuery("Select * from User "+ "where Id = '" + a.getUser_Id() + "'");
            ArrayList<Attraction> aList = new ArrayList<Attraction>();
            
            while(resultSet.next())
            {
                 Attraction anAttraction = new Attraction(resultSet.getString(1), 
                 resultSet.getString(2), resultSet.getString(3), 
                 resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getString(6));
                 aList.add(anAttraction);
            }
            return aList;
            
         }
        catch (SQLException e)
        {  ArrayList<Attraction> bList = new ArrayList<Attraction>();
            Attraction anAttraction = new Attraction("Error", 
                 "Error", "Error", 
                 "Error", "Error","Error",5.0,"approved");
                 bList.add(anAttraction);
        
            e.printStackTrace();
            return bList ;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
}
    @Override
    public ArrayList<Attraction> ApproveAttraction() {
         try
        {
            //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            resultSet = statement.executeQuery("Select * from attraction_tripadvisor where Status = 'pending'");
            
            ArrayList<Attraction> aList = new ArrayList<Attraction>();
            
            while(resultSet.next())
            {
                 Attraction anAttraction = new Attraction(resultSet.getString(1), 
                 resultSet.getString(2), resultSet.getString(3), 
                 resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getString(8));
                 aList.add(anAttraction);
            }
            return aList;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
       
    }

    @Override
    public String approved(String selectedattraction) {
        try
        {   //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //create the statement
            statement = connection.createStatement();
           
                              int r = statement.executeUpdate("Update Attraction_TripAdvisor set Status = 'approved' where Name = '"+selectedattraction+"'"); 
                                connection.commit();
                                 connection.setAutoCommit(true);
                           
                        }    
                        
          
        catch (SQLException e){
            e.printStackTrace();
        }
        finally
        {   //close the database
            try{
                connection.close();
                statement.close();
                
                resultSet.close(); 
               // resultSet2.close();
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            return "approved";
        }
    }

    @Override
    public String rejected(String selectedattraction) {
        try
        {   //connect to the databse
            connection = DriverManager.getConnection(DATABASE_URL,"sarkart4522", "1853069");
            connection.setAutoCommit(false);
            //create the statement
            statement = connection.createStatement();
           
                              int r = statement.executeUpdate("Update Attraction_TripAdvisor set Status = 'rejected' where Name = '"+selectedattraction+"'"); 
                                connection.commit();
                               connection.setAutoCommit(true);
                           
                        }    
                        
          
        catch (SQLException e){
            e.printStackTrace();
        }
        finally
        {   //close the database
            try{
                connection.close();
                statement.close();
                
                resultSet.close(); 
               // resultSet2.close();
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            return "approved";
        }
    }

}
       
        
     
   
     
   
        
    
    

        
    

    
    
        
    

    
    


