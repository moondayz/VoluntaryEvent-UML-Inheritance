package abstractClassPolymorphism;

public abstract class Activity {
	
	private String nameActivity;
	private int capacity;
	
	public Activity(String nameActivity, int capacity) {
		setNameActivity(nameActivity);
		setCapacity(capacity);
	}

	
	// Polimorphic Method
	public abstract int getTotalBudget();
	
	
	private void setNameActivity(String nameActivity) {
		
		if(nameActivity == null || "".equals(nameActivity)) {
			throw new IllegalArgumentException("Activity name can not be null or empty.");
		}
		this.nameActivity = nameActivity;
	}
	

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(capacity == 0 || "".equals(capacity)) {
			throw new IllegalArgumentException("Capacity can not be zero or empty.");
		}
		this.capacity = capacity;
	}
}
