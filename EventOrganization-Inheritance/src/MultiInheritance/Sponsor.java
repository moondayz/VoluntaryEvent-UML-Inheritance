package MultiInheritance;

import java.time.LocalDate;

public class Sponsor extends Person{

	private int helpAmount;
	
	public Sponsor(String firstName, String lastName, LocalDate birthDate , int helpAmount) {
		super(firstName, lastName, birthDate);
		setHelpAmount(helpAmount);
		
	}
	
	private void setHelpAmount(int helpAmount) {
		if(helpAmount == 0 || "".equals(helpAmount)) {
			throw new IllegalArgumentException("Help amount can not be zero or empty.");
		}
		this.helpAmount = helpAmount;
	}
	public int getHelpAmount() {
		return helpAmount;
	}

	// abstract method must be implemented 
	@Override
	public int getSpendMoneyOnEvent() {
		// TODO Auto-generated method stub
		return getHelpAmount();
	}

}
