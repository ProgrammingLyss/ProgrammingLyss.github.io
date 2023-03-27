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

import contact.Contact;
import contact.ContactService;

// JUnit testing for ContactService class

class ContactServiceTest {
	
	private static ContactService contactService; 
	
	@BeforeAll
	static void setup() {
		contactService = ContactService.getService(); 
	}
	
	@Test
	void testAddContactSuccess() {
		Contact contact = new Contact("ConID", "Jane", "Doe", "1234567890", "123 ABC Street");
		assertTrue(contactService.addContact(contact));
		
		Contact getContact = contactService.getContact("ConID"); 
		
		assertTrue(getContact.getContactID().contentEquals(contact.getContactID()));
		assertTrue(getContact.getFirstName().contentEquals(contact.getFirstName()));
		assertTrue(getContact.getLastName().contentEquals(contact.getLastName()));
		assertTrue(getContact.getPhoneNumber().contentEquals(contact.getPhoneNumber()));
		assertTrue(getContact.getAddress().contentEquals(contact.getAddress()));
	}
	
	@Test
	void testAddMultipleContactsSuccess() {
		Contact contact1 = new Contact("ContactID", "Jane", "Doe", "1234567890", "123 ABC Street");
		Contact contact2 = new Contact("ContactID1", "John", "Smith", "9876543210", "321 ABC Street");
		
		assertTrue(contactService.addContact(contact1));
		assertTrue(contactService.addContact(contact2));
	}
	
	@Test
	void testAddContactDuplicateIDFail() {
		Contact contact1 = new Contact("ConID1", "John", "Smith", "1234567890", "123 ABC Street");
		Contact contact2 = new Contact("ConID1", "John", "Smith", "1234567890", "123 ABC Street");
		
		assertTrue(contactService.addContact(contact1)); 
		assertFalse(contactService.addContact(contact2)); 
	}
	
	@Test
	void testGetContactAndUpdateSuccess() {
		Contact contact1 = new Contact("12345", "Jane", "Doe", "1234567890", "123 ABC Street");
		
		assertTrue(contactService.addContact(contact1));
		Contact updateContact = contactService.getContact(contact1.getContactID());
		
		updateContact.setPhoneNumber("1234567891");
		updateContact = contactService.getContact(updateContact.getContactID());
		assertTrue(updateContact.getPhoneNumber().equals("1234567891"));
	}
	
	@Test
	void testGetContactAndDeleteSuccess() {
		Contact contact1 = new Contact("1234", "Jane", "Doe", "1234567890", "123 ABC Street");
		
		assertTrue(contactService.addContact(contact1));
		
		Contact contact2 = contactService.getContact(contact1.getContactID());
		assertTrue(contactService.deleteContact(contact2.getContactID())); 
		
		assertTrue(contactService.getContact(contact2.getContactID()) == null); 
	}
	
	@Test
	void testDeleteInvalidContactFail() {
		String invalidContactID =  "1";
		
		assertFalse(contactService.deleteContact(invalidContactID));
	}

}
