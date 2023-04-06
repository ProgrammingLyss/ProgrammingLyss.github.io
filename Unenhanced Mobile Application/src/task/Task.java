package task;

public class Task {
	
	private String taskID;
	private String name;
	private String description;
	
	public Task(String taskID, String name, String description) { 
		if(taskID == null || taskID.length()>10) {
			throw new IllegalArgumentException("Invalid entry. Please enter an ID in 10 characters or less.");
		} 
		if(name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid entry. Please enter a name in 20 characters or less.");
		} 
		if(description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid entry. Please enter a description in 50 characters or less.");
		} 
		
		this.taskID = taskID;
		this.name = name;
		this.description = description; 
	}
	
	
	public String getTaskID() {
		return taskID;
	}
	
	public String getName() {
		return name; 
	}
	
	public String getDescription() {
		return description; 
	}
	
	
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
