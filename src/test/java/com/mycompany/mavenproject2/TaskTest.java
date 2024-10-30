/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TECH DEALZ
 */
public class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        // Initialize a Task instance before each test
        task = new Task("Test Task", "This is a test task.", "John Doe", 5, "In Progress");
    }

    @AfterEach
    public void tearDown() {
        // Clean up after each test if necessary
        task = null;
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription_ValidDescription() {
        assertTrue(task.checkTaskDescription(), "The task description should be valid.");
    }

    @Test
    public void testCheckTaskDescription_InvalidDescription() {
        Task invalidTask = new Task("Test Task", "This description is way too long and should fail the validation because it exceeds fifty characters.", "John Doe", 5, "In Progress");
        assertFalse(invalidTask.checkTaskDescription(), "The task description should be invalid.");
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        String expectedID = "TE:0:E";
        assertEquals(expectedID, task.createTaskID(), "The generated Task ID should match the expected format.");
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        String expectedDetails = """
                                 Task Status: In Progress
                                 Developer Details: John Doe
                                 Task Number: 0
                                 Task Name: Test Task
                                 Task Description: This is a test task.
                                 Task ID: TE:0:E
                                 Duration: 5 hours""";
        assertEquals(expectedDetails, task.printTaskDetails(), "The printed task details should match the expected output.");
    }

    /**
     * Test of getDuration method, of class Task.
     */
    @Test
    public void testGetDuration() {
        assertEquals(5, task.getDuration(), "The duration should match the initialized value.");
    }
}