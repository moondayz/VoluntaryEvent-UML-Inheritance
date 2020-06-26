package abstractClassPolymorphism;

public class OutdoorActivities extends Activity {

	private int equipmentCost; // Equipments which will be used for outdoor activity
		
		
		public OutdoorActivities(String nameActivity, int capacity, int equipmentCost) {
			super(nameActivity, capacity);
			setEquipmentCost(equipmentCost);
			
		}
		
		// Polymorphic method 
		@Override
		public int getTotalBudget() {
			
			return getEquipmentCost() ;
		}
		
		public int getEquipmentCost() {
			return equipmentCost;
		}
		public void setEquipmentCost(int equipmentCost) {
			if(equipmentCost == 0 || "".equals(equipmentCost)) {
				throw new IllegalArgumentException("Equipment cost can not be zero or empty.");
			}
			this.equipmentCost = equipmentCost;
		}
}
