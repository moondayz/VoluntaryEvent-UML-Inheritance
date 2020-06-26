package DynamicInheritance;

public abstract class OrganizersGroup {

	
	private String nameOG;
	private int capacity;
	
	public OrganizersGroup(String nameOG, int capacity) {
		super();
		setNameOG(nameOG);
		setCapacity(capacity);
	}
	// abstract method
	public abstract boolean isActive();
	
	
	public String getNameOG() {
		return nameOG;
	}

	public void setNameOG(String nameOG) {
		if(nameOG == null || "".equals(nameOG)) {
			throw new IllegalArgumentException("Organizers group name can not be null or empty.");
		}
		this.nameOG = nameOG;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity of the group must be bigger than zero");
		}
		this.capacity = capacity;
	}
}
