package subset;

public class Main {

	public static void main(String[] args) {

		Organizer org = new Organizer(1, "Bob Marley ");
        OrganizersGroup og = new OrganizersGroup(10, "Say Hello");
        Organizer org2 = new Organizer(2,"Lana Del Rey ");
        
        org.joinGroup(og);
        og.addOrganizer(org2);

        System.out.println(og);
        System.out.println("==========================");
  
        og.setManager(org);
        System.out.println(og);
        System.out.println("===========================");
        og.setManager(org2);
        org.stopBeingManagerOfGroup(og);
        System.out.println(og);
		
	}

}
