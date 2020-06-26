package MultiInheritance;

import java.time.LocalDate;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	
	
	public Person(String firstName, String lastName, LocalDate birthDate) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setDob(birthDate);
		}
	
	// abstract method
	public abstract int getSpendMoneyOnEvent();
	
	public String getFirstName() {
		return firstName;
	}
		
	public void setFirstName(String firstName) {
		if(firstName == null || "".equals(firstName)) {
			throw new IllegalArgumentException("Person name can not be null or empty.");
		}
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName == null || "".equals(lastName)) {
			throw new IllegalArgumentException("Organizer last name can not be null or empty.");
		}
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		int age = LocalDate.now().getYear() - dob.getYear();
		if(age < 18 || dob == null) {
			throw new IllegalArgumentException(" Person must be older than 18 and Birth date can not be null. ");
		}
		
		this.dob = dob;
	}
	
}
