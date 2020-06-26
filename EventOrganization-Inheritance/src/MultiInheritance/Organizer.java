package MultiInheritance;

import java.time.LocalDate;

public class Organizer extends Person implements IOrganizer {

	private int spendOnEvent;
	
	
	public Organizer(String firstName, String lastName, LocalDate birthDate , int spendOnEvent) {
		super(firstName, lastName, birthDate);
		setSpendOnEvent(spendOnEvent);
		
	}
	
	public void setSpendOnEvent(int spendOnEvent) {
		if(spendOnEvent == 0 || "".equals(spendOnEvent)) {
			throw new IllegalArgumentException("Money can not be zero or empty.");
		}
		this.spendOnEvent = spendOnEvent;
	}

	public int getSpendOnEvent() {
		return spendOnEvent;
	}
	// abstract method must be implemented 
	@Override
	public int getSpendMoneyOnEvent() {
		
		return spendOnEvent;
	}

}
