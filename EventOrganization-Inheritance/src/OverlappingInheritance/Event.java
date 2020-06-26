package OverlappingInheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

// Overlapping - we need to create event with many categories
public class Event implements IConference , IGala, IReunion, IParty {

	private int idEvent;
	private String nameEvent;
	private LocalDate releaseDate;
	
	public static List<Event> extent = new ArrayList<Event>();
	
	public List<String> speakers = new ArrayList<String>();

	// Because we can have few different option at ones, we need to store it.
	private EnumSet<eventCategory> categories;
	
	public enum eventCategory {
		Conference,
		Reunion,
		Party,
		Gala
	}
	
	public Event(int idEvent, String nameEvent, LocalDate releaseDate, EnumSet<eventCategory> categories, String speaker ) {
		super();
		this.idEvent = idEvent;
		setNameEvent(nameEvent);
		setReleaseDate(releaseDate);
		setCategories(categories);
		// adds to the extent whenever new object is created
		extent.add(this);
		
		// checks -  if we are in a proper category
		if(categories.contains(eventCategory.Conference)) {
			this.speakers.add(speaker);		}
		
	}
	
	/*
	public Event(int idEvent, String nameEvent, LocalDate releaseDate, EnumSet<eventCategory> categories ) {
		super();
		this.idEvent = idEvent;
		setNameEvent(nameEvent);
		setReleaseDate(releaseDate);
		setCategories(categories);
		// adds to the extent whenever new object is created
		extent.add(this);
		
	}
	*/
	private void setCategories(EnumSet<eventCategory> categories) {
		if(categories == null || categories.isEmpty()) {
			throw new IllegalArgumentException("Category can not be null or empty."); 
		}
		this.categories = categories;
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

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		
		if(releaseDate == null) {
			throw new IllegalArgumentException("Date of release can not be null or empty.");
		}
		if(releaseDate.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Date of event can not be from the future.");
		}
		this.releaseDate = releaseDate;
	}

	// methods from IConference interface
	@Override
	public List<String> getSpeakers() {
		if(!categories.contains(eventCategory.Conference)) {
			throw new IllegalArgumentException("Event is not a conference.");
		}
		// we return a copy of it
		return new ArrayList<String>(speakers);
	}

	@Override
	public void addSpeaker(String speaker) {
		// check if we are in a proper event to use this method
		if(!categories.contains(eventCategory.Conference)) {
			throw new IllegalArgumentException("Event is not a conference.");
		}		
		if(speaker == null || "".equals(speaker)) {
			throw new IllegalArgumentException("Speaker can not be null or empty");
		}
		this.speakers.add(speaker);
	}

	@Override
	public void removeSpeaker(String speaker) {
		if(!categories.contains(eventCategory.Conference)) {
			throw new IllegalArgumentException("Event is not a conference.");
		}	
		if(speaker == null || "".equals(speaker)) {
			throw new IllegalArgumentException("Speaker can not be null or empty");
		}
		this.speakers.remove(speaker);
	}
}
