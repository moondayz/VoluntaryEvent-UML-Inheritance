package MultiAspectInheritance;

import java.util.ArrayList;
import java.util.List;

public class Conference extends Event {
	
	private List<String> speakers = new ArrayList<String>();

	//for free event
	public Conference(int idEvent, String nameEvent , ArrayList<String> speakers) {
		super(idEvent, nameEvent);
		setSpeakers(speakers);
	}
	
	// for paid event with ticket price in the constructor
	public Conference(int idEvent, String nameEvent , ArrayList<String> speakers , int ticketPrice) {
		super(idEvent, nameEvent, ticketPrice);
		setSpeakers(speakers);
	}

	
	public List<String> getSpeakers() {
		
		return new ArrayList<String>(speakers);
	}

	public void setSpeakers(List<String> speakers) {
		if(speakers == null || "".equals(speakers)) {
			throw new IllegalArgumentException("Speaker can not be null or empty.");
		} 
		if(speakers.contains(speakers)) {
			throw new IllegalArgumentException("Speaker is already exist.");
		}
		this.speakers = speakers;
	}

}
