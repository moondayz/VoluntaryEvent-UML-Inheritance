package MultiAspectInheritance;

public class PaidEvent  extends TypeEvent{
	private int ticketPrice;
	
	public PaidEvent(Event event, int ticketPrice) {
		super(event);
		setTicketPrice(ticketPrice);
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		//checking if event ticket price is null or empty
		if(ticketPrice == 0 || "".equals(ticketPrice)) {
			throw new IllegalArgumentException("Ticket Price can not be zero or empty.");
		}
		this.ticketPrice = ticketPrice;
	}

	
}
