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

public class Task {
	
	// variables
	private String taskID;
	private String name;
	private String description;
	
	public Task(String taskID, String name, String description) { 
		if(taskID == null || taskID.length()>10) {
			throw new IllegalArgumentException("Invalid entry. Please enter an ID in 10 characters or less.");
		} // Task ID must be less than or equal to 10 characters and not equal null
		if(name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid entry. Please enter a name in 20 characters or less.");
		} // Name must be less than or equal to 20 characters and not equal null
		if(description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid entry. Please enter a description in 50 characters or less.");
		} // Description must be less than or equal to 50 characters and not equal null
		
		this.taskID = taskID;
		this.name = name;
		this.description = description; 
	}
	
	// getter methods
	
	public String getTaskID() {
		return taskID;
	}
	
	public String getName() {
		return name; 
	}
	
	public String getDescription() {
		return description; 
	}
	
	// setter methods
	
	public void setName(String name) {
		if(name.length() <= 20 && name != null) {
			this.name = name;
		}
	}
	
	public void setDescription(String description) {
		if(description.length() <= 50 && description != null) {
			this.description = description; 
		}
	}

}
