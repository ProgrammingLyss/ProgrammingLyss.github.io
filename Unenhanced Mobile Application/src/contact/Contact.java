package contact;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		if(contactID == null || contactID.length()>10) {
			throw new IllegalArgumentException("Invalid entry. Please enter an ID in 10 characters or less.");
		} 
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid entry. Please enter a name in 10 characters or less.");
		} 
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid entry. Please enter a name in 10 characters or less.");
		} 
		if(phoneNumber == null || phoneNumber.length()>10 || phoneNumber.length()<10) {
			throw new IllegalArgumentException("Invalid entry. Please enter a 10 digit phone number.");
		} 
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid entry. Please enter an address in 30 characters or less."); 
		}  
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address; 
	}
	
	
	public String getContactID() {
		return contactID; 
	}
	
	public String getFirstName() {
		return firstName; 
	}
	
	public String getLastName() {
		return lastName; 
	}
	
	public String getPhoneNumber() {
		return phoneNumber; 
	}
	
	public String getAddress() {
		return address;
	}
	
	
	public void setFirstName(String firstName) {
		if(firstName.length() <= 10 &&  firstName != null) {
			this.firstName = firstName; 
		}
	}
	
	public void setLastName(String lastName) {
		if(lastName.length() <= 10 && lastName != null) {
			this.lastName = lastName;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() == 10 && phoneNumber != null) {
			this.phoneNumber = phoneNumber; 
		}
		
	}
	
	public void setAddress(String address) {
		if(address.length() <= 30 && address != null) {
			this.address = address; 
		}
	}

}
