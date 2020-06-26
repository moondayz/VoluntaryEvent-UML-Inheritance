package subset;

import java.util.HashSet;
import java.util.Set;

public class OrganizersGroup {

	private long id;
    private String nameOG;
    private Organizer manager;
    private Set<Organizer> organizers = new HashSet<>();

    public OrganizersGroup(long id, String nameOG) {
        this.setId(id);
        this.setNameOG(nameOG);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOG() {
		return nameOG;
	}

	public void setNameOG(String nameOG) {
		if(nameOG == null || "".equals(nameOG)) {
			throw new IllegalArgumentException("Organizer's Group name can not be null or empty.");
		}
		this.nameOG = nameOG;
	}
	
	// first link - organizer - group -  being member -----------------------------------------------------------------
	
	// check if this organizer is in the group
	 private boolean hasGroupMember(Organizer organizer){
	        if(this.organizers.contains(organizer)){
	            return true;
	        }
	        return false;
	    }

	 	// add organizer to the group
	    public void addOrganizer(Organizer organizer){
	        if(!hasGroupMember(organizer)){
	            this.organizers.add(organizer);
	            //reverse method
	            organizer.joinGroup(this);
	        }
	    }

	    // remove organizer from the group + reverse method
	    public void removeOrganizer(Organizer organizer){
	        if(hasGroupMember(organizer)){
	            this.organizers.remove(organizer);
	            // reverse method
	            organizer.leaveTheGroup(this);
	        }
	    }

	    // -------- second link - organizer/ group - being a manager - {subset} ---------------------------------
	    
	    public Organizer getManager() {
	        return manager;
	    }

	    public void setManager(Organizer manager) {
	        if(manager == null){
	            removeManager();
	        }
	        // same manager
	        else if(manager == this.manager){
	            return;
	        }
	        // if the manager is a member of the group - remove last manager and add the new one
	        if(hasGroupMember(manager)){
	            if(this.manager != null){
	                this.manager.stopBeingManagerOfGroup(this);
	            }
	            this.manager = manager;
	            manager.becomeManagerOfGroup(this);
	        }
	        else{
	            throw new IllegalArgumentException("This organizer isn't in this Department.So can't be a manager");
	        }

	    }

	    public void removeManager(){
	        this.manager = null;
	    }

	    public Set<Organizer> getOrganizers() {
	        Set<Organizer> copyOfOrganizers = this.organizers;
	        return copyOfOrganizers;
	    }

	    public String toString(){
	        String organizer = "Organizers: ";
	        for(Organizer org : getOrganizers()){
	        	organizer+=org.getNameOrg();
	        }
	        return getId() + " " + getNameOG() + "\n" + organizer + "\n" + "Manager: " + getManager();
	    }

}

