package attribute_unique_custom;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Event {

	private int idEvent; // unique
	private String nameEvent;
	private int ticketPrice; // dynamic  constraint of attribute
	private int budget; // static constraint of attribute
	private String eventCertificateNo; // custom constraint - own

	private static Set<Integer> ids = new TreeSet<>(); // collection for {unique}
	private static Map<Integer, Event> extent = new TreeMap<>(); // extent. {ordered by id}
	
	private final static int minBudgetPrice = 0;
    private final static int maxBudgetPrice = 500;
    
    private final static int maxIncreasePercentage = 20; // for dynamic constraints


	public Event(int idEvent, String nameEvent, int ticketPrice, int bugdet, String eventCertificateNo) {
		super();
		setIdEvent(idEvent);
		setNameEvent(nameEvent);
		setTicketPrice(ticketPrice);
		setBudget(budget);
		setEventCertificateNo(eventCertificateNo);
		addEventToExtentList(idEvent, this); // add to extent

	}

	public int getIdEvent() {
		return idEvent;
	}
	//----------------------------------- Unique -------------------------------------------------------

	// check uniqueness while setting an id for event
	public void setIdEvent(int idEvent) {
		if (idEvent <= 0) {
			throw new IllegalArgumentException("Id can't be 0 or less than 0");
		}
		// check if it is unique
		if (!isUnique(idEvent)) {
			throw new IllegalArgumentException("Id isn't unique!");
		}
		if (ids.contains(this.idEvent)) {
			ids.remove(this.idEvent);
		}

		this.idEvent = idEvent;
		ids.add(idEvent);

	}

	// Method to check uniqueness - checks if ids set already contains new id
	public boolean isUnique(int idEvent) {
		if (ids.contains(idEvent)) {
			return false;
		}
		return true;
	}

	// ------------------------------Static and dynamic constraints of an attribute ---------------------

	public int getTicketPrice() {
		return ticketPrice;
	}

	// dynamic - while setting, checking the ticket price increment
	public void setTicketPrice(int ticketPrice) {
		if (ticketPrice > (this.ticketPrice + (this.ticketPrice * maxIncreasePercentage / 100))) {
			throw new IllegalArgumentException("Ticket price increase can't be more than max Increase percentage.. ");
		}
		this.ticketPrice = ticketPrice;
	}

	public int getBudget() {
		return budget;
	}

	// static - setting the budget between min and max
	public void setBudget(int budget) {

		if (budget < minBudgetPrice) {
			throw new IllegalArgumentException("You should provide budget equals or more than " + minBudgetPrice);
		}
		if (budget > maxBudgetPrice) {
			throw new IllegalArgumentException("You should provide budget equals or less than " + maxBudgetPrice);
		}
		this.budget = budget;
	}
	// ------------------------------ Custom Constraint ------------------------------
	
	public String getEventCertificateNo() {
		return eventCertificateNo;
	}

	public void setEventCertificateNo(String eventCertificateNo) {
		if (eventCertificateNo == null || "".equals(eventCertificateNo)) {
            throw new IllegalArgumentException("Certificate number of event can't be null or empty");
        }
        if (!eventCertificateNo.matches("^[A-Z]{3}[A-Z0-9]{7}$")) {
            throw new IllegalArgumentException("Certificate number of event should be 10 characters");
        }
		this.eventCertificateNo = eventCertificateNo;
	}

	//-------------------------------------------------------------------------------------------------
	
	// class method
	public static void printEventsFromExtent() {
		for (Map.Entry<Integer, Event> entry : getExtent().entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
	}

	// Adding new event to the extent.
	public static void addEventToExtentList(int idEvent, Event event) {
		extent.put(idEvent, event);
	}

	// Removing the event from extent
	public static void removeEventFromExtentList(int idEvent) {
		extent.remove(idEvent);

	}

	public static Event findEventById(int idEvent) {
		for (Map.Entry<Integer, Event> entry : getExtent().entrySet()) {
			if (entry.getValue().getIdEvent() == idEvent) {
				return entry.getValue();
			}
		}
		return null;
	}

	// Get all ids set
	public static Set<Integer> getIds() {
		Set<Integer> copyIds = ids;
		return copyIds;
	}

	// Get map of all events ordered by id
	public static Map<Integer, Event> getExtent() {
		Map<Integer, Event> copyOfExtent = extent;
		return copyOfExtent;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		// checking if nameEvent is null or empty
		if (nameEvent == null || "".equals(nameEvent)) {
			throw new IllegalArgumentException("Event name can not be null or empty.");
		}
		this.nameEvent = nameEvent;
	}


	 public String toString() {
	        return getNameEvent() + " is  " + getTicketPrice() + " PLN " ;
	    }


}
