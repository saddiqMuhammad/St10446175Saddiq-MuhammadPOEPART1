/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private Login login;

    @BeforeAll
    public static void setUpClass() {
        // Code to run once before all tests (if needed)
    }

    @AfterAll
    public static void tearDownClass() {
        // Code to run once after all tests (if needed)
    }

    @BeforeEach
    public void setUp() {
        // Initialize a new instance of Login before each test
        login = new Login();
    }

    @AfterEach
    public void tearDown() {
        // Clean up after each test (not needed in this case)
    }

    /**
     * Test of checkUserName method.
     */
    @Test
    public void testCheckUserName_Valid() {
        assertTrue(login.checkUserName("user_"), "Username should be valid");
    }

    @Test
    public void testCheckUserName_Invalid_NoUnderscore() {
        assertFalse(login.checkUserName("user"), "Username should be invalid without underscore");
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse(login.checkUserName("username"), "Username should be invalid if longer than 5 characters");
    }

    /**
     * Test of checkPasswordComplexity method.
     */
    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(login.checkPasswordComplexity("Passw0rd!"), "Password should meet complexity requirements");
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_TooShort() {
        assertFalse(login.checkPasswordComplexity("Short1!"), "Password should be invalid if shorter than 8 characters");
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoUpperCase() {
        assertFalse(login.checkPasswordComplexity("password1!"), "Password should be invalid without uppercase letter");
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoDigit() {
        assertFalse(login.checkPasswordComplexity("Password!"), "Password should be invalid without a digit");
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password1"), "Password should be invalid without special character");
    }

    /**
     * Test of registerUser method.
     */
    @Test
    public void testRegisterUser_Valid() {
        String result = login.registerUser("user_", "Passw0rd!", "John", "Doe");
        assertEquals("Username successfully captured. You are now registered!", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String result = login.registerUser("user", "Passw0rd!", "John", "Doe");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        String result = login.registerUser("user_", "short", "John", "Doe");
        assertEquals("Password does not meet the complexity requirements.", result);
    }

    /**
     * Test of loginUser method.
     */
    @Test
    public void testLoginUser_ValidCredentials() {
        login.registerUser("user_", "Passw0rd!", "John", "Doe");
        assertTrue(login.loginUser("user_", "Passw0rd!"), "Login should succeed with valid credentials");
    }

    @Test
    public void testLoginUser_InvalidUsername() {
        login.registerUser("user_", "Passw0rd!", "John", "Doe");
        assertFalse(login.loginUser("wrong_user", "Passw0rd!"), "Login should fail with incorrect username");
    }

    @Test
    public void testLoginUser_InvalidPassword() {
        login.registerUser("user_", "Passw0rd!", "John", "Doe");
        assertFalse(login.loginUser("user_", "wrong_password"), "Login should fail with incorrect password");
    }

    /**
     * Test of returnLoginStatus method.
     */
    @Test
    public void testReturnLoginStatus_LoggedIn() {
        login.registerUser("user_", "Passw0rd!", "John", "Doe");
        boolean isLoggedIn = login.loginUser("user_", "Passw0rd!");
        String message = login.returnLoginStatus(isLoggedIn);
        assertEquals("Welcome John Doe, it is great to see you again!", message);
    }

    @Test
    public void testReturnLoginStatus_NotLoggedIn() {
        boolean isLoggedIn = false;
        String message = login.returnLoginStatus(isLoggedIn);
        assertEquals("Username or password incorrect, please try again.", message);
    }
}