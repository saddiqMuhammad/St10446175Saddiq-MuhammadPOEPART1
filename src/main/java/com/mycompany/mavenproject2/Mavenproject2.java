/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject2;

import java.util.Scanner;

/**
 *
 * @author TECH DEALZ
 */
// Main.java
public class Mavenproject2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Create Object of Login class 
        Login objLogin = new Login();

        //Declaration and Prompts
        System.out.print("Enter your usename: ");
        String username = sc.next();

        System.out.print("Enter your password: ");
        String password = sc.next();

        System.out.print("Enter your firstName: ");
        String firstName = sc.next();

        System.out.print("Enter your lastName: ");
        String lastName = sc.next();

        //register method
        if(objLogin.checkUserName(username)){
            System.out.println("Okay");
            
        }else{
            
            System.out.println("nop");
        }
    }
}
        
//Farrell, J. 2019. Java Programming. 9th edition. 2019. Course Technology, Cengage Learning
//ionos.com, 2024. ionos.com. [Online] Available at: https://www.ionos.com/digitalguide/websites/web-development/readme-file/#:~:text=A%20markdown%20also%20allows%20you%20to%20insert%20graphics%2C,that%20markdown%20interprets%20it%20as%20an%20image%20file. [Accessed 20 September 2024].
//Sahoo, S. R., 2019. medium.com. [Online] Available at: https://medium.com/@saumya.ranjan/how-to-write-a-readme-md-file-markdown-file-20cb7cbcd6f [Accessed 28 April 2024].
//w3schools.com, 2023. w3schools.com. [Online] Available at: https://www.w3schools.com/java/java_regex.asp [Accessed 20 September 2024].
//w3schools.com, 2023. w3schools.com. [Online] Available at: https://www.w3schools.com/java/java_encapsulation.asp [Accessed 20 May 2024].


    