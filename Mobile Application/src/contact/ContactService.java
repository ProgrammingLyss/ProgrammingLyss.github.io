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
package contact;

import java.util.HashMap; // import HashMap class
import java.util.Map; 

public class ContactService {
	
	private static ContactService reference = new ContactService(); 
	private final Map<String, Contact> contacts; 
	
	ContactService() {
		this.contacts = new HashMap<String, Contact>();
	} // ContactService uses the HashMap data structure to store contacts with String keys and Contact values
	
	public static ContactService getService() {
		return reference; 
	}
	
	public boolean addContact(Contact contact) { // add a contact
		boolean isSuccess = false;
		
		if(!contacts.containsKey(contact.getContactID())) {
			contacts.put(contact.getContactID(), contact);
			isSuccess = true;
		}
		return isSuccess; 
	}
	
	public boolean deleteContact(String contactID) { // delete a contact
		return contacts.remove(contactID) != null; 
	}
	
	public Contact getContact(String contactID) { // retrieve a contact
		return contacts.get(contactID); 
	}
}
