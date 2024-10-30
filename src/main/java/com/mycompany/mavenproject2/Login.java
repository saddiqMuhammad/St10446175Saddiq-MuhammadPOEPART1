/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author TECH DEALZ
 */
// Class to handle user login and registration
class Login {
    private String username; // Stores the username
    private String password; // Stores the password
    private String firstName; // Stores the user's first name
    private String lastName; // Stores the user's last name

    // Method to check if the username is valid
    public boolean checkUserName(String username) {
        // Username must contain an underscore and be no more than 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity requirements
    public boolean checkPasswordComplexity(String password) {
        // Password must be at least 8 characters long, contain a capital letter, a number, and a special character
        return password.length() >= 8 &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> "!@#$%^&*()_+[]{}|;':,.<>?/`~".indexOf(ch) >= 0);
    }

    // Method to register a new user
    public String registerUser(String username, String password, String firstName, String lastName) {
        // Validate username format
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        // Validate password complexity
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        // Store user details upon successful registration
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "Username successfully captured. You are now registered!";
    }

    // Method to verify login credentials
    public boolean loginUser(String username, String password) {
        // Check if provided credentials match stored credentials
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return a message based on login status
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}