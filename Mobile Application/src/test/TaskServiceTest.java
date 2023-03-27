/************************************************************************************
 *                             Mobile Application
 * 
 * Description: A mobile application for organizing client-related contacts, tasks, 
 * and appointments.
 * Alyssa Fasciano
 * Southern New Hampshire University
 * CS-499: Computer Science Capstone
 * March/April 2023
 ************************************************************************************/
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

// JUnit testing for TaskService class

public class TaskServiceTest {
	
	private static TaskService taskService;
	
	@BeforeAll
	static void setup() {
		taskService = TaskService.getService();
	}
	
	@Test
	void testAddTaskSuccess() {
		Task task = new Task("TskID", "John", "Description Test");
		assertTrue(taskService.addTask(task));
		
		Task cachedTask = taskService.getTask(task.getTaskID());
		
		assertTrue(cachedTask != null);
		assertTrue(cachedTask.getTaskID().equals("TskID"));
		assertTrue(cachedTask.getName().equals("John"));
		assertTrue(cachedTask.getDescription().equals("Description Test"));
	}
	
	@Test
	void testAddMultipleTasksSuccess() {
		Task task1 = new Task("TskID1", "John", "Task1 description");
		Task task2 = new Task("TskID2", "Jane", "Task2 description");
		
		assertTrue(taskService.addTask(task1));
		task1 = taskService.getTask(task1.getTaskID()); 
		
		assertTrue(task1 != null);
		assertTrue(task1.getTaskID().equals("TskID1"));
		assertTrue(task1.getName().equals("John"));
		assertTrue(task1.getDescription().equals("Task1 description"));
		
		assertTrue(taskService.addTask(task2));
		task2 = taskService.getTask(task2.getTaskID());
		
		assertTrue(task2 != null);
		assertTrue(task2.getTaskID().equals("TskID2"));
		assertTrue(task2.getName().equals("Jane"));
		assertTrue(task2.getDescription().equals("Task2 description"));
	}
	
	@Test
	void testAddTaskDuplicateIDFail() {
		Task task1 = new Task("TaskID", "John", "Task description");
		Task task2 = new Task("TaskID", "John", "Task description");
		
		assertTrue(taskService.addTask(task1));
		assertFalse(taskService.addTask(task2)); 
	}
	
	@Test
	void testGetTaskAndUpdateSuccess() {
		Task task1 = new Task("Task1", "John", "Task1 description");
		
		assertTrue(taskService.addTask(task1));
		Task updateTask = taskService.getTask(task1.getTaskID());
		
		updateTask.setName("Johnathan");
		updateTask = taskService.getTask(updateTask.getTaskID());
		assertTrue(updateTask.getName().equals("Johnathan"));
	}
	
	@Test
	void testGetTaskAndDeleteSuccess() {
		Task task1 = new Task("Task2", "Jane", "Task2 description");
		
		assertTrue(taskService.addTask(task1));
		
		Task task2 = taskService.getTask(task1.getTaskID());
		assertTrue(taskService.deleteTask(task2.getTaskID()));
		
		assertTrue(taskService.getTask(task2.getTaskID()) == null); 
	}
	
	@Test
	void testDeleteInvalidTaskFail() {
		String invalidTaskID = "1";
		
		assertFalse(taskService.deleteTask(invalidTaskID));
	}

}
