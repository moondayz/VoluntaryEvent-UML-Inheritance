package abstractClassPolymorphism;

public class IndoorActivities extends Activity{
	
	private int rentCost; //renting cost for place or stand
	private int budget;
	
	
	public IndoorActivities(String nameActivity, int capacity, int rentCost, int budget) {
		super(nameActivity, capacity);
		setRentCost(rentCost);
		setBudget(budget);
		
	}
	
	// Polymorphic method 
	@Override
	public int getTotalBudget() {
		
		return getRentCost() + getBudget() ;
	}
	
	public int getRentCost() {
		return rentCost;
	}
	public void setRentCost(int rentCost) {
		if(rentCost == 0 || "".equals(rentCost)) {
			throw new IllegalArgumentException("Renting cost can not be zero or empty.");
		}
		this.rentCost = rentCost;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		if(budget == 0 || "".equals(budget)) {
			throw new IllegalArgumentException("Budget can not be zero or empty.");
		}
		this.budget = budget;
	}
}
