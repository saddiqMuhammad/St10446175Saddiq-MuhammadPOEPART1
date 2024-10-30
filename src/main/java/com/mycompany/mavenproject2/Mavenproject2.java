/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




/**
 *
 * @author TECH DEALZ
 */
// Main application class for EasyKanban system renamed to Mavenproject2
public class Mavenproject2 {
    private static final List<Task> tasks = new ArrayList<>(); // List to store all tasks

    public static void main(String[] args) {
        Login login = new Login(); // Create a Login object for user authentication

        // Registration process loop until successful registration
        while (true) {
            String username = JOptionPane.showInputDialog("Enter Username:");
            String password = JOptionPane.showInputDialog("Enter Password:");
            String firstName = JOptionPane.showInputDialog("Enter First Name:");
            String lastName = JOptionPane.showInputDialog("Enter Last Name:");

            // Attempt to register user and show result message in dialog box
            String registrationMessage = login.registerUser(username, password, firstName, lastName);
            JOptionPane.showMessageDialog(null, registrationMessage);
            if (registrationMessage.startsWith("Username successfully captured")) break; // Exit loop on successful registration
        }

        boolean isLoggedIn = false; // Flag for tracking login status

        // Login process loop until successful login
        while (!isLoggedIn) {
            String username = JOptionPane.showInputDialog("Enter Username to Login:");
            String password = JOptionPane.showInputDialog("Enter Password:");
            isLoggedIn = login.loginUser(username, password); // Verify login credentials

            JOptionPane.showMessageDialog(null, login.returnLoginStatus(isLoggedIn)); // Show login status message

            if (isLoggedIn) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban"); // Display welcome message after successful login
            }
        }

        // Main application loop for managing tasks after successful login
        while (true) {
            // Display menu options for the user in a dialog box
            String menuOptions = "Choose an option:\n1) Add tasks\n2) Show report\n3) Quit";
            String choiceStr = JOptionPane.showInputDialog(menuOptions);
            int choice;
            try {
                choice = Integer.parseInt(choiceStr); // Parse user's choice as an integer
            } catch (NumberFormatException e) {
                continue; // Invalid input, prompt again without doing anything further in this iteration
            }
            switch (choice) {
                case 1:
                    addTasks(); // Call method to add tasks based on user's input
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon"); // Placeholder for report feature that is still in development
                    break;
                case 3:
                    System.exit(0); // Exit application when user chooses Quit option
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose again."); // Notify user about invalid option selection
                    break;
            }
        }
    }

    private static void addTasks() {
        int numberOfTasks;

        try {
            numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));
            if (numberOfTasks <= 0) throw new NumberFormatException(); 
            // Ensure valid positive number of tasks
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number. Please try again.");
            return; 
            // Exit method if input is invalid 
        }
        
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription;

            while (true) {
                taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                if (taskDescription.length() <= 50) break; 
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            }

            String developerDetails = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
            
            int duration;

            try {
                duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration in hours:"));
                if (duration < 0) throw new NumberFormatException(); 
                // Ensure valid positive duration
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration. Please enter a positive number.");
                continue; 
                // Skip current iteration on invalid input 
            }

            Object[] statuses = {"To Do", "Doing", "Done"};
            
            String status = (String) JOptionPane.showInputDialog(null,
                    "Select Task Status:", 
                    "Task Status", 
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    statuses,
                    statuses[0]);

            Task newTask = new Task(taskName, taskDescription, developerDetails, duration, status);
            
            if (!newTask.checkTaskDescription()) continue; 
            
            tasks.add(newTask); 

            JOptionPane.showMessageDialog(null, newTask.printTaskDetails()); 
        }

        int totalHours = tasks.stream().mapToInt(Task::getDuration).sum();
        
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }
}