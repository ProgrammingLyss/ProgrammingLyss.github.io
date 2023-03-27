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
package task;

import java.util.HashMap; // import HashMap class
import java.util.Map;

public class TaskService {
	
	private static TaskService reference = new TaskService(); 
	private final Map<String, Task> tasks; 
	
	TaskService() {
		this.tasks = new HashMap<String, Task>();
	} // TaskService uses the HashMap data structure to store tasks with String keys and Task values
	
	public static TaskService getService() {
		return reference; 
	}
	
	public boolean addTask(Task task) { // add a task
		boolean isSuccess = false;
		
		if(!tasks.containsKey(task.getTaskID())) {
			tasks.put(task.getTaskID(), task);
			isSuccess = true;
		}
		return isSuccess; 
	}
	
	public boolean deleteTask(String taskID) { // delete a task
		return tasks.remove(taskID) != null;
	}
	
	public Task getTask(String taskID) { // retrieve a task
		return tasks.get(taskID); 
	}

}
