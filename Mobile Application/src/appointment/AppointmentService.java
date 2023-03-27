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
package appointment;

import java.util.HashMap; // import HashMap class
import java.util.Map;

public class AppointmentService {
	
	private static AppointmentService reference = new AppointmentService();
	private final Map<String, Appointment> appointments; 
	
	AppointmentService() {
		this.appointments = new HashMap<String, Appointment>();
	} // AppointmentService uses the HashMap data structure to store appointments with String keys and Appointment values
	
	public static AppointmentService getService() {
		return reference; 
	}
	
	public boolean addAppointment(Appointment appointment) { // add an appointment
		boolean isSuccess = false;
		
		if(!appointments.containsKey(appointment.getAppointmentID())) {
			appointments.put(appointment.getAppointmentID(), appointment);
			isSuccess = true;
		}
		return isSuccess;
	}
	
	public boolean deleteAppointment(String appointmentID) { // delete an appointment
		return appointments.remove(appointmentID) != null;
	}
	
	public Appointment getAppointment(String appointmentID) { // retrieve an appointment
		return appointments.get(appointmentID);
	}

}
