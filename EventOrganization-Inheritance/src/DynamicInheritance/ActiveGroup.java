package DynamicInheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import OverlappingInheritance.Event;

public class ActiveGroup extends OrganizersGroup{
	
	public LocalDate whenStarted;
	public static List<ActiveGroup> extent = new ArrayList<ActiveGroup>();

	
	public ActiveGroup(String nameOG, int capacity, LocalDate whenStarted) {
		super(nameOG, capacity);
		setWhenStarted(whenStarted);
		extent.add(this);
		
	}

	public boolean isActive() {
		return true;
	}
	
	// dynamic inheritance 
	public void inactivate() {
		
		OrganizersGroup inact1 = new InactiveGroup(this.getNameOG(), this.getCapacity(), LocalDate.now());
		//remove old status from extent
		extent.remove(this);
		
	}
	
	public static ArrayList<ActiveGroup> getExtent() {
		return new ArrayList<ActiveGroup>(extent);
	}
	
	
	public LocalDate getWhenStarted() {
		return whenStarted;
	}
	public void setWhenStarted(LocalDate whenStarted) {
		
		if( whenStarted.isAfter(LocalDate.now())|| whenStarted == null) {
			throw new IllegalArgumentException(" Group activation date can not be from future or null. ");
		}
		
		this.whenStarted = whenStarted;
	}
	
}
