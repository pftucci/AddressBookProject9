public class ContactProject9 {
	
	public String name;
	public String email;
	public String phoneNumber;
	
	
	public ContactProject9(String name, String email, String phoneNumber) throws InvalidPhoneNumberException, InvalidEmailException {
		
		this.name = name;
		
		if (email.contains("@") && email.contains(".")) {
			this.email = email;
		} else {
			throw new InvalidEmailException(email);
		}
		
		if (phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidPhoneNumberException(phoneNumber);
		}
	}
	
	public String getStringToPrint() {
		String x = "Name: " + name + "\nEmail: " + email + "\nPhone number: " + phoneNumber;
		return x;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidEmailException {
		if (email.contains("@") && email.contains(".")) {
			this.email = email;
		} else {
			throw new InvalidEmailException(email);
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidPhoneNumberException(phoneNumber);
		}
	}

}
