package XOR;

import java.util.HashSet;
import java.util.Set;

public class Individual {
	
	    private String taxPayerId;
	    private Set<Sponsor> sponsors = new HashSet<>();

	    public Individual( String taxPayerId) {
	        this.setTaxPayerId(taxPayerId);
	    }


	    public String getTaxPayerId() {
	        return taxPayerId;
	    }

	    public void setTaxPayerId(String taxPayerId) {
	        if (taxPayerId == null) {
	            throw new IllegalArgumentException("Tax payer id can't be null!");
	        }
	        this.taxPayerId = taxPayerId;
	    }

	    public void addSponsor(Sponsor sponsor) {
	        if (!this.sponsors.contains(sponsor)) {
	            this.sponsors.add(sponsor);
	            // reverse method
	            sponsor.addToIndividual(this);
	        }
	    }

	    public void removeSponsor(Sponsor sponsor) {
	        if (this.sponsors.contains(sponsor)) {
	            this.sponsors.remove(sponsor);
	            // reverse method
	            sponsor.removeSponsor();
	        }
	    }

	    public Set<Sponsor> getSponsor() {
	       
	        return new HashSet<Sponsor>(sponsors);
	    }

	    public String toString() {
	        return getTaxPayerId();
	    }
}
