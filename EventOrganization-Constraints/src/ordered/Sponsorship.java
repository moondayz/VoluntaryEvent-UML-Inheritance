package ordered;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/*
 *  - Order constraint requires to specify the order of referenced objects (eg. by implementing a Comparator). 
 *   You may use a collection that automatically keeps that order, or manually invoke sorting in the method that adds objects to collection.
 */
public class Sponsorship {

	  private int id;
	    private Set<OrderedSponsor> sponsor;

	    public Sponsorship(int id, Set<OrderedSponsor> sponsor) {
	        this.setId(id);
	        setSponsor(sponsor);
	    }
	    

	    public Set<OrderedSponsor> getSponsor() {
	        return sponsor;
	    }

	    public void setSponsor(Set<OrderedSponsor> sponsor) {
	    	if(sponsor == null) {
	    		throw new IllegalArgumentException("Sponsor can not be null");
	    	}
	        this.sponsor = sponsor;
	    }

	    // order support list  - sorts according to title and name of the sponsor
	    
	    public List<OrderedSponsor> getOrderedSponsor() {
	        List<OrderedSponsor> orderedList = new ArrayList<>();
	        // add all supports to the new list
	        orderedList.addAll(getSponsor());
	        Collections.sort(orderedList);
	        return orderedList;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

}
