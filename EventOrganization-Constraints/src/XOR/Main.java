package XOR;

public class Main {

	public static void main(String[] args) {

		Sponsor sp1 = new Sponsor(1, "Bob Marley");
		Sponsor sp2 = new Sponsor(2, "Boran Kuzum");

		Individual individual = new Individual("321-111-222");

		Company company = new Company( "444-555-214");

		
		individual.addSponsor(sp1);
		individual.addSponsor(sp2);

		System.out.println("individual sponsor : " + individual.getSponsor());

		sp2.addToCompany(company);
		System.out.println("individual sponsor : " +individual.getSponsor());
		System.out.println("company sponsor : " +company.getSponsor());

		System.out.println("-----------------------");
		Sponsor sp3 = new Sponsor(0, "Hilo Dilo", SponsorType.Individual, "222-555-444");
		System.out.println(sp3);
		company.addSponsor(sp3);

		System.out.println(sp3);
		System.out.println(company.getSponsor());

	}

}
