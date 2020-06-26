package MultiAspectInheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class Event  {

	private int idEvent;
	private String nameEvent;
	private TypeEvent typeEvent;

	
	public static List<Event> extent = new ArrayList<Event>();

	
	public Event(int idEvent, String nameEvent ) {
		super();
		this.idEvent = idEvent;
		setNameEvent(nameEvent);
		extent.add(this); // adds to the extent whenever new object is created	
		
	}
	
	// constructor for paid event
	public Event(int idEvent, String nameEvent , int ticketPrice) {
		super();
		this.idEvent = idEvent;
		setNameEvent(nameEvent);
		extent.add(this); // adds to the extent whenever new object is created	
		TypeEvent paidEvent = new PaidEvent(this , ticketPrice);
		
	}
	
	// constructor for free event
	public Event(int idEvent, String nameEvent , String promoCode) {
		super();
		this.idEvent = idEvent;
		setNameEvent(nameEvent);
		extent.add(this); // adds to the extent whenever new object is created	
		TypeEvent freeEvent = new FreeEvent(this ,  promoCode);
			
	}
		
	//Setting Event Type
	public void setTypeEvent(TypeEvent typeEvent) {
		 if (typeEvent == null) {
	            typeEvent.setBase(this);
	            this.typeEvent = typeEvent;
	        }
	}
	
	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		
		//checking if nameEvent is null or empty
		if(nameEvent == null || "".equals(nameEvent)) {
			throw new IllegalArgumentException("Event name can not be null or empty.");
		}
		this.nameEvent = nameEvent;
	}
	
	public static List<Event> getExtent() {
		return new ArrayList<Event>(extent);
	}


}
