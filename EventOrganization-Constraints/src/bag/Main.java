package bag;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

        Organizer org1 = new Organizer(1, "Boran Kuzum", LocalDate.of(1994, 02, 10));
        Organizer org2 = new Organizer(2, "Dilara Moonday", LocalDate.of(1997, 02, 06));        
        
        Event event1 = new Event(101, "Big Gala");
        Event event2 = new Event(202, "Women Tech Markers");

        OrganizesWhen orgWhen = new OrganizesWhen(org1, event1,  LocalDate.of(2022, 12, 01));
        //System.out.println(orgWhen);
        OrganizesWhen orgWhen2 = new OrganizesWhen(org2, event2,  LocalDate.of(2021, 12, 01));

        org1.cancelEvent(event1);	
        

        

        }

}
