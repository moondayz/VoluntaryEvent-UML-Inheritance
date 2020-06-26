package DynamicInheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import OverlappingInheritance.Event;

public class InactiveGroup extends OrganizersGroup{
	
	public LocalDate whenFinished;
	public static List<InactiveGroup> extent = new ArrayList<InactiveGroup>();

	
	public InactiveGroup(String nameOG, int capacity, LocalDate whenFinished) {
		super(nameOG, capacity);
		setWhenFinished(whenFinished);
		extent.add(this);
		
	}
	
	// dynamic inheritance 
	public void activate() {
			
		OrganizersGroup act1 = new ActiveGroup(this.getNameOG(), this.getCapacity(), LocalDate.now());
		//remove old from extent
		extent.remove(this);		
			
	}

	public boolean isActive() {
		return true;
	}
	
	public static ArrayList<InactiveGroup> getExtent() {
		return new ArrayList<InactiveGroup>(extent);
	}
	
	public LocalDate getWhenFinished() {
		return whenFinished;
	}
	public void setWhenFinished(LocalDate whenFinished) {
		
		if( whenFinished.isAfter(LocalDate.now())|| whenFinished == null) {
			throw new IllegalArgumentException(" Group activation end date can not be from future or null. ");
		}
		
		this.whenFinished = whenFinished;
	}

}
