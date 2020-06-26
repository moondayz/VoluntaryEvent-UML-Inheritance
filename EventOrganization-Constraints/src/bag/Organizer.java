package bag;

import java.time.LocalDate;
import java.util.ArrayList;
/*
 *  Bag constraint can be implemented as association with attribute. 
 *  All association restrictions apply (including creating reverse reference, and method to remove the association).
 */

public class Organizer {

	// association class
	private ArrayList<OrganizesWhen> organizesWhen = new ArrayList<OrganizesWhen>();

	private int idOrg;
	private String fullName;
	private LocalDate dob;

	public Organizer(int idOrg, String fullName, LocalDate dob) {
		super();
		this.idOrg = idOrg;
		setDob(dob);
		setFullName(fullName);
	}

	// ---------------------------------------------With an attribute ---------------------------------------------

	// adding a association class - here it creates an OrganizeWhen table automatically
	public void organize(Event event, LocalDate dateEvent) {
		if (event == null || dateEvent == null) {
			throw new IllegalArgumentException("Event or date event can not be null");
		}
		if (!organizesWhen.contains(event)) {
			organizesWhen.add(new OrganizesWhen(this, event, dateEvent));
			// reverse connection
			event.setDateEvent(dateEvent);
		}

	}
	/// remove organizing -  deletes info from association class too.

	public void cancelEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException("Event can not be null");
		}
		if (organizesWhen.contains(event)) {
			// remove association class
			organizesWhen.remove(this);
			// reverse connection
			event.removeDateEvent(event.getDateEvent());
		}
	}

	// -----------------------------------------------------------------------------------------------------------

	// getter for event date (middle class)
	public ArrayList<OrganizesWhen> getOrganizesWhen() {
		return organizesWhen;
	}

	public int getIdOrg() {
		return idOrg;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		if (fullName == null || "".equals(fullName)) {
			throw new IllegalArgumentException("Organizer name can not be null or empty.");
		}
		this.fullName = fullName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		int age = LocalDate.now().getYear() - dob.getYear();
		if (age < 18 || dob == null) {
			throw new IllegalArgumentException(" Organizer must be older than 18 and Birth date can not be null. ");
		}
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Organizer : " + fullName + " dob " + dob;
	}

}
