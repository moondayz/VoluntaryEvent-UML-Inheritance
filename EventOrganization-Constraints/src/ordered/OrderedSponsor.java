package ordered;

public class OrderedSponsor implements Comparable<OrderedSponsor> {

	private String nameSponsor;
    private String titleSponsor;
    
    public OrderedSponsor(String nameSupport, String titleSponsor) {
    	setNameSponsor(nameSupport);
    	setTitleSponsor(titleSponsor);
    }

	public String getNameSponsor() {
		return nameSponsor;
	}

	public void setNameSponsor(String nameSponsor) {
		if(nameSponsor == null || "".equals(nameSponsor)) {
    		throw new IllegalArgumentException("Sponsor name can not be null or empty");
		}
		this.nameSponsor = nameSponsor;
	}

	public String getTitleSponsor() {
		return titleSponsor;
	}

	public void setTitleSponsor(String titleSponsor) {
		if(titleSponsor == null || "".equals(titleSponsor)) {
    		throw new IllegalArgumentException("Sponsor title can not be null or empty");
		}
		this.titleSponsor = titleSponsor;
	}

	

	@Override
	public int compareTo(OrderedSponsor os) {
		
		 if(os.getNameSponsor().equals(getNameSponsor())) {
	            return getTitleSponsor().compareTo(os.getTitleSponsor());
	        } else {
	            return getNameSponsor().compareTo(os.getNameSponsor());
	        }
	    
	}

}
