package MultiAspectInheritance;

import java.util.ArrayList;

public class Party extends Event {
	
	//for free event
		public Party(int idEvent, String nameEvent , ArrayList<String> speakers) {
			super(idEvent, nameEvent);
		}
		
		// for paid event with ticket price in the constructor
		public Party(int idEvent, String nameEvent , ArrayList<String> speakers , int ticketPrice) {
			super(idEvent, nameEvent, ticketPrice);
		}

}
