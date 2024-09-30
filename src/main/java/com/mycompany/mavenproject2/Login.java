/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;
//St10446175 saddiq Muhammad poe part 1
/**
 *
 * @author TECH DEALZ
 */
class Login {

    //method to check username
     public boolean checkUserName(String username) {
         
         if(username.contains("_") && username.length() <= 5){
             return true;
             
         }else{
             
             return false;
             
         }
         
        
    }
     
     //method to check password
     public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".[A-Z].") &&
               password.matches(".[0-9].") &&
               password.matches(".[!@#$%^&()].*");
    }
     
     //register method
     public String register(String username, String password, String firstName, String lastName){
         
         //if check password and username methods
         if(checkUserName(username) && checkPasswordComplexity(password)){
             
             return "";
         }else{
             return "";
         }
     }
     
     //login method
    public boolean loginUser(String login_username,String username, String login_password, String password) {
        
        return login_username.equals(username) && login_password.equals(password);
    }
    
    //login status
    public String returnLoginStatus(String login_username,String username, String login_password, String password, String firstName, String lastName) {
        if (loginUser(login_username,username,login_password, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    
    }
    
}
