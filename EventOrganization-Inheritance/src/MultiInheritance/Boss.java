package MultiInheritance;

import java.time.LocalDate;

public class Boss extends Sponsor implements IOrganizer {
	
	Organizer organizer;
	
	
	public Boss(String firstName, String lastName, LocalDate birthDate , int spendOnEvent, int helpAmount) {
		super(firstName, lastName, birthDate, helpAmount);
		//-------
		organizer = new Organizer(null, null, null, spendOnEvent);
	}
	
	//methods from interface- must be implemented
	@Override
	public int getSpendOnEvent() {
		return organizer.getSpendOnEvent();
	}
	
	
	@Override
	public int getSpendMoneyOnEvent() {
		return super.getSpendMoneyOnEvent();
	}
	@Override
	public void setSpendOnEvent(int spendOnEvent) {
		if(spendOnEvent == 0 || "".equals(spendOnEvent)) {
			throw new IllegalArgumentException("Money can not be zero or empty.");
		}
		organizer.setSpendOnEvent(spendOnEvent);
		
	}

}
