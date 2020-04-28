package com.example.user.mysql;

/**
 * Created by user on 3/23/2017.
 */
public class Updater {

   public static String  userName,userPhoneNumber,userEmail;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
      this.userName=userName;

    }
    public String getUserPhoneNumber(){
        return userPhoneNumber;
    }
    public void setUserPhoneNumber(String userPhoneNumber){
        this.userPhoneNumber=userPhoneNumber;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public void setUserEmail(String userEmail){
        this.userEmail=userEmail;
    }

}
