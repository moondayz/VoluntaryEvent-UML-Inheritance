package abstractClassPolymorphism;

import java.time.LocalDate;

import MultiAspectInheritance.Event;

public class Main {

	public static void main(String[] args) {
		
		//1 - An abstract class and polymorphic method invocation
		Activity inAct1 = new IndoorActivities("Drawing" , 10, 500 , 460);
		Activity outAct1 = new OutdoorActivities("Paintball" , 30 ,3200);
		
		System.out.println("Total budget for Indoor Activity 1 : " +inAct1.getTotalBudget() + " PLN");
		System.out.println("Total budget for Outdoor Activity 1 : " +outAct1.getTotalBudget() + " PLN");
		
		// 3- multi-inheritance 
		
		// 4- Multi-aspect inheritance
		
		LocalDate rd1 = LocalDate.of(2019, 4, 12); // Release Date
		LocalDate rd2 = LocalDate.of(2019, 6, 24); // Release Date
		

	
		
		//FreeEventType freeEvent = new FreeEventType("free" , event1 , 100);


	}

}
