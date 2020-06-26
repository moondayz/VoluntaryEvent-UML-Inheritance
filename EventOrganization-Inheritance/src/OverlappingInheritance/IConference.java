package OverlappingInheritance;

import java.util.List;

public interface IConference {

	public List<String> getSpeakers();
	public void addSpeaker(String speaker );
	public void removeSpeaker(String speaker );

}
