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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import appointment.Appointment;

// JUnit testing for Appointment class

class AppointmentTest {

	@Test
	void testAppointment() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2023");
		
		Appointment appointment = new Appointment ("ApptID", date, "Appointment description");
		assertTrue(appointment.getAppointmentID().equals("ApptID")); 
		assertTrue(appointment.getAppointmentDate().equals(formatter.parse("12/31/2023")));
		assertTrue(appointment.getDescription().equals("Appointment description"));
	}
	
	@Test
	void testAppointmentIDTooLong() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2022");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("AppointmentID", date, "Appointment description");
		});
	} 
	
	@Test
	void testAppointmentIDIsNull() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2022");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, "Appointment description");
		});
	}
	
	@Test
	void testAppointmentDateInPast() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2000");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("AppointmentID", date, "Appointment description");
		});
		
	}
	
	@Test
	void testAppointmentDateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("ApptID", null, "Appointment description");
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2023");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("ApptID", date, "Appointment description "
					+ "appointment description appointment description");
		});
		
	}
	
	@Test
	void testAppointmentDescriptionIsNull() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2023");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("AppointmentID", date, null);
		});
		
	}

}
