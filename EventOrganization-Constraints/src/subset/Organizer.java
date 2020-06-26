package subset;

import java.util.HashSet;
import java.util.Set;

public class Organizer {

	private long idOrg;
	private String nameOrg;
	private Set<OrganizersGroup> memberOfGroup = new HashSet<>();
	private Set<OrganizersGroup> managerOfGroup = new HashSet<>();

	public Organizer(long idOrg, String nameOrg) {
		this.idOrg = idOrg;
		this.nameOrg = nameOrg;
	}

	public long getId() {
		return idOrg;
	}

	public void setId(long idOrg) {
		this.idOrg = idOrg;
	}

	public String getNameOrg() {
		return nameOrg;
	}

	public void setNameOrg(String nameOrg) {
		if (nameOrg == null || "".equals(nameOrg)) {
			throw new IllegalArgumentException("Organizer name can not be null or empty.");
		}
		this.nameOrg = nameOrg;
	}

	// first link - being a member of group - for second link the first must exist

	private boolean isMemberOfGroup(OrganizersGroup OG) {
		if (this.memberOfGroup.contains(OG)) {
			return true;
		}
		return false;
	}

	public void joinGroup(OrganizersGroup OG) {
		if (!isMemberOfGroup(OG)) {
			this.memberOfGroup.add(OG);
			// reverse method
			OG.addOrganizer(this);
		}
	}

	public void leaveTheGroup(OrganizersGroup OG) {
		if (isMemberOfGroup(OG)) {
			this.memberOfGroup.remove(OG);
			// reverse method
			OG.removeOrganizer(this);
		}
	}

	// --------- second link - depends on first link {subset}
	// -------------------------------------------------------------------------------------------------------

	// checks if organizer is manager of the group
	private boolean isManagerOfGroup(OrganizersGroup OG) {
		if (this.managerOfGroup.contains(OG)) {
			return true;
		}
		return false;
	}

	// makes the organizer manager
	public void becomeManagerOfGroup(OrganizersGroup OG) {

		// checks if the organizer is member of the group - without being member, he/she
		// can not be a manager.
		if (isMemberOfGroup(OG)) {
			if (!isManagerOfGroup(OG)) {
				this.managerOfGroup.add(OG);
				// reverse method
				OG.setManager(this);
			}
		} else {
			throw new IllegalArgumentException(
					"The organizer can not be a manager because its not member of the group.");
		}
	}

	public void stopBeingManagerOfGroup(OrganizersGroup OG) {
		if (isManagerOfGroup(OG)) {
			this.managerOfGroup.remove(OG);
			// reverse method
			OG.removeManager();
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------

	public Set<OrganizersGroup> getMemberOfGroup() {
		Set<OrganizersGroup> copyOfGroups = this.memberOfGroup;
		return copyOfGroups;
	}

	public Set<OrganizersGroup> getManagerOfGroup() {
		Set<OrganizersGroup> copyOfManagerOfGroups = this.managerOfGroup;
		return copyOfManagerOfGroups;
	}

	public String toString() {
		String group = "Groups: ";
		for (OrganizersGroup og : getMemberOfGroup()) {
			group += og.getNameOG();
		}
		String mg = "Manager groups: ";
		for (OrganizersGroup og : getManagerOfGroup()) {
			mg += og.getNameOG();
		}
		return getId() + " " + getNameOrg() + "\n" + group + "\n" + mg;
	}
}
