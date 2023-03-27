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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import appointment.Appointment;
import appointment.AppointmentService;

// JUnit testing for AppointmentService class

class AppointmentServiceTest {

	private static AppointmentService appointmentService; 
	
	@BeforeAll
	static void setup() {
		appointmentService = AppointmentService.getService();
	}
	
	@Test
	void testAddAppointmentSuccess() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("12/31/2023");
		
		Appointment appointment = new Appointment("ApptID", date, "Appointment description");
		assertTrue(appointmentService.addAppointment(appointment));
		
		Appointment getAppointment = appointmentService.getAppointment("ApptID");
		assertTrue(getAppointment.getAppointmentID().equals(appointment.getAppointmentID()));
		assertTrue(getAppointment.getAppointmentDate().equals(appointment.getAppointmentDate()));
		assertTrue(getAppointment.getDescription().equals(appointment.getDescription()));
	}
	
	@Test
	void testAddMultipleAppointmentsSuccess() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Date date = formatter.parse("01/01/2024");
		Date date1 = formatter.parse("01/02/2024");
		
		Appointment appointment1 = new Appointment("ApptID1", date, "Appointment1 description");
		Appointment appointment2 = new Appointment("ApptID2", date1, "Appointment2 description");
		
		assertTrue(appointmentService.addAppointment(appointment1));
		assertTrue(appointmentService.addAppointment(appointment2));
	}
	
	@Test
	void testAddAppointmentDuplicateIDFail() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Date date = formatter.parse("01/03/2024");
		Date date1 = formatter.parse("01/03/2024");
		
		Appointment appointment1 = new Appointment("ApptID3", date, "Appointment description");
		Appointment appointment2 = new Appointment("ApptID3", date1, "Appointment description");
		
		assertTrue(appointmentService.addAppointment(appointment1));
		assertFalse(appointmentService.addAppointment(appointment2));
	}
	
	@Test
	void testGetAppointmentAndUpdateSuccess() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("01/04/2024");
		
		Appointment appointment1 = new Appointment("ApptID4", date, "Appointment description");
		assertTrue(appointmentService.addAppointment(appointment1));
		
		Appointment updateAppointment = appointmentService.getAppointment(appointment1.getAppointmentID());
		updateAppointment.setAppointmentDate(formatter.parse("01/05/2024"));
		updateAppointment = appointmentService.getAppointment(updateAppointment.getAppointmentID());
		assertTrue(updateAppointment.getAppointmentDate().equals(formatter.parse("01/05/2024")));
	}
	
	@Test
	void testGetAppointmentAndDeleteSuccess() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse("01/10/2024");
		
		Appointment appointment1 = new Appointment("ApptID5", date, "Appointment description");
		assertTrue(appointmentService.addAppointment(appointment1));
		
		Appointment appointment2 = appointmentService.getAppointment(appointment1.getAppointmentID());
		assertTrue(appointmentService.deleteAppointment(appointment2.getAppointmentID()));
		
		assertTrue(appointmentService.getAppointment(appointment2.getAppointmentID()) == null);
	}
	
	@Test
	void testDeleteInvalidAppointmentFail() {
		String invalidAppointmentID = "1";
		
		assertFalse(appointmentService.deleteAppointment(invalidAppointmentID));
	}

}
