/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author TECH DEALZ
 */
// Class to manage individual tasks
final class Task {
    private static int taskCounter = 0; // Static counter to auto-generate task numbers
    private final String taskName; // Name of the task
    private final String taskDescription; // Description of the task
    private final String developerDetails; // Developer assigned to the task
    private final int duration; // Duration of the task in hours
    private final String taskID; // Unique ID for the task
    private final String status; // Current status of the task

    // Constructor to create a new task with provided details
    public Task(String taskName, String taskDescription, String developerDetails, int duration, String status) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.duration = duration;
        this.status = status;
        this.taskID = createTaskID(); // Generate Task ID upon creation of a new task
        taskCounter++; // Increment the static counter for each new task created
    }

    // Method to check if the task description is valid (not exceeding 50 characters)
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create and return a unique Task ID based on specified format
    public String createTaskID() {
        return (taskName.substring(0, 2).toUpperCase() + ":" + (taskCounter - 1) + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase());
    }

    // Method to print full details of the task in a formatted string
    public String printTaskDetails() {
        return "Task Status: " + status +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + (taskCounter - 1) +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nDuration: " + duration + " hours";
    }

    // Getter method for duration of the task
    public int getDuration() {
        return duration;
    }
}