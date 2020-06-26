package MultiAspectInheritance;

public class FreeEvent extends TypeEvent {

	private String promoCode;

	public FreeEvent(Event event, String promoCode) {
		super(event);
		setPromoCode(promoCode);
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		//checking if nameEvent is null or empty
		if(promoCode == null || "".equals(promoCode)) {
			throw new IllegalArgumentException("Promotion can not be null or empty.");
		}
		this.promoCode = promoCode;
	}
}
