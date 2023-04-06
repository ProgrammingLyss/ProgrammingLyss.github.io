package contact;

import java.util.HashMap; 
import java.util.Map; 

public class ContactService {
	
	private static ContactService reference = new ContactService(); 
	private final Map<String, Contact> contacts; 
	
	ContactService() {
		this.contacts = new HashMap<String, Contact>();
	} 
	
	public static ContactService getService() {
		return reference; 
	}
	
	public boolean addContact(Contact contact) { 
		boolean isSuccess = false;
		
		if(!contacts.containsKey(contact.getContactID())) {
			contacts.put(contact.getContactID(), contact);
			isSuccess = true;
		}
		return isSuccess; 
	}
	
	public boolean deleteContact(String contactID) { 
		return contacts.remove(contactID) != null; 
	}
	
	public Contact getContact(String contactID) { 
		return contacts.get(contactID); 
	}
}
