package bag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {

	public static List<Event> extent = new ArrayList<Event>();

	private int idEvent;
	private String nameEvent;
	private LocalDate dateEvent;

	public Event(int idEvent, String nameEvent) {
		super();
		this.idEvent = idEvent;
		setNameEvent(nameEvent);
		
		// adds to the extent whenever new object is created
		extent.add(this);

	}

	// -------------------------------------WITH AN ATTRIBUTE ----- REVERSE-----------------------------
	
		// when organize(class organizer) method is called we set the date for event - 
		public void setDateEvent(LocalDate dateEvent) {
			if(dateEvent == null) {
				throw new IllegalArgumentException("Event date can not be null");
			}
			this.dateEvent = dateEvent;
		}
		
		// reverse for canceling event - it removes the date event
		public void removeDateEvent(LocalDate dateEvent) {
			this.dateEvent = null;
		}
		
		
	// -----------------------------------------------------------------------------------------------------------------------

		public LocalDate getDateEvent() {
			return dateEvent;
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
}
