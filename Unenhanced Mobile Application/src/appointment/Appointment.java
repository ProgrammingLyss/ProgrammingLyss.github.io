package appointment;

import java.util.Date; 

public class Appointment {
	
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	Date currentDate = new Date();
	
	public Appointment(String appointmentID, Date appointmentDate, String description) {
		if(appointmentID == null || appointmentID.length()>10) {
			throw new IllegalArgumentException("Invalid entry. Please enter an appointment ID in 10 characters or less.");
		} 
		if(appointmentDate == null || !currentDate.before(appointmentDate)) {
			throw new IllegalArgumentException("Invalid entry. Please enter an appointment date on or after today's date.");
		} 
		if(description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid entry. Please enter a description in 50 characters or less.");
		} 
		
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.description = description; 
	}
	
	
	public String getAppointmentID() {
		return appointmentID; 
	}
	
	public Date getAppointmentDate() {
		return appointmentDate; 
	}
	
	public String getDescription() {
		return description; 
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		if(currentDate.before(appointmentDate) && appointmentDate != null) {
			this.appointmentDate = appointmentDate;  
		}
	}
	
	public void setDescription(String description) {
		if(description.length() <= 50 && description != null) {
			this.description = description; 
		}
	} 

}
