package MultiAspectInheritance;

import java.util.HashSet;

public class TypeEvent {

	 private Event base;
	 private static HashSet<TypeEvent> allTypes;

	 public TypeEvent(Event base) {
	        
	     setBase(base);
	     allTypes.add(this);
	 }

	 // check for dublicate on the base
	 private void checkDublicate(Event base) {
	      for (TypeEvent typeEvent : allTypes) {
	          if (typeEvent.getBase().equals(base)) {
	              throw new RuntimeException("Base already has the type");
	          }
	      }
     }
	 
	 public Event getBase() {
	        return base;
	    }

	    public void setBase(Event base) {
	        if (base == null) {
	            try {
	                checkDublicate(base);
	                this.base = base;
	                base.setTypeEvent(this);
	            } catch (RuntimeException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
}
