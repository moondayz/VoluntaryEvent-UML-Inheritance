package XOR;

enum SponsorType {
	Company, Individual
}

public class Sponsor {

	private long id;
	private String fullName;
	private Company company;
	private Individual individual;

	public Sponsor(long id, String fullName) {
		this.id = id;
		this.setFullName(fullName);

	}

	public Sponsor(long id, String fullName, SponsorType SponsorType, String taxPayerId) {
		this.id = id;
		this.setFullName(fullName);

		// Check the sponsor type and add it to the defined type
		if (SponsorType == SponsorType.Company) {

			this.company = new Company(taxPayerId);
			this.company.addSponsor(this);

		} else if (SponsorType == SponsorType.Individual) {

			this.individual = new Individual(taxPayerId);
			this.individual.addSponsor(this);
		}
	}

	// --------------------Add Sponsor to the company or as an individual
	// -------------------------------------------------------------------------------------------

	// Add sponsor to the company and remove being individual sponsor
	public void addToCompany(Company company) {

		if (company == null) {
			throw new IllegalArgumentException("Company can't be null");
		}
		if (this.company == company) {
			return;
		}
		this.company = company;
		// remove individual sponsor - it can be only one of them.
		if (this.individual != null) {
			getIndividual().removeSponsor(this);
		}
		// reverse method
		company.addSponsor(this);

	}

	// Add sponsor as an individual and remove company sponsor
	public void addToIndividual(Individual individual) {

		if (individual == null) {
			throw new IllegalArgumentException("Individual can't be null");
		}
		if (this.individual == individual) {
			return;
		}
		this.individual = individual;

		// remove company sponsor - it can be only one of them.
		if (this.company != null) {
			getCompany().removeSponsor(this);
		}
		// reverse method
		individual.addSponsor(this);

	}

	// --------------------Remove Sponsor from the company or from being an
	// individual
	// -------------------------------------------------------------------------------------------

	public void removeSponsor() {
		if (this.company != null) {
			this.company.removeSponsor(this);
			this.company = null;
		}
		if (this.individual != null) {
			this.individual.removeSponsor(this);
			this.individual = null;
		}
	}

	// ------------------ Getters for company and individual
	// ------------------------------------------------------------------------------------------------------------------------------

	public Company getCompany() {
		if (this.company == null) {
			throw new IllegalArgumentException("Its not a sponsor of Company ");
		}
		return company;
	}

	public Individual getIndividual() {
		if (this.individual == null) {
			throw new IllegalArgumentException("It is not an individual Sponsor");
		}
		return individual;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		if (fullName == null) {
			throw new IllegalArgumentException("Full name can't be null");
		}
		this.fullName = fullName;
	}
	public String toString() {
        return "\nSponsor: " + getFullName() + "\n" + (this.company != null ? "Sponsor type :  " + company.getClass().getSimpleName() + ", tax payer id : " + getCompany(): "Not company")
                + "\n" + (this.individual != null ? "Sponsor type : " + individual.getClass().getSimpleName() + ", tax payer id : " + getIndividual() : "Not individual");
    }


}